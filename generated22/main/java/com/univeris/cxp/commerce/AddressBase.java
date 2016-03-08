package com.univeris.cxp.commerce;

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
public class AddressBase

{

	/*@NotNull */

	/* */

	@Column(name = "STREET", unique = false)
	protected String street

	;

	/*@NotNull */

	/* */

	@Column(name = "CITY", unique = false)
	protected String city

	;

	/*@NotNull */

	/* */

	@Column(name = "PROVINCE", unique = false)
	protected String province

	;

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {

		return street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {

		return city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {

		return province;
	}

	@Transient
	public String getDisplayName() {
		try {
			return street;
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

}
