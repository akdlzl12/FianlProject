package com.es.movie.vo;

import java.util.Date;

import com.es.util.TimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class MovieTimetable {

	private Integer id;
	@JsonSerialize(using=TimeSerializer.class)
	private Date startedAt;
	@JsonSerialize(using=TimeSerializer.class)
	private Date endedAt;
	private Integer onlinePurchase;
	private Integer offlinePurchase;
	private ScreenMovie screenMovie;
	private Integer ordered;
	
	
	
	public Integer getOrdered() {
		return ordered;
	}
	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}
	public Date getEndedAt() {
		return endedAt;
	}
	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}
	public Integer getOnlinePurchase() {
		return onlinePurchase;
	}
	public void setOnlinePurchase(Integer onlinePurchase) {
		this.onlinePurchase = onlinePurchase;
	}
	public Integer getOfflinePurchase() {
		return offlinePurchase;
	}
	public void setOfflinePurchase(Integer offlinePurchase) {
		this.offlinePurchase = offlinePurchase;
	}
	public ScreenMovie getScreenMovie() {
		return screenMovie;
	}
	public void setScreenMovie(ScreenMovie screenMovie) {
		this.screenMovie = screenMovie;
	}
}
