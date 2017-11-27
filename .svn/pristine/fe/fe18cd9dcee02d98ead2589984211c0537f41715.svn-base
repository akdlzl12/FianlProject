package com.es.pos.service;

import com.es.employee.vo.Employee;
import com.es.employee.vo.EmployeeTimetable;
import com.es.pos.vo.PosLoginHistory;

public interface LogService {

	PosLoginHistory enrollStartingWork(Employee employee, int posId);
	Employee findEmployeeById(String id, Long pwd);
	PosLoginHistory enrollFinishingWork(PosLoginHistory login);
	EmployeeTimetable getEmployeeTimetable(PosLoginHistory loginHistory);
	EmployeeTimetable enrollStartingRest(EmployeeTimetable timetable);
	EmployeeTimetable enrollFinishingRest(EmployeeTimetable timetable);
}
