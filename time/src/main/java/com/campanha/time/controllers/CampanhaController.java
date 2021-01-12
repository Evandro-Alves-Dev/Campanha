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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.services.CampanhasService;
import com.campanha.time.services.impl.CampanhaServiceImpl;

@RestController
@RequestMapping("api/campanha")
public class CampanhaController {

	@Autowired
	CampanhaRepository campanharepository;

	@Autowired
	CampanhaServiceImpl campanhaserviceimpl;

	@Autowired
	CampanhasService campanhasservice;

	// Incluir uma nova campanha
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Campanha> salvar(@RequestBody Campanha campanha, Time time) throws Exception {		
		return ResponseEntity.ok(campanhaserviceimpl.verificaVigenciaCampanha(campanha));		
	}

	// Consultar todas as campanhas
	@GetMapping("/campanha")
	public ResponseEntity Listar() {
		try {
			List<Campanha> vigencia = campanhaserviceimpl.campanhaVigente();
			return ResponseEntity.status(HttpStatus.OK).body(vigencia);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Campanha não encontrada!");
		}
	}

	// Deletar uma campanha
	@DeleteMapping("/deletacampanha")
	public void Deletar(@RequestBody Campanha campanha) {
		try {
			campanharepository.delete(campanha);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar a campanha");
		}
	}

	// Atualizar uma campanha
	@PutMapping("/atualizacampanha")
	public Campanha Atualizar(@RequestBody Campanha campanha) {
		try {
			return campanharepository.save(campanha);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar uma campanha");
		}
		return null;

	}

}
