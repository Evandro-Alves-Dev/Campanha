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
import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.SocioTorcedorRepository;
import com.campanha.time.services.impl.SocioTorcedorServiceImpl;

@RestController
@RequestMapping("api/sociotorcedor")
public class SocioTorcedorController {

	@Autowired
	SocioTorcedorServiceImpl sociotorcedorserviceimpl;

	// Incluir um novo sócio torcedor
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SocioTorcedor salvar(@RequestBody SocioTorcedor sociotorcedor) throws Exception {
		return sociotorcedorserviceimpl.verificaSeJaExisteCliente(sociotorcedor);
	}

	// Consulta todos os sócios torcedores
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SocioTorcedor> listar() {
		return sociotorcedorserviceimpl.listarSocioTorcedor();
	}

	// Excluir um sócio torcedor
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@RequestBody SocioTorcedor sociotorcedor) {
		sociotorcedorserviceimpl.excluiSocioTorcedor(sociotorcedor);
	}

	// Atualiza um sócio torcedor
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SocioTorcedor atualiza(@RequestBody SocioTorcedor sociotorcedor) {
		return sociotorcedorserviceimpl.atualizaSocioTorcedor(sociotorcedor);
	}
}
