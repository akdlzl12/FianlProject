package com.es.movie.web.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.es.movie.vo.MovieTimetable;

public class TimetableForm {
	
	private String dates;
	private Integer screen1;
	private Integer screen2;
	private Integer screen3;
	private Integer screen4;
	private Map<Integer, List<Timetable>> tables = new HashMap<Integer, List<Timetable>>();
	
	private List<MovieTimetable> timetableList;
	public void setTimetableList(List<MovieTimetable> timetableList) {
		timetableList.add(new MovieTimetable());
		this.timetableList = timetableList;
	}
	
	public List<MovieTimetable> getTimetableList() {
		return timetableList;
	}
	
	
	
	public TimetableForm() {
		for (int i=1; i<=4; i++) {
			List<Timetable> list = new ArrayList<Timetable>();
			for (int j=0; j<9; j++) {
				list.add(new Timetable());
			}
			tables.put(i, list);
		}
	}
	
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public Integer getScreen1() {
		return screen1;
	}
	public void setScreen1(Integer screen1) {
		this.screen1 = screen1;
	}
	public Integer getScreen2() {
		return screen2;
	}
	public void setScreen2(Integer screen2) {
		this.screen2 = screen2;
	}
	public Integer getScreen3() {
		return screen3;
	}
	public void setScreen3(Integer screen3) {
		this.screen3 = screen3;
	}
	public Integer getScreen4() {
		return screen4;
	}
	public void setScreen4(Integer screen4) {
		this.screen4 = screen4;
	}
	public Map<Integer, List<Timetable>> getTables() {
		return tables;
	}
	public void setTables(Map<Integer, List<Timetable>> tables) {
		this.tables = tables;
	}
	

	@Override
	public String toString() {
		return "TimetableForm [dates=" + dates + ", screen1=" + screen1 + ", screen2=" + screen2 + ", screen3="
				+ screen3 + ", screen4=" + screen4 + ", tables=" + tables + "]";
	}


	public class Timetable {
		
		private Integer ordered;
		private String startedAt;
		private String endedAt;
		public String getStartedAt() {
			return startedAt;
		}
		public void setStartedAt(String startedAt) {
			this.startedAt = startedAt;
		}
		public String getEndedAt() {
			return endedAt;
		}
		public void setEndedAt(String endedAt) {
			this.endedAt = endedAt;
		}

		public Integer getOrdered() {
			return ordered;
		}
		public void setOrdered(Integer ordered) {
			this.ordered = ordered;
		}
		@Override
		public String toString() {
			return "Timetable [ordered=" + ordered + ", startedAt=" + startedAt + ", endedAt=" + endedAt + "]";
		}
	
		
	}
	
	
	
}
