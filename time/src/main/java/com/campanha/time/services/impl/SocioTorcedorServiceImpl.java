package com.campanha.time.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.repositories.SocioTorcedorRepository;
import com.campanha.time.repositories.TimeRepository;
import com.campanha.time.services.SocioTorcedorService;

@Service
public class SocioTorcedorServiceImpl implements SocioTorcedorService {

	@Autowired
	SocioTorcedorRepository sociotorcedorrepository;

	@Autowired
	CampanhaRepository campanharepository;

	@Autowired
	TimeRepository timerepository;

	@Override
	public SocioTorcedor verificaSeJaExisteCliente(SocioTorcedor sociotorcedor) throws Exception {
		List<SocioTorcedor> listaGeral = sociotorcedorrepository.findAll();
		for (SocioTorcedor socioLista : listaGeral) {
			if (socioLista.getNome().equals(sociotorcedor.getNome())
					&& socioLista.getDataNascimento().equals(sociotorcedor.getDataNascimento())) {
				throw new Exception("Sócio ja cadastrado no sistema");
			} else {
				throw new Exception("Campanha precisa ser cadastrada");
			}
		}
		return sociotorcedorrepository.save(sociotorcedor);
	}

}