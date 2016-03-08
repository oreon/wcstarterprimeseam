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
public abstract class PayPalBase
		extends
			com.univeris.cxp.commerce.PaymentMethod<Integer>

{

	/* */

	/* */

	@Column(name = "PAYPAL_ACCOUNT_NUMBER", unique = false)
	protected String paypalAccountNumber

	;

	public void setPaypalAccountNumber(String paypalAccountNumber) {
		this.paypalAccountNumber = paypalAccountNumber;
	}

	public String getPaypalAccountNumber() {

		return paypalAccountNumber;
	}

	@Transient
	public String getDisplayName() {
		try {
			return paypalAccountNumber;
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
