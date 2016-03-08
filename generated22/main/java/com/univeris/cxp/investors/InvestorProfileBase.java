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
public abstract class InvestorProfileBase extends BaseEntity<Integer>

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

	@Lob
	@Column(name = "DESC_ENG", unique = false)
	protected String descEng

	;

	/* */

	/* */

	@Lob
	@Column(name = "DESC_FRE", unique = false)
	protected String descFre

	;

	/* */

	/* */

	@Column(name = "IMAGE_FILE_URI", unique = false)
	protected String imageFileUri

	;

	/* */

	/* */

	@Column(name = "CONSERVATIVE_ORDER", unique = false)
	protected Integer conservativeOrder

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
