package com.campanha.time.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.time.models.Time;
import com.campanha.time.repositories.TimeRepository;
import com.campanha.time.services.impl.TimeServiceImpl;

@RestController
//@RequestMapping
public class TimeController {

	@Autowired
	TimeRepository timerepository;

	@Autowired
	TimeServiceImpl timeserviceimpl;

	// Inclui um novo time
	@PostMapping("/novotime")
	public Time Salvar(@RequestBody Time time) throws Exception {
		return timeserviceimpl.verificaNomeIgual(time);
	}

	// Consulta todos os times
	@GetMapping("/time")
	public List<Time> Listar() {
		return timeserviceimpl.listarTimes();
	}

	// Exclui um time
	@DeleteMapping("/deletatime")
	public void Excluir(@RequestBody Time time) {
		timeserviceimpl.deletarTime(time);
	}

	// Atualiza um time
	@PutMapping("atualizatime")
	public Time Atualiza(@RequestBody Time time) {
		return timeserviceimpl.atualizaTime(time);
	}

}
