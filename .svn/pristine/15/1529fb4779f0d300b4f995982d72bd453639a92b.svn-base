package com.es.movie.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.movie.mapper.MovieMapper;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.web.form.TimetableForm;

@Controller
public class MovieManagementController {
	
	@Autowired
	private MovieMapper movieMapper;
	
	@RequestMapping("/moviemanagement.esc")
	public String movieManagement() {
		return "movieManagement";
	}
	
	
	@PostMapping("/updatetimetable.esc")
	public String updateTimetable(TimetableForm timetableForm) {
		List<MovieTimetable> movieTimetables = new ArrayList<MovieTimetable>();
		movieTimetables = timetableForm.getTimetableList();
		
		for(MovieTimetable movieTimetable : movieTimetables ) {
			/*int timetableId = movieTimetable.getId();
			System.out.println(movieTimetable.getId());*/
			if(movieTimetable.getOnlinePurchase() == null) {
				movieTimetable.setOnlinePurchase(0);
			} else {
				movieTimetable.setOnlinePurchase(1);
			}
			if(movieTimetable.getOfflinePurchase() == null) {
				movieTimetable.setOfflinePurchase(0);
			} else {
				movieTimetable.setOfflinePurchase(1);
			}
			movieMapper.updateMovieManagement(movieTimetable);
		}
		
		System.out.println(timetableForm.getTimetableList());
		
		return "redirect:moviemanagement.esc";
	}

}
