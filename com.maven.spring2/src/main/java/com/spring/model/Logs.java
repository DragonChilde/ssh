package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Logs {
	private int id;
	private String msg;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}
	public String getMsg() {
		return msg;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
