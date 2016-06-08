package com.td.bbwp.web.action.bbwpcase;

import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.web.RequestParameter;
import org.witchcraft.exceptions.BusinessException;

import com.td.bbwp.core.domain.bbwpcase.CaseDefinition;
import com.td.bbwp.core.domain.bbwpcase.CaseInstance;
import com.td.bbwp.core.domain.bbwpcase.CaseTaskDefinition;
import com.td.bbwp.core.domain.bbwpcase.CaseTaskFieldValue;
import com.td.bbwp.core.domain.bbwpcase.CaseTaskInstance;
import com.td.bbwp.core.domain.bbwpcase.TaskField;
import com.td.bbwp.web.action.userprofile.AssociateAction;

//@Scope(ScopeType.CONVERSATION)
@Name("caseTaskInstanceAction")
public class CaseTaskInstanceAction extends CaseTaskInstanceActionBase
		implements java.io.Serializable {

	@RequestParameter
	private Long processInstanceId;

	@RequestParameter
	private String processName;

	@RequestParameter
	private String taskName;

	@RequestParameter
	protected Long taskInstanceId;
	
	@In(create=true)
	AssociateAction associateAction;

	@Override
	public void load() {

		CaseInstance caseInstance = getCaseForMe();

		CaseTaskDefinition taskDefinition = executeSingleResultQuery(
				"Select d from CaseTaskDefinition d where d.name = ?1 and d.caseDefinition = ?2",
				taskName, caseInstance.getCaseDefinition());

		if (taskDefinition == null)
			throw new BusinessException("No Such Task definition configured "
					+ taskName);

		CaseTaskInstance caseTaskInstance = new CaseTaskInstance();
		caseTaskInstance.setCaseTaskDefinition(taskDefinition);

		caseInstance.addCaseTaskInstance(caseTaskInstance);
		
		caseTaskInstance.setBpmTaskId(taskInstanceId);

		setInstance(caseTaskInstance);

		selectionChanged();
	}
	
	
	public String executeAction(String actionName){
		
		associateAction.completeTask(getInstance().getBpmTaskId().toString(), actionName);
		save();
		return SUCCESS;
	}
	
	
	public CaseInstance getPotential() {

		String qry = "Select c from CaseInstance c where c.processInstanceId = ?1 ";
		CaseInstance caseInstance = executeSingleResultQuery(qry,
				processInstanceId);

		if (caseInstance == null) {
			caseInstance = new CaseInstance();
			CaseDefinition caseDefinition = executeSingleResultQuery(
					"Select d from CaseDefinition d where d.name = ?1 ",
					processName);

			if (caseDefinition == null)
				throw new BusinessException(
						"No Such Case definition configured " + processName);

			caseInstance.setCaseDefinition(caseDefinition);
		}

		return caseInstance;
	}
	

	public CaseInstance getCaseForMe() {

		String qry = "Select c from CaseInstance c where c.processInstanceId = ?1 ";
		CaseInstance caseInstance = executeSingleResultQuery(qry,
				processInstanceId);

		if (caseInstance == null) {
			caseInstance = new CaseInstance();
			CaseDefinition caseDefinition = executeSingleResultQuery(
					"Select d from CaseDefinition d where d.name = ?1 ",
					processName);

			if (caseDefinition == null)
				throw new BusinessException(
						"No Such Case definition configured " + processName);

			caseInstance.setCaseDefinition(caseDefinition);
		}

		return caseInstance;
	}

	public void selectionChanged() {
		if (isNew()) {
			List<TaskField> fields = getInstance().getCaseTaskDefinition()
					.getTaskFields();

			getInstance().getCaseTaskFieldValues().clear();

			for (TaskField field : fields) {
				// field.getN
				CaseTaskFieldValue fv = new CaseTaskFieldValue();
				fv.setTaskField(field);
				// field.getFieldType().getName()
				getInstance().addCaseTaskFieldValue(fv);
			}
		}
	}

}
