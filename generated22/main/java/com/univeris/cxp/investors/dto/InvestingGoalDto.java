package com.univeris.cxp.investors.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class InvestingGoalDto

extends BaseDto

{

	protected String nameEng;

	protected String nameFre;

	protected String imageFileIri;

	protected Boolean isDefault;

	protected InvestingGoalPlanCodeDto investingGoalPlanCodeDto;

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameFre(String nameFre) {
		this.nameFre = nameFre;
	}

	public String getNameFre() {
		return nameFre;
	}

	public void setImageFileIri(String imageFileIri) {
		this.imageFileIri = imageFileIri;
	}

	public String getImageFileIri() {
		return imageFileIri;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setInvestingGoalPlanCode(
			InvestingGoalPlanCodeDto investingGoalPlanCodeDto) {
		this.investingGoalPlanCodeDto = investingGoalPlanCodeDto;
	}

	public InvestingGoalPlanCodeDto getInvestingGoalPlanCode() {
		return investingGoalPlanCodeDto;
	}

}
