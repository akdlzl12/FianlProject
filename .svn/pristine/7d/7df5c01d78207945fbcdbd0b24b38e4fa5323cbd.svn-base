package com.es.movie.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.common.vo.Criteria;
import com.es.movie.service.MovieListService;
import com.es.movie.vo.MovieTranslation;

@RestController
public class MovieListAjaxController {
	
	@Autowired
	private MovieListService movieListService;
	
	@RequestMapping("/searchByMovieTrans.esc")
	@ResponseBody
	public List<MovieTranslation> searchByMovieTranslation(Criteria criteria) {
		return movieListService.searchByMovieTranslation(criteria);
	}
	
	
	
}
