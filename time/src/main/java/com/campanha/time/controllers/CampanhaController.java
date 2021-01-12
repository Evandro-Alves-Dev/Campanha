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

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;
import com.campanha.time.services.impl.CampanhaServiceImpl;

@RestController
@RequestMapping("api/campanha")
public class CampanhaController {
	
	@Autowired
	CampanhaServiceImpl campanhaserviceimpl;	

	// Incluir uma nova campanha
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Campanha salvar(@RequestBody Campanha campanha, Time time) throws Exception {
		return campanhaserviceimpl.verificaVigenciaCampanha(campanha);
	}

	// Consultar todas as campanhas
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Campanha> listar() {
		return campanhaserviceimpl.campanhaVigente();		
	}

	// Deletar uma campanha
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@RequestBody Campanha campanha) {
		campanhaserviceimpl.excluirCampanha(campanha);
	}

	// Atualizar uma campanha
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Campanha atualizar(@RequestBody Campanha campanha) {
		return campanhaserviceimpl.atualizaCampanha(campanha);
	}

}
