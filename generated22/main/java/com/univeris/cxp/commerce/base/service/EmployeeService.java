package com.univeris.ewm.service.data.common.employee;
//package com.univeris.cxp.commerce;

import com.univeris.ewm.service.data.common.baseservice.ServiceCommons;

import com.univeris.uif.core.manager.service.ServiceDefinition;

import javax.ejb.Local;

import com.univeris.ewm.dataobjects.cxp.EmployeeDto;

/**
 * Service  interface
 */
//@Local
//@ServiceDefinition(defaultService = "EmployeeServiceUVS")
//@ClassVersionDetails(revision = "$Rev: 123288 $", id = "$Id: EmployeeService.java 123288 2015-02-03 17:08:02Z wfeng $")
public interface EmployeeService extends ServiceCommons<EmployeeDto, Integer> {

}
