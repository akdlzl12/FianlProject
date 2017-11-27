package com.es.movie.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.movie.service.TimetableAddService;
import com.es.movie.vo.Movie;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.Screen;
import com.es.movie.vo.ScreenMovie;
import com.es.movie.web.form.TimetableForm;
import com.es.movie.web.form.TimetableForm.Timetable;

@Controller
public class TimetableAddController {
	
	@Autowired
	private TimetableAddService timetableAddService; 
	
	@RequestMapping("/timetableadd.esc")
	public String timetableAdd() {
		return "timetableAdd";
	}
	
	@RequestMapping("/movietimetableadd.esc")
	public String submit(TimetableForm timetableForm) throws ParseException {
		
		System.out.println(timetableForm);
		
		MovieTimetable movieTimetable = new MovieTimetable();
		ScreenMovie screenMovie = new ScreenMovie();
		
		Screen screen = new Screen();
		Movie movie = new Movie();
		
		Integer movie_id1 =timetableForm.getScreen1();
		Integer movie_id2 =timetableForm.getScreen2();
		Integer movie_id3 =timetableForm.getScreen3();
		Integer movie_id4 =timetableForm.getScreen4();
		
		
		int count = 0;
		for(Integer index : timetableForm.getTables().keySet()) {
			List<Timetable> tables = timetableForm.getTables().get(index);
			
			for(Timetable table : tables) {
				if(table.getStartedAt() == null || "".equals(table.getStartedAt().trim())) {
					continue;
				}
				String strStartedAt = timetableForm.getDates() + " " + table.getStartedAt();
				String strendedAt = timetableForm.getDates() + " " + table.getEndedAt();
				
				Date dateStartedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(strStartedAt);
				Date dateEndedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(strendedAt);
				
				movieTimetable.setStartedAt(dateStartedAt);
				movieTimetable.setEndedAt(dateEndedAt);
				
				System.out.println(table.getOrdered());
				Integer ordered = table.getOrdered();
				movieTimetable.setOrdered(ordered);
				
				//System.out.println(screenMovie.getScreen());
				screenMovie.setScreen(screen);
				screenMovie.getScreen().setId(index);
				
				if(count == 0 ) {
					screenMovie.setMovie(movie);
					screenMovie.getMovie().setId(movie_id1);
				}
				if(count == 1 ) {
					screenMovie.setMovie(movie);
					screenMovie.getMovie().setId(movie_id2);					
				}
				if(count == 2 ) {
					screenMovie.setMovie(movie);
					screenMovie.getMovie().setId(movie_id3);					
				}
				if(count == 3 ) {
					screenMovie.setMovie(movie);
					screenMovie.getMovie().setId(movie_id4);					
				}
				
				
				
				
				
				timetableAddService.addTimetable(movieTimetable, screenMovie);
			}
			count++;
		}
		return "redirect:timetableadd.esc";
		
	}
	
	
}
