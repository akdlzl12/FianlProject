package com.es.pos.service;

import com.es.employee.vo.Employee;
import com.es.employee.vo.EmployeeTimetable;
import com.es.pos.vo.PosLoginHistory;

public interface LogService {

	PosLoginHistory enrollStartingWork(Employee employee, int posId);
	Employee findEmployeeById(long id, long pwd);
	PosLoginHistory enrollFinishingWork(PosLoginHistory login);
	EmployeeTimetable enrollStartingRest(PosLoginHistory loginHistory);
	EmployeeTimetable enrollFinishingRest(PosLoginHistory loginHistory);
}
