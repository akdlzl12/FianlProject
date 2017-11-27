package com.es.movie.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.movie.service.TimeTableInfoService;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.service.MovieSelectService;
import com.es.pos.vo.Ticket;

@RestController
public class TimetableInfoAjaxController {
	
	@Autowired
	private TimeTableInfoService timeTableInfoService;
	
	@RequestMapping("/getTimetableInfo.esc")
	@ResponseBody
	public List<SelectTimetable> getAllMoviesByDate(Date playDate) {
		List<SelectTimetable> selectTimetables = new ArrayList<SelectTimetable>();
		selectTimetables = timeTableInfoService.getAllMoviesByDate(playDate);
		//System.out.println(selectTimetables);
		
		for(SelectTimetable selectTimetable : selectTimetables) {
			
			System.out.println(selectTimetable);
			int selctId =selectTimetable.getId();
			
			List<Ticket> reserveds = new ArrayList<Ticket>();
			reserveds = timeTableInfoService.getReservedSeatsByTimetableId(selctId);
			int reservedcnt = reserveds.size();
			if( reservedcnt != 0) {
				selectTimetable.setReservedSeatsCount(reservedcnt);	
			} else {
				selectTimetable.setReservedSeatsCount(0);
			}
			
		}
		
		return selectTimetables;
	}
}
