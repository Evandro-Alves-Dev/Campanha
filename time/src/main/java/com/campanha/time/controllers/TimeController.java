package com.campanha.time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.time.models.Time;
import com.campanha.time.repositories.TimeRepository;

@RestController
public class TimeController {
	
	@Autowired
	TimeRepository timerepository;
	
	//
	@PostMapping("/novotime")
	public Time Salvar(@RequestBody Time time) {
		return timerepository.save(time);
	}
	
	
	

}
