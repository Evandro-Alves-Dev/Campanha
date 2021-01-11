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

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.services.impl.CampanhaServiceImpl;

@RestController
public class CampanhaController {

	@Autowired
	CampanhaRepository campanharepository;

	@Autowired
	CampanhaServiceImpl campanhaserviceimpl;

	// Incluir uma nova campanha
	@PostMapping("/novacampanha")
	public Campanha Salvar(@RequestBody Campanha campanha, Time time) {
		try {
			campanhaserviceimpl.garanteNomeUnico(campanha);
			campanhaserviceimpl.garanteCadastroCorreto(campanha, time);
			campanhaserviceimpl.verificaVigenciaCampanha(campanha);		
			return campanharepository.save(campanha);
		} catch (Exception e) {
			return null;
		}
		
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
		campanharepository.delete(campanha);
	}

	// Atualizar uma campanha
	@PutMapping("/atualizacampanha")
	public Campanha Atualizar(@RequestBody Campanha campanha) {
		return campanharepository.save(campanha);

	}

}
