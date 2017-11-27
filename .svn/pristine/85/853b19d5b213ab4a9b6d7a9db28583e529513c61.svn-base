package com.es.pos.mapper;

import com.es.employee.vo.EmployeeTimetable;
import com.es.pos.vo.Pos;
import com.es.pos.vo.PosLoginHistory;

public interface PosMapper {

	int addLoginHistorySeq();
	void addPosLoginHistory(PosLoginHistory posLoginHistory);
	void addEmployeeTimetable(EmployeeTimetable employeeTimetable);
	Pos getPosById(int posId);
	EmployeeTimetable getEmployeeTimetableByPosHistory(PosLoginHistory posLoginHistory);
	void updateEmployeeTimetable(EmployeeTimetable employeeTimetable);
	void updatePosLoginHistory(PosLoginHistory posLoginHistory);
}
