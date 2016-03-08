package com.univeris.cxp.investors;

import javax.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;

import com.univeris.ewm.provider.data.basedataaccess.BaseEntity;

//import javax.validation.constraints.*;

import java.math.BigDecimal;

//import org.hibernate.search.annotations.Analyzer;
//import org.hibernate.search.annotations.Indexed;

import com.univeris.uifcommon.dataobjects.MultilingualText;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@MappedSuperclass
//@Indexed
//@Analyzer(definition = "entityAnalyzer")
public abstract class InvestingGoalPlanCodeBase extends BaseEntity<Integer>

{

	/* */

	/* */

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "INVESTING_GOAL_CODE", unique = false)
	protected String investingGoalCode

	;

	public void setInvestingGoalCode(String investingGoalCode) {
		this.investingGoalCode = investingGoalCode;
	}

	public String getInvestingGoalCode() {

		return investingGoalCode;
	}

	@Transient
	public String getDisplayName() {
		try {
			return investingGoalCode;
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Integer _id;

	@Override
	public Integer getPK() {
		return getId(); //To change body of implemented methods use File | Settings | File Templates.
	}

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

}
