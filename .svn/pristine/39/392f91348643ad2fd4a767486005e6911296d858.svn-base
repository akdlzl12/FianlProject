package com.es.movie.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.common.vo.Criteria;
import com.es.movie.service.MovieListService;
import com.es.movie.vo.GenreTranslation;
import com.es.movie.vo.Movie;
import com.es.movie.vo.MovieImage;
import com.es.movie.vo.MovieTranslation;

@RestController
public class MovieListAjaxController {
	
	@Autowired
	private MovieListService movieListService;
	
	// 영화조회/ 페이지 검색버튼
	@RequestMapping("/searchByMovieTrans.esc")
	@ResponseBody
	public List<MovieTranslation> searchByMovieTranslation(Criteria criteria) {
		return movieListService.searchByMovieTranslation(criteria);
	}
	
	// 영화조회/ 상세정보 조회 모달
	@RequestMapping("/getDetailMovie.esc")
	@ResponseBody
	public Movie getDetailMovie(int id) {
		List<GenreTranslation> genres =  movieListService.getGenreTranslation(id);
		MovieImage movieImage = movieListService.getMovieImage(id);
		MovieTranslation movieTranslation = movieListService.getMovieTranslation(id);
		
		Movie movie = movieListService.getMovie(id);
		
		movie.setGenreTranslation(genres);
		movie.setMovieImage(movieImage);
		movie.setMovieTranslation(movieTranslation);

		return movie;
	}
	
	// 영화조회- 상영종료 
	@RequestMapping("/updateCloseDate.esc")
	@ResponseBody
	public Movie updateCloseDate(int id) {
		movieListService.updateCloseDate(id);
		
		Movie movie = movieListService.getMovie(id);
		
		return movie;
	}
	
	
}
