package com.univeris.cxp.investors.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class InvestorProfileDto

extends BaseDto

{

	protected String nameEng;

	protected String nameFre;

	protected String descEng;

	protected String descFre;

	protected String imageFileUri;

	protected Integer conservativeOrder;

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

	public void setDescEng(String descEng) {
		this.descEng = descEng;
	}

	public String getDescEng() {
		return descEng;
	}

	public void setDescFre(String descFre) {
		this.descFre = descFre;
	}

	public String getDescFre() {
		return descFre;
	}

	public void setImageFileUri(String imageFileUri) {
		this.imageFileUri = imageFileUri;
	}

	public String getImageFileUri() {
		return imageFileUri;
	}

	public void setConservativeOrder(Integer conservativeOrder) {
		this.conservativeOrder = conservativeOrder;
	}

	public Integer getConservativeOrder() {
		return conservativeOrder;
	}

}
