package com.es.pos.service;

import java.util.Date;
import java.util.List;

import com.es.management.vo.CustomerType;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.Seat;
import com.es.pos.vo.Ticket;

public interface MovieSelectService {

	List<MovieTranslation> findMoviesInDay(Date playingDate);
	List<MovieTimetable> findMovieTimeOfMovie(Date playingDate, int movieId);
	List<CustomerType> getAllPriceKey();
	CustomerType getPriceKeyByTypeId(int typeId);
	MovieTranslation findMovieInfo(int movieId);
	MovieTimetable findMovieTimetable(int timetableId);
	Seat getSeatInfo(int seatId);
	List<Seat> getSeatInfoInScreen(int screenId);
	List<Ticket> getReservedSeatInfoInTimetable(int timetableId);
}