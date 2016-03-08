package com.univeris.cxp.investors.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class InvestingGoalPlanCodeDto

extends BaseDto

{

	protected String investingGoalCode;

	public void setInvestingGoalCode(String investingGoalCode) {
		this.investingGoalCode = investingGoalCode;
	}

	public String getInvestingGoalCode() {
		return investingGoalCode;
	}

}
