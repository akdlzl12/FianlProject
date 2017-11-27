package com.es.movie.vo;

public class MovieTranslation {

	private Integer id;
	private String name;
	private String description;
	private String langiso;
	private Integer langdefault;
	private String publishCountry;
	private Movie	movie;
	
	
	public String getPublishCountry() {
		return publishCountry;
	}
	public void setPublishCountry(String publishCountry) {
		this.publishCountry = publishCountry;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLangiso() {
		return langiso;
	}
	public void setLangiso(String langiso) {
		this.langiso = langiso;
	}
	public Integer getLangdefault() {
		return langdefault;
	}
	public void setLangdefault(Integer langdefault) {
		this.langdefault = langdefault;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
