package com.es.pos.vo;

public class Pos {

	private Integer id;
	private String pid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Pos [id=" + id + ", pid=" + pid + "]";
	}
	
}
