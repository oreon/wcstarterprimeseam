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
public class PersonBase extends BaseEntity

{

	/*@NotNull */

	/* */

	@Column(name = "GENDER", unique = false)
	protected Gender gender

	;

	/*@NotNull */

	/* */

	@Column(name = "DOB", unique = false)
	protected Date dob

	;

	@AttributeOverrides({

			@AttributeOverride(name = "street", column = @Column(name = "address_street")),

			@AttributeOverride(name = "city", column = @Column(name = "address_city")),

			@AttributeOverride(name = "province", column = @Column(name = "address_province"))

	})
	protected Address address

	;

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Gender getGender() {

		return gender;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDob() {

		return dob;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {

		return address;
	}

	@Transient
	public String getDisplayName() {
		try {
			return gender + "";
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

}
