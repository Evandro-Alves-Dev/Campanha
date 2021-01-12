package com.campanha.time.configs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.campanha.time.models.Time;
import com.campanha.time.repositories.TimeRepository;

@Configuration
public class InicializadorTimeConfig {	
		
	@Autowired
	TimeRepository timerepository;
	
	@PostConstruct
	public void inicializar() {
		
		if (timerepository.count() > 0) {
			return;
		}
		
		Time time = new Time();
		time.setTime("Palmeiras");
		timerepository.save(time);
		
		Time time1 = new Time();
		time1.setTime("Santos");
		timerepository.save(time1);
		
	}
	
	
	
	

}
