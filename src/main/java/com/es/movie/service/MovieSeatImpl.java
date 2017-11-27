package com.es.movie.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.movie.mapper.MovieMapper;
import com.es.movie.mapper.ScreenMapper;
import com.es.movie.vo.Screen;
import com.es.movie.vo.Seat;
import com.es.movie.vo.SeatDisabled;
import com.es.movie.vo.SeatInfo;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

@Service
public class MovieSeatImpl implements MovieSeatService{
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private ScreenMapper screenMapper;
	
	@Override
	public List<SelectTimetable> getAllScreenNameByDate(Date playDate) {
		
		return movieMapper.getAllScreenNameByDate(playDate);
	}

	@Override
	public List<SelectTimetable> getAllMoviesByDate(Date playDate) {
		
		return movieMapper.getAllMoviesByDate(playDate);
	}

	@Override
	public Screen getScreenIdByName(String screenName) {
		
		return movieMapper.getScreenIdByName(screenName);
	}

	@Override
	public void insertSeatDissabled(SeatDisabled seatDisabled) {
		screenMapper.insertSeatDissabled(seatDisabled);
		
	}

	@Override
	public void updateSeatStatus(Seat seat) {
		screenMapper.updateSeatStatus(seat);
	}

	@Override
	public SeatDisabled getDisabledDetail(int seatId) {
		
		return screenMapper.getDisabledDetail(seatId);
	}

	@Override
	public List<SeatInfo> getSeatInfoBySeatId(SeatInfo seatInfo) {
		
		return screenMapper.getSeatInfoBySeatId(seatInfo);
	}

	

	
	
}
