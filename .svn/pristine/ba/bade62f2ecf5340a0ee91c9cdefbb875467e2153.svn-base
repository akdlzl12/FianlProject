package com.es.movie.vo;

import java.util.Date;

import com.es.util.TimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SelectTimetable {
	private Integer id;
	private String screenName;
	private Integer ordered;
	private String title;
	@JsonSerialize(using=TimeSerializer.class)
	private Date startedAt;
	@JsonSerialize(using=TimeSerializer.class)
	private Date endedAt;
	private Integer seatsCount;
	private Integer onlinePurchase;
	private Integer offlinePurchase;
	private Integer reservedSeatsCount;
	
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public Integer getOrdered() {
		return ordered;
	}
	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getSeatsCount() {
		return seatsCount;
	}
	public void setSeatsCount(Integer seatsCount) {
		this.seatsCount = seatsCount;
	}
	public Integer getReservedSeatsCount() {
		return reservedSeatsCount;
	}
	public void setReservedSeatsCount(Integer reservedSeatsCount) {
		this.reservedSeatsCount = reservedSeatsCount;
	}
	@Override
	public String toString() {
		return "SelectTimetable [id=" + id + ", screenName=" + screenName + ", ordered=" + ordered + ", title=" + title
				+ ", startedAt=" + startedAt + ", endedAt=" + endedAt + ", seatsCount=" + seatsCount
				+ ", onlinePurchase=" + onlinePurchase + ", offlinePurchase=" + offlinePurchase
				+ ", reservedSeatsCount=" + reservedSeatsCount + "]";
	}
	
	
	
	
}
