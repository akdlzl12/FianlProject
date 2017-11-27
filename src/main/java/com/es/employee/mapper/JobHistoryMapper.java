package com.es.employee.mapper;

import com.es.employee.vo.JobHistory;

public interface JobHistoryMapper {
	int readNextId();
	void insert(JobHistory history);
	JobHistory readLastJobByEmpId(int empId);
	void updateJobHistoryEndedDate(int empId);
}