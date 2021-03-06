package com.es.movie.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.compiler.MemberResolver.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.movie.service.MovieSeatService;
import com.es.movie.vo.Screen;
import com.es.movie.vo.Seat;
import com.es.movie.vo.SeatDisabled;
import com.es.movie.vo.SeatInfo;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.service.MovieSelectService;
import com.es.pos.vo.Ticket;

@RestController
public class MovieSeatAjaxController {
	
	@Autowired
	private MovieSeatService movieSeatService;
	
	@Autowired
	private MovieSelectService movieSelectService;
	
	//날짜로 상영관 조회
	@RequestMapping("/getInfoBydates.esc")
	@ResponseBody
	public List<SelectTimetable> getAllScreenNameByDate(Date playDate) {
		List<SelectTimetable> selectTimetables =new ArrayList<SelectTimetable>();
		selectTimetables = movieSeatService.getAllScreenNameByDate(playDate);
		return selectTimetables;
	}	
	//상영관 선택으로 영화정보 조회 
	@RequestMapping("/getInfoByScreens.esc")
	@ResponseBody
	public List<SelectTimetable> getAllMoviesByDate(Date playDate) {
		List<SelectTimetable> selectTimetables = new ArrayList<SelectTimetable>();
		selectTimetables = movieSeatService.getAllMoviesByDate(playDate);
		return selectTimetables;
		}
	// 예약석뽑기
	@RequestMapping("/getReservedSeat.esc")
	@ResponseBody
	public List<Seat> seatInfo(String selectScreen, int timetableId) {
		Screen screen = movieSeatService.getScreenIdByName(selectScreen);
		int screenId = screen.getId();
		
		List<Seat> allSeat = movieSelectService.getSeatInfoInScreen(screenId);
		System.out.println(allSeat);
		List<Ticket> allTicket = movieSelectService.getReservedSeatInfoInTimetable(timetableId);
		System.out.println(allTicket);
		
		for(Ticket forTicket : allTicket) {
			for(Seat forSeat : allSeat) {
				if(forTicket.getSeat().getId().intValue() == forSeat.getId().intValue()) {
					System.out.println(forSeat);	
					forSeat.setStatus("R");
				}
			}
		}
		return allSeat;
	}
	//좌석관리 예약석 클릭시 좌석정보
	@RequestMapping("/getSeatInfoSeatId.esc")
	@ResponseBody
	public List<SeatInfo> getSeatInfoBySeatId(int seatId, Date date) {
		SeatInfo seatInfo = new SeatInfo();
		seatInfo.setId(seatId);
		seatInfo.setStartedAt(date);
		List<SeatInfo> seatInfos = movieSeatService.getSeatInfoBySeatId(seatInfo);
		return seatInfos;
	}
	//좌석확보 업데이트
	@PostMapping("/insertDissabled.esc")
	@ResponseBody
	public List<Seat> insertSeatDissabled(String detail, String selectedSeatIds ) {
		List<Seat> seats = new ArrayList<Seat>();
//		System.out.println(selectedSeatIds);
		String[] seatItems = selectedSeatIds.split(",");
		for(String selectedSeatId : seatItems) {
			SeatDisabled seatDisabled = new SeatDisabled();
			Seat seat = new Seat();
			seat.setId(Integer.parseInt(selectedSeatId));
			seatDisabled.setSeat(seat);
			seatDisabled.setDetail(detail);
			seat.setStatus("N");
			seats.add(seat);
			
			movieSeatService.updateSeatStatus(seat);
			movieSeatService.insertSeatDissabled(seatDisabled);
		}
		return seats;		
	}
	//좌석확보 수정
	@RequestMapping("/getDisabledDetail.esc")
	@ResponseBody
	public List<SeatDisabled> getDisabledDetail(String selectedSeatIds ) {
		List<SeatDisabled> seatDisableds = new ArrayList<SeatDisabled>();
		System.out.println(selectedSeatIds);
		String[] seatItems = selectedSeatIds.split(",");
		
		for(String selectedSeatId : seatItems) {
			SeatDisabled seatDisabled = movieSeatService.getDisabledDetail(Integer.parseInt(selectedSeatId));
			System.out.println("11");
			Seat seat = new Seat();
			seat.setStatus("Y");
			seat.setId(Integer.parseInt(selectedSeatId));
			seatDisabled.setSeat(seat);
			
			movieSeatService.updateSeatStatus(seat);
			
			seatDisableds.add(seatDisabled);
		}
		return seatDisableds;
	}
	
}
