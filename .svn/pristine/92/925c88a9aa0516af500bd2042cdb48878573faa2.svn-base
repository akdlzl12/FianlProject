package com.es.movie.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.movie.mapper.MovieMapper;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.ScreenMovie;

@Service
public class TimetableAddImpl implements TimetableAddService{
	
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public List<MovieTranslation> getMovieTranslationsByDate(Date date) {
		
		return movieMapper.getMovieTranslationsByDate(date);
	}

	@Override
	public void addTimetable(MovieTimetable movieTimetable, ScreenMovie screenMovie) {
		int screenMovieId = movieMapper.getScreenMovieSeq();
		
		screenMovie.setId(screenMovieId);
		movieTimetable.setScreenMovie(screenMovie);
		
		
		movieMapper.addScreenMovie(screenMovie);
		movieMapper.addMovieTimetable(movieTimetable);
		
	}
	
	
	


	
	
}
