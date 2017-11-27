package com.es.employee.web.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.es.employee.vo.Employee;
import com.es.util.DateUtil;

public class SalaryExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Employee employee = (Employee) model.get("employee");
		Date when = (Date) model.get("when");
		String strWhen = DateUtil.yyyymmddhhmmss(when);
		Sheet sheet = workbook.createSheet(employee.getName());
		Row header = sheet.createRow(0);
		String[] whenUnits = strWhen.split("-");
		header.createCell(0).setCellValue(whenUnits[0] + "년 "+whenUnits[1]+" 월");
		
		Row empRow = sheet.createRow(2);
		empRow.createCell(0).setCellValue("이름");
		empRow.createCell(3).setCellValue(employee.getName());
		
		Row account = sheet.createRow(3);
		account.createCell(0).setCellValue("계좌번호");
		account.createCell(3).setCellValue(employee.getAccountNo());
		
		Row total = sheet.createRow(4);
		total.createCell(0).setCellValue("총액");
		total.createCell(3).setCellValue(employee.getSalary());
	}
	
}
