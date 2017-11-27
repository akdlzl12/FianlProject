package com.es.common.vo;

import java.util.Date;

import com.es.util.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class MovieRankNameForm {

	private String name;
	private Integer movieRank;
	private Integer no;
	private String month;
	@JsonSerialize(using=DateSerializer.class)
	private Date startDate;
	@JsonSerialize(using=DateSerializer.class)
	private Date endDate;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMovieRank() {
		return movieRank;
	}

	public void setMovieRank(Integer movieRank) {
		this.movieRank = movieRank;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "MovieRankNameForm [name=" + name + ", movieRank=" + movieRank + ", no=" + no + ", month=" + month + "]";
	}

	
	
	
	
}
