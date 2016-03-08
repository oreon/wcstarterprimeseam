package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class MappingEntryDto

extends BaseDto

{

	protected Integer min;

	protected Integer max;

	protected StrategyOutcome outcome;

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

}
