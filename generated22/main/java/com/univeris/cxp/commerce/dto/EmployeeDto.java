package com.univeris.cxp.commerce.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class EmployeeDto

extends com.univeris.cxp.commerce.dto.PersonDto

{

	protected DepartmentDto departmentDto;

	protected String firstName;

	protected String lastName;

	public void setDepartment(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public DepartmentDto getDepartment() {
		return departmentDto;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

}
