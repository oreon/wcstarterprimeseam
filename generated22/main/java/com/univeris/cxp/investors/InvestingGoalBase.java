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
public abstract class InvestingGoalBase extends BaseEntity<Integer>

{

	/* */

	/* */

	@Column(name = "NAME_ENG", unique = false)
	protected String nameEng

	;

	/* */

	/* */

	@Column(name = "NAME_FRE", unique = false)
	protected String nameFre

	;

	/* */

	/* */

	@Column(name = "IMAGE_FILE_IRI", unique = false)
	protected String imageFileIri

	;

	/* */

	/* */

	@Column(name = "IS_DEFAULT", unique = false)
	protected Boolean isDefault

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "investingGoalPlanCode_id", nullable = false, updatable = true, insertable = true)
	protected InvestingGoalPlanCode investingGoalPlanCode

	;

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
			InvestingGoalPlanCode investingGoalPlanCode) {
		this.investingGoalPlanCode = investingGoalPlanCode;
	}

	public InvestingGoalPlanCode getInvestingGoalPlanCode() {

		return investingGoalPlanCode;
	}

	@Transient
	public String getDisplayName() {
		try {
			return nameEng;
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
