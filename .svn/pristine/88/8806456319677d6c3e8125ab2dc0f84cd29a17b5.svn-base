package com.es.common.rest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.common.service.HomeMainService;
import com.es.common.vo.MonthDate;
import com.es.common.vo.MovieRankNameForm;
import com.es.common.vo.OnlineOfflinePaymentMetrics;

@Controller
public class HomeAjaxController {

	@Autowired
	private HomeMainService homeMainService; 
	
	@RequestMapping("/getMovieRankName.esc")
	@ResponseBody
	public List<MovieRankNameForm> getMovieRankName() {
		
		LocalDate now = LocalDate.now();
		List<MovieRankNameForm> movieRankNameForms = new ArrayList<MovieRankNameForm>();
		
		Date startDate = Date.from(now.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(now.minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		endDate.setTime(endDate.getTime()+(60*60*23+(60*59)+59)*1000);
		System.out.println(endDate);
		
		MonthDate monthDate = new MonthDate();
		List<Date> startDateList = new ArrayList<Date>();
		startDateList.add(startDate);
		monthDate.setStartDate(startDateList);
		
		List<Date> endDateList = new ArrayList<Date>();
		endDateList.add(endDate);
		monthDate.setEndDate(endDateList);
		
		movieRankNameForms = homeMainService.getMovieRankName(monthDate);
		for (MovieRankNameForm form : movieRankNameForms) {
			form.setStartDate(startDate);
			form.setEndDate(endDate);
		}
		
		return movieRankNameForms;
	}
	
	@RequestMapping("/getMovieAudienceStatisticsSelect.esc")
	@ResponseBody
	public List<MovieRankNameForm> getMovieAudienceStatisticsSelect() {
		
		LocalDate now = LocalDate.now();
		MonthDate monthDate = new MonthDate();
		LocalDate firstMonth = now.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastMonth = now.with(TemporalAdjusters.lastDayOfMonth());
		
			Date startDate = Date.from(firstMonth.minusMonths(3).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(lastMonth.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date threeMonth = Date.from(now.minusMonths(2).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date twoMonth = Date.from(now.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date oneMonth = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			endDate.setTime(endDate.getTime()+(60*60*23+(60*59)+59)*1000);
			
			int threeMonthDate = threeMonth.getMonth();
			int twoMonthDate = twoMonth.getMonth();
			int oneMonthDate = oneMonth.getMonth();
			if(String.valueOf(threeMonthDate).length() == 2) {
				monthDate.setThreeMonthDate(String.valueOf(threeMonthDate));
			}else {
				monthDate.setThreeMonthDate("0" + String.valueOf(threeMonthDate));
			}
			
			if(String.valueOf(twoMonthDate).length() == 2) {
				monthDate.setTwoMonthDate(String.valueOf(twoMonthDate));
			}else {
				monthDate.setTwoMonthDate("0" + String.valueOf(twoMonthDate));
			}
			
			if(String.valueOf(oneMonthDate).length() == 2) {
				monthDate.setOneMonthDate(String.valueOf(oneMonthDate));
			}else {
				monthDate.setOneMonthDate("0" + String.valueOf(oneMonthDate));
			}
			
			List<Date> startDateList = new ArrayList<Date>();
			startDateList.add(startDate);
			monthDate.setStartDate(startDateList);
			
			List<Date> endDateList = new ArrayList<Date>();
			endDateList.add(endDate);
			monthDate.setEndDate(endDateList);
		
		System.out.println(monthDate);
		System.out.println(homeMainService.getMovieAudienceStatisticsSelect(monthDate));
		return homeMainService.getMovieAudienceStatisticsSelect(monthDate);
	}
	
	@RequestMapping("/getMostFeaturedFilms.esc")
	@ResponseBody
	public List<MovieRankNameForm> getMostFeaturedFilms() {
		
		LocalDate now = LocalDate.now();
		MonthDate monthDate = new MonthDate();
		LocalDate firstMonth = now.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastMonth = now.with(TemporalAdjusters.lastDayOfMonth());
		
			Date startDate = Date.from(firstMonth.minusMonths(3).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(lastMonth.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date threeMonth = Date.from(now.minusMonths(2).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date twoMonth = Date.from(now.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date oneMonth = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			endDate.setTime(endDate.getTime()+(60*60*23+(60*59)+59)*1000);
			
			int threeMonthDate = threeMonth.getMonth();
			int twoMonthDate = twoMonth.getMonth();
			int oneMonthDate = oneMonth.getMonth();
			if(String.valueOf(threeMonthDate).length() == 2) {
				monthDate.setThreeMonthDate(String.valueOf(threeMonthDate));
			}else {
				monthDate.setThreeMonthDate("0" + String.valueOf(threeMonthDate));
			}
			
			if(String.valueOf(twoMonthDate).length() == 2) {
				monthDate.setTwoMonthDate(String.valueOf(twoMonthDate));
			}else {
				monthDate.setTwoMonthDate("0" + String.valueOf(twoMonthDate));
			}
			
			if(String.valueOf(oneMonthDate).length() == 2) {
				monthDate.setOneMonthDate(String.valueOf(oneMonthDate));
			}else {
				monthDate.setOneMonthDate("0" + String.valueOf(oneMonthDate));
			}
			
			List<Date> startDateList = new ArrayList<Date>();
			startDateList.add(startDate);
			monthDate.setStartDate(startDateList);
			
			List<Date> endDateList = new ArrayList<Date>();
			endDateList.add(endDate);
			monthDate.setEndDate(endDateList);
		
		System.out.println("스크린 수" + monthDate);
		System.out.println("스크린 수" + homeMainService.getMovieAudienceStatisticsSelect(monthDate));
		return homeMainService.getMostFeaturedFilms(monthDate);
	}
	
	@RequestMapping("/getOnlineOfflinePaymentMetrics.esc")
	@ResponseBody
	public List<OnlineOfflinePaymentMetrics> getOnlineOfflinePaymentMetrics() {
		LocalDate now = LocalDate.now();
		
		LocalDate firstMonth = now.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastMonth = now.with(TemporalAdjusters.lastDayOfMonth());
		
		Date startDate = Date.from(firstMonth.minusMonths(3).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(lastMonth.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		endDate.setTime(endDate.getTime()+(60*60*23+(60*59)+59)*1000);
		System.out.println(endDate);
		
		MonthDate monthDate = new MonthDate();
		List<Date> startDateList = new ArrayList<Date>();
		startDateList.add(startDate);
		monthDate.setStartDate(startDateList);
		
		List<Date> endDateList = new ArrayList<Date>();
		endDateList.add(endDate);
		monthDate.setEndDate(endDateList);
		System.out.println("온라인 오프라인" + homeMainService.getOnlineOfflinePaymentMetrics(monthDate));
		
		return homeMainService.getOnlineOfflinePaymentMetrics(monthDate);
	}
}
