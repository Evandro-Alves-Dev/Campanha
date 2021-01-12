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
import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.SocioTorcedorRepository;
import com.campanha.time.services.impl.SocioTorcedorServiceImpl;

@RestController
public class SocioTorcedorController {

	@Autowired
	SocioTorcedorRepository sociotorcedorrepository;

	@Autowired
	SocioTorcedorServiceImpl sociotorcedorserviceimpl;

	// Incluir um novo sócio torcedor
	@PostMapping("/novosociotorcedor")
	public List<SocioTorcedor> Salvar(@RequestBody SocioTorcedor sociotorcedor, Time time, Campanha campanha)
			throws Exception {
		sociotorcedorserviceimpl.verificaSeJaExisteCliente(sociotorcedor, time, campanha);
		return sociotorcedorserviceimpl.verificaCampanhaValida(sociotorcedor, time, campanha);

	}

	// Consulta todos os sócio torcedores
	@GetMapping("/sociotorcedor")
	public List<SocioTorcedor> Listar() {
		try {
			return sociotorcedorrepository.findAll();
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao consultar os sócios torcedores");
		}
		return null;
	}

	// Excluir um sócio torcedor
	@DeleteMapping("/deletasociotorcedor")
	public void Excluir(@RequestBody SocioTorcedor sociotorcedor) {
		try {
			sociotorcedorrepository.delete(sociotorcedor);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar uma campanha");
		}
	}

	// Atualiza um sócio torcedor
	@PutMapping("/atualizasociotorcedor")
	public SocioTorcedor Atualiza(@RequestBody SocioTorcedor sociotorcedor) {
		try {
			return sociotorcedorrepository.save(sociotorcedor);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar uma campanha");
		}
		return null;
	}

}
