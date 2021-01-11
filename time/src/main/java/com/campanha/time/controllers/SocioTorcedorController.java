package com.campanha.time.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.repositories.SocioTorcedorRepository;
import com.campanha.time.services.impl.SocioTorcedorServiceImpl;

@RestController
public class SocioTorcedorController {
	
	@Autowired
	SocioTorcedorRepository sociotorcedorrepository;
	
	@Autowired
	SocioTorcedorServiceImpl sociotorcedorserviceimpl;
		
	//Incluir um novo sócio torcedor
	@PostMapping("/novosociotorcedor")
	public SocioTorcedor Salvar(@RequestBody SocioTorcedor sociotorcedor) throws Exception {
		return sociotorcedorserviceimpl.verificaSeJaExisteCliente(sociotorcedor);
	}
	
	//Consulta todos os sócio torcedores
	@GetMapping("/sociotorcedor")
	public List<SocioTorcedor> Listar(){
		return sociotorcedorrepository.findAll();
	}
	
	//Excluir um sócio torcedor
	@DeleteMapping("/deletasociotorcedor")
	public void Excluir(@RequestBody SocioTorcedor sociotorcedor) {
		sociotorcedorrepository.delete(sociotorcedor);
	}
	
	//Atualiza um sócio torcedor
	@PutMapping("/atualizasociotorcedor")
	public SocioTorcedor Atualiza(@RequestBody SocioTorcedor sociotorcedor) {
		return sociotorcedorrepository.save(sociotorcedor);
	}
		

}
