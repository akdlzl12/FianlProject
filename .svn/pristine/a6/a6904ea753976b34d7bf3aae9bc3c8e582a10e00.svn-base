package com.es.movie.service;

import java.util.Date;
import java.util.List;

import com.es.movie.vo.Screen;
import com.es.movie.vo.Seat;
import com.es.movie.vo.SeatDisabled;
import com.es.movie.vo.SeatInfo;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

public interface MovieSeatService {
	
	//좌석관리 1.날짜별 상영관 조회
	List<SelectTimetable> getAllScreenNameByDate(Date playDate);
	
	//좌석관리 2.상영관별 영화정보 조회
	List<SelectTimetable> getAllMoviesByDate(Date playDate);
	
	//좌석관리 스크린네임-> 스크린아이디
	Screen getScreenIdByName(String screenName);
	
	
	
	
	
	//좌석관리 예약석 클릭시 좌석정보
	List<SeatInfo> getSeatInfoBySeatId(SeatInfo seatInfo);
	
	
	
	
	
	
	//좌석확보 추가
	void insertSeatDissabled(SeatDisabled seatDisabled);
	
	//좌석확보 상태변경
	void updateSeatStatus(Seat seat);
	
	//확보좌석 디테일
	SeatDisabled getDisabledDetail(int seatId); 
}
