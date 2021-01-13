package com.campanha.time.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.models.Time;
import com.campanha.time.repositories.TimeRepository;
import com.campanha.time.services.TimeService;

@Service
public class TimeServiceImpl implements TimeService {

	@Autowired
	TimeRepository timerepository;

	@Override
	public Time verificaNomeIgual(Time time) throws Exception {
		List<Time> listaGeral = timerepository.findAll();
		for (Time timeLista : listaGeral) {
			if (timeLista.getTime().equalsIgnoreCase(time.getTime())) {
				throw new Exception("Time ja existe");
			}
		}
		return timerepository.save(time);
	}

	@Override
	public List<Time> listarTimes() {
		return timerepository.findAll();
	}

	@Override
	public void deletarTime(Time time) {
		timerepository.delete(time);
	}

	@Override
	public Time atualizaTime(Time time) {
		return timerepository.save(time);
	}

}
