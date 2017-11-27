package com.es.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.movie.mapper.MovTestMapper;
import com.es.movie.mapper.MovieMapper;
import com.es.movie.vo.Genre;
import com.es.movie.vo.GenreTranslation;
import com.es.movie.vo.Movie;
import com.es.movie.vo.MovieGenre;
import com.es.movie.vo.MovieImage;
import com.es.movie.vo.MovieTranslation;

@Service
public class AddMovieImpl implements AddMovieService{
	
	@Autowired
	private MovieMapper movieMapper;
	
	//-- 영화등록 -- 
	@Override
	public void addMovies(MovieTranslation movieTranslation, Movie movie, MovieImage movieimage, 
							Genre genre, Integer[] genreIds, GenreTranslation genreTranslation) {
		
		// int gnereId = movTestMapper.getGenreSeq();
		int movieId = movieMapper.getMovieSeq();
		
		// genre.setId(gnereId);
		movie.setId(movieId);
		
		
		MovieGenre mGenre = new MovieGenre();
		if(genreIds != null && genreIds.length > 0) {
			for(Integer genreId : genreIds) {
				mGenre.setGenre(genreId);
				mGenre.setMovie(movieId);
				this.movieMapper.addMovieGenre(mGenre);
			}
		}
		
		//genreTranslation.setGenre(genre);
		
		movieTranslation.setMovie(movie);
		
		movieimage.setMovie(movie);
		
		// movTestMapper.addGenre(genre);
		movieMapper.addMovie(movie);
		//movTestMapper.addMovieGenre(mGenre);
		//movTestMapper.addGenreTransalation(genreTranslation);
		movieMapper.addMovieTranslation(movieTranslation);
		movieMapper.addMovieImage(movieimage);
		
		
		
	}
	
	// ----------

	
}
