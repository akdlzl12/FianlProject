package com.es.pos.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.management.vo.CustomerType;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.Seat;
import com.es.pos.service.MovieSelectService;
import com.es.pos.vo.MovieSelectForm;
import com.es.pos.vo.Ticket;
import com.es.util.DateUtil;

@Controller
public class PosController {
	
	@Autowired
	private MovieSelectService movieSelectService;

	@RequestMapping("/home.esc")
	public String movieSelect() {
		return "main";
	}
	
	@GetMapping("/pricekey.esc")
	@ResponseBody
	public List<CustomerType> priceKey() {
		return movieSelectService.getAllPriceKey();
	}
	
	@GetMapping("/movie.esc")
	@ResponseBody
	public List<MovieTranslation> movieList(String playingdate) {
		Date date = DateUtil.yyyymmdd(playingdate);

		return movieSelectService.findMoviesInDay(date);
	}
	
	@GetMapping("/timetable.esc")
	@ResponseBody
	public List<MovieTimetable> movieTimetable(String playingdate, int movieid) {
		Date date = DateUtil.yyyymmdd(playingdate);
		
		return movieSelectService.findMovieTimeOfMovie(date, movieid);
	}
	
	@PostMapping("/seat.esc")
	public String seat(MovieSelectForm movieSelectForm, Model model) {
		MovieTranslation movieInfo = movieSelectService.findMovieInfo(movieSelectForm.getMovieId());
		MovieTimetable timetable = movieSelectService.findMovieTimetable(movieSelectForm.getTimetableId());
		
		model.addAttribute("movieInfo", movieInfo);
		model.addAttribute("timetable", timetable);
		model.addAttribute("keyIdList", movieSelectForm.getPriceKeyId());
		
		String amount = movieSelectForm.getAmount();
		model.addAttribute("amountList", amount);
		
		List<String> amountList = Arrays.asList(amount.split(","));
		
		int totalAmount = 0;
		for(String forAmount : amountList) {
			totalAmount += Integer.parseInt(forAmount);
		}
		model.addAttribute("totalAmount", totalAmount);
		
		return "seat";
	}
	
	@GetMapping("/seat.esc")
	@ResponseBody
	public List<Seat> seatInfo(int screenId, int timetableId) {
		List<Seat> allSeat = movieSelectService.getSeatInfoInScreen(screenId);
		List<Ticket> allTicket = movieSelectService.getReservedSeatInfoInTimetable(timetableId);
		
		for(Ticket forTicket : allTicket) {
			for(Seat forSeat : allSeat) {
				if(forTicket.getSeat().getId() == forSeat.getId()) {
					forSeat.setStatus("R");
				}
			}
		}
		return allSeat;
	}
}
