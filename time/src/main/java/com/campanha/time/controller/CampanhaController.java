package com.campanha.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.time.modelo.Campanha;
import com.campanha.time.repository.CampanhaRepository;
import com.campanha.time.service.impl.CampanhaServiceImpl;

@RestController
public class CampanhaController {

	@Autowired
	CampanhaRepository campanharepository;

	@Autowired
	CampanhaServiceImpl campanhaserviceimpl;

	// Incluir uma nova campanha
	@PostMapping("/novacampanha")
	public Campanha Salvar(@RequestBody Campanha campanha) {
		boolean verificado = campanhaserviceimpl.verificaVigenciaCampanha(campanha);
		if (verificado) {
			campanhaserviceimpl.alteraDataCampanhas();
		}
		return campanharepository.save(campanha);
		
	}

	// Consultar todas as campanhas
	@GetMapping("/campanha")
	public List<Campanha> Listar() {
		List<Campanha> vigencia = campanhaserviceimpl.campanhaVigente();
		return vigencia;
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
