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
public abstract class OrderItemBase extends BaseEntity<Integer>

{

	/* */

	/* */

	@Column(name = "QTY", unique = false)
	protected Integer qty

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, updatable = true, insertable = true)
	protected Product product

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerOrder_id", nullable = false, updatable = true, insertable = true)
	protected CustomerOrder customerOrder

	;

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getQty() {

		return qty;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {

		return product;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public CustomerOrder getCustomerOrder() {

		return customerOrder;
	}

	@Transient
	public String getDisplayName() {
		try {
			return qty + "";
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
