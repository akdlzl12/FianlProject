package com.es.movie.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.movie.mapper.MovieMapper;
import com.es.movie.mapper.ScreenMapper;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

@Service
public class TimetableInfoImpl implements TimeTableInfoService{
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private ScreenMapper screenMapper;

	@Override
	public List<MovieTimetable> getMovieTimetableByscreenId(int timetableId) {
		
		return movieMapper.getMovieTimetableByscreenId(timetableId);
	}
	//시간표 조회 날짜로 영화정보 조회 
	@Override
	public List<SelectTimetable> getAllMoviesByDate(Date playDate) {
		
		return movieMapper.getAllMoviesByDate(playDate);
	}
	@Override
	public List<Ticket> getReservedSeatsByTimetableId(int timetalbleId) {
		
		return screenMapper.getReservedSeatsByTimetableId(timetalbleId);
	}

	
	
	
}
