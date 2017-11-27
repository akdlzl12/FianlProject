package com.es.movie.web.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.es.movie.vo.SelectTimetable;
import com.es.util.DateUtil;

public class TimetableExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Date date = (Date) model.get("dates");
		List<SelectTimetable> selectTimetables = (List<SelectTimetable>) model.get("selectTimetables");
		Sheet sheet = workbook.createSheet("영화시간표 조회");
		
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("날짜");
		headerRow.createCell(1).setCellValue("상영관");
		headerRow.createCell(2).setCellValue("회차");
		headerRow.createCell(3).setCellValue("영화명");
		headerRow.createCell(4).setCellValue("시작시간");
		headerRow.createCell(5).setCellValue("종료시간");
		headerRow.createCell(6).setCellValue("전체좌석");
		
		int rowCount = 1;
		for(SelectTimetable table : selectTimetables) {
			Row dataRow = sheet.createRow(rowCount++);
			dataRow.createCell(0).setCellValue(DateUtil.yyyymmdd(date));	
			dataRow.createCell(1).setCellValue(table.getScreenName());
			dataRow.createCell(2).setCellValue(table.getOrdered());
			dataRow.createCell(3).setCellValue(table.getTitle());
			dataRow.createCell(4).setCellValue(DateUtil.yyyymmddhhmmss(table.getStartedAt()));
			dataRow.createCell(5).setCellValue(DateUtil.yyyymmddhhmmss(table.getEndedAt()));
			dataRow.createCell(6).setCellValue(table.getSeatsCount());
		}
		
		response.setHeader("Content-Disposition", "filename='MovieTimetable.xlsx'");
		workbook.write(response.getOutputStream());
		
		
		
		
	}
	
	
}
