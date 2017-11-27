package com.es.movie.service;

import java.util.Date;
import java.util.List;

import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

public interface MovieManagementService {
	
	//상영관리  특정 연/월/일에 상영하는 모든 영화 조회 (중복 제외) 
	List<SelectTimetable> getAllMoviesByDate(Date playDate);
			
	//상영관리 예약석 조회
	List<Ticket> getReservedSeatsByTimetableId(int timetalbleId);
	
	//상영관리 날짜별 상영관 조회
	List<SelectTimetable> getAllScreenNameByDate(Date playDate);
	
	//온라인/오프라인예매 변경
	void updateMovieManagement(MovieTimetable movieTimetable);
}
