package com.es.financial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.financial.mapper.DailyReportMapper;
import com.es.financial.vo.DailyReport;

@Service
public class DailyReportService {
	@Autowired
	private DailyReportMapper reportMapper;
	
	public int insert(DailyReport report) {
		int nextId = reportMapper.nextId();
		reportMapper.insert(report);
		return nextId;
	}
	
	public int totalMismatchMoneyByEmpId(int empId) {
		return this.reportMapper.readMismatchTotalMoney(empId);
	}
}
