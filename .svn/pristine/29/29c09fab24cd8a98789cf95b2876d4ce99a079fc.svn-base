package com.es.movie.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.movie.mapper.MovieMapper;
import com.es.movie.mapper.ScreenMapper;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

@Service
public class MovieManagementImpl implements MovieManagementService{
	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private ScreenMapper screenMapper;
	
	@Override
	public List<SelectTimetable> getAllMoviesByDate(Date playDate) {
		
		return movieMapper.getAllMoviesByDate(playDate);
	}
	
	@Override
	public List<SelectTimetable> getAllScreenNameByDate(Date playDate) {
		return movieMapper.getAllScreenNameByDate(playDate);
	}

	@Override
	public List<Ticket> getReservedSeatsByTimetableId(int timetalbleId) {
		return screenMapper.getReservedSeatsByTimetableId(timetalbleId);
	}

	@Override
	public void updateMovieManagement(MovieTimetable movieTimetable) {
		movieMapper.updateMovieManagement(movieTimetable);
		
	}

	
	
}
