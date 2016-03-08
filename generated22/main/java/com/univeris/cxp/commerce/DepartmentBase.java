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
public abstract class DepartmentBase extends BaseEntity<Integer>

{

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<Employee> employees

	= new ArrayList<Employee>()

	;

	/* */

	/* */
	//@Unique(entityName = "com.univeris.cxp.commerce.Department", fieldName = "name")

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NAME", unique = true)
	protected String name

	;

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {

		return employees;
	}

	public void addEmployee(Employee employee) {

		employee.setDepartment((Department) this);

		if (employees == null) {
			employees = new ArrayList<com.univeris.cxp.commerce.Employee>();
		}

		this.employees.add(employee);
	}

	@Transient
	public String createListEmployeesAsString() {
		return listAsString(employees);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	@Transient
	public String getDisplayName() {
		try {
			return name;
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
