package com.univeris.cxp.questionnaire;

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
public abstract class MappingEntryBase extends BaseEntity<Integer>

{

	/* */

	/* */

	@Column(name = "MIN", unique = false)
	protected Integer min

	;

	/* */

	/* */

	@Column(name = "MAX", unique = false)
	protected Integer max

	;

	/* */

	/* */

	@Column(name = "OUTCOME", unique = false)
	protected StrategyOutcome outcome

	;

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMin() {

		return min;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMax() {

		return max;
	}

	public void setOutcome(StrategyOutcome outcome) {
		this.outcome = outcome;
	}

	public StrategyOutcome getOutcome() {

		return outcome;
	}

	@Transient
	public String getDisplayName() {
		try {
			return min + "";
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
