package com.es.movie.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.ScreenMovie;

public interface TimetableAddService {
	// 시간표등록 - 날짜별 등록가능영화
	List<MovieTranslation> getMovieTranslationsByDate(Date date);
	
	// 시간표등록 
	
	void addTimetable(MovieTimetable movieTimetable, ScreenMovie screenMovie);
}
