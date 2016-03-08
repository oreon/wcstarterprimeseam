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

/** 
 * Entity containing orders that a customer places. 
 **/

@MappedSuperclass
//@Indexed
//@Analyzer(definition = "entityAnalyzer")
public abstract class CustomerOrderBase extends BaseEntity<Integer>

{

	/** 
	 * order related notes like if the order is urgent and any other comments that customer might have put in.  
	 **/

	/*@NotNull */

	/* */

	@Lob
	@Column(name = "NOTES", unique = false)
	protected String notes

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = true, insertable = true)
	protected Customer customer

	;

	@OneToMany(mappedBy = "customerOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<OrderItem> orderItems

	= new ArrayList<OrderItem>()

	;

	/* */

	/*	 */

	/* */

	@Column(name = "ship_Date", unique = false)
	protected Date shipDate

	;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "paymentMethod_id", nullable = true, updatable = true, insertable = true)
	protected PaymentMethod paymentMethod

	;

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getNotes() {

		return notes;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {

		return customer;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<OrderItem> getOrderItems() {

		return orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {

		orderItem.setCustomerOrder((CustomerOrder) this);

		if (orderItems == null) {
			orderItems = new ArrayList<com.univeris.cxp.commerce.OrderItem>();
		}

		this.orderItems.add(orderItem);
	}

	@Transient
	public String createListOrderItemsAsString() {
		return listAsString(orderItems);
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Date getShipDate() {

		return shipDate;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentMethod getPaymentMethod() {

		return paymentMethod;
	}

	@Transient
	public String getDisplayName() {
		try {
			return notes;
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
