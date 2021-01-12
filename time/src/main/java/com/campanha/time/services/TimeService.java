package com.campanha.time.services;

import java.util.List;

import com.campanha.time.models.Time;

public interface TimeService {
	
	public Time verificaNomeIgual(Time time)throws Exception;
	public List<Time> listarTimes();
	public void deletarTime(Time time);
	public Time atualizaTime(Time time);
}
