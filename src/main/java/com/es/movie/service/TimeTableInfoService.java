package com.es.movie.service;

import java.util.Date;
import java.util.List;

import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

public interface TimeTableInfoService {
	
	//단순 ID로 MovieTimetable
	List<MovieTimetable> getMovieTimetableByscreenId(int timetableId);

	
	//시간표조회  특정 연/월/일에 상영하는 모든 영화 조회 (중복 제외) 
	List<SelectTimetable> getAllMoviesByDate(Date playDate);
	// 시간표조회 예약석
	List<Ticket> getReservedSeatsByTimetableId(int timetalbleId);
		
}
