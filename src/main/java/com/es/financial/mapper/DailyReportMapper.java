package com.es.financial.mapper;

import java.util.List;
import java.util.Map;

import com.es.financial.vo.DailyReport;

public interface DailyReportMapper {

	int nextId();
	void insert(DailyReport report);
	int readMismatchTotalMoney(int empId);
	List<DailyReport> readMismatchRecordByEmpIdAndDate(Map<String, Object> map);
}
