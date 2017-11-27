package com.es.movie.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.movie.service.TimetableAddService;
import com.es.movie.vo.MovieTranslation;

@RestController
public class TimetableAddAjaxController {
	
	@Autowired
	private TimetableAddService timetableAddService;
	
	@RequestMapping("/getMovieTranslationsByDate.esc")
	@ResponseBody
	public List<MovieTranslation> getMovieTranslationsByDate(Date date) {
		//System.out.println(date);
		return timetableAddService.getMovieTranslationsByDate(date);
	}
	
	
	
}
