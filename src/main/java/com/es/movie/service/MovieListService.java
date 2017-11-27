package com.es.movie.service;

import java.util.List;

import com.es.common.vo.Criteria;
import com.es.movie.vo.GenreTranslation;
import com.es.movie.vo.Movie;
import com.es.movie.vo.MovieImage;
import com.es.movie.vo.MovieTranslation;

public interface MovieListService {
	// 영화조회 - 검색
	   List<MovieTranslation> searchByMovieTranslation(Criteria criteria);
	   
	// 영화조회-모달 (상세정보)
		MovieTranslation getMovieTranslation(int id);
		MovieImage getMovieImage(int id);
		List<GenreTranslation> getGenreTranslation(int id);
		Movie getMovie(int id);
	//영화조회 - 상영종료
		void updateCloseDate(int id);
		//Movie getMovie(int id);
		
	
}
