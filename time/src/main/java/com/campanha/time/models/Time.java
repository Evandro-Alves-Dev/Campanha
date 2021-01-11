package com.campanha.time.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_TIME")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String time;
	
//	@ManyToOne
//	private Campanha campnha;
//
//	public Campanha getCampnha() {
//		return campnha;
//	}
//
//	public void setCampnha(Campanha campnha) {
//		this.campnha = campnha;
//	}

	public Long getId() {
		return id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
