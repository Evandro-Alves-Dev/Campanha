package com.campanha.time.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.time.models.Time;
import com.campanha.time.services.impl.TimeServiceImpl;

@RestController
@RequestMapping("/api/time")
public class TimeController {

	@Autowired
	TimeServiceImpl timeserviceimpl;

	// Inclui um novo time
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Time salvar(@RequestBody Time time) throws Exception {
		return timeserviceimpl.verificaNomeIgual(time);
	}

	// Consulta todos os times
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Time> listar() {
		return timeserviceimpl.listarTimes();
	}

	// Exclui um time
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@RequestBody Time time) {
		timeserviceimpl.deletarTime(time);
	}

	// Atualiza um time
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Time atualiza(@RequestBody Time time) {
		return timeserviceimpl.atualizaTime(time);
	}

}
