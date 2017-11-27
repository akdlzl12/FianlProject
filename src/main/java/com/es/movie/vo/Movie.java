package com.es.movie.vo;

import java.util.Date;
import java.util.List;

import com.es.util.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Movie {

	private Integer id;
	@JsonSerialize(using=DateSerializer.class)
	private Date publishDate;
	@JsonSerialize(using=DateSerializer.class)
	private Date openDate;
	private Integer ageLimit;
	@JsonSerialize(using=DateSerializer.class)
	private Date closeDate;
	private Integer dubbed;
	
	private MovieTranslation movieTranslation;
	private MovieImage movieImage;
	private List<GenreTranslation> genreTranslation;
	
	public Integer getDubbed() {
		return dubbed;
	}
	public void setDubbed(Integer dubbed) {
		this.dubbed = dubbed;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Integer getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(Integer ageLimit) {
		this.ageLimit = ageLimit;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public MovieTranslation getMovieTranslation() {
		return movieTranslation;
	}
	public void setMovieTranslation(MovieTranslation movieTranslation) {
		this.movieTranslation = movieTranslation;
	}
	public MovieImage getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(MovieImage movieImage) {
		this.movieImage = movieImage;
	}
	public List<GenreTranslation> getGenreTranslation() {
		return genreTranslation;
	}
	public void setGenreTranslation(List<GenreTranslation> genreTranslation) {
		this.genreTranslation = genreTranslation;
	}
	
	
}
