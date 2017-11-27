package com.es.movie.mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.es.common.vo.Criteria;
import com.es.movie.vo.Genre;
import com.es.movie.vo.GenreTranslation;
import com.es.movie.vo.Movie;
import com.es.movie.vo.MovieGenre;
import com.es.movie.vo.MovieImage;
import com.es.movie.vo.MovieTimetable;
import com.es.movie.vo.MovieTranslation;
import com.es.movie.vo.Screen;
import com.es.movie.vo.ScreenMovie;
import com.es.movie.vo.SelectTimetable;

public interface MovieMapper {
	// 영화등록
		void addMovieTranslation(MovieTranslation movieTranslation);
		void addMovie(Movie movie);
		void addMovieImage(MovieImage movieimage);
		void addGenre(Genre genre);
		void addMovieGenre(MovieGenre movieGenre);
		void addGenreTransalation(GenreTranslation genreTranslation);
		int getGenreSeq();
		int getMovieSeq();

	// 영화조회 - 검색
	   List<MovieTranslation> searchByMovieTranslation(Criteria criteria);
	   
	// 영화조회-모달 (상세정보)
		MovieTranslation getMovieTranslation(int id);
		MovieImage getMovieImage(int id);
		List<GenreTranslation> getGenreTranslation(int id);
		Movie getMovie(int id);
		
	// 영화조회 - 상영종료
		void updateCloseDate(int id);
		
	
	// 시간표등록 - 날짜로 등록가능영화가져오기
		List<MovieTranslation> getMovieTranslationsByDate(Date date);
	
	// 시간표등록 
		void addMovieTimetable(MovieTimetable  movieTimetable);
		void addScreenMovie(ScreenMovie screenMovie);
		int getScreenMovieSeq();
		
	//특정 연/월/일에 상영하는 모든 영화 조회 (중복 제외) 
		List<MovieTranslation> getMoviesByDate(Date playingDate);
		
	// 특정 연/월/일 + Movie_id로 상영시간 조회  map에 playingDate, movieId 이름으로 담기
	List<MovieTimetable> getMovieTimetableByDateNMovieId(Map<String, Object> map);
	
	MovieTimetable getMovieTimetableById(int timetableId);
	
	//단순 ID로 MovieTimetable 조회
	List<MovieTimetable> getMovieTimetableByscreenId(int movieId);
	
	// 시간표조회 // 상영관리 조회
	List<SelectTimetable> getAllMoviesByDate(Date playDate);
	
	//상영관리 날짜별 상영관 조회
	List<SelectTimetable> getAllScreenNameByDate(Date playDate);
	
	MovieTranslation getMovieTranslateByScreenMovieId(int screenMovieId);
	//온라인/오프라인예매 변경
	void updateMovieManagement(MovieTimetable movieTimetable);
	
	//좌석관리  스크린이름으로 스크린id
	Screen getScreenIdByName(String screenName);
	
		
}
