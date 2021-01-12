package com.campanha.time.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.repositories.SocioTorcedorRepository;
import com.campanha.time.repositories.TimeRepository;
import com.campanha.time.services.SocioTorcedorService;

@Service
public class SocioTorcedorServiceImpl implements SocioTorcedorService {

	@Autowired
	SocioTorcedorRepository sociotorcedorrepository;

	// Verifica se o cliente ja existe através do nome e data de nascimento
	@Override
	public SocioTorcedor verificaSeJaExisteCliente(SocioTorcedor sociotorcedor) throws Exception {
		List<SocioTorcedor> listaGeral = sociotorcedorrepository.findAll();
		for (SocioTorcedor socioLista : listaGeral) {
			if (socioLista.getNome().equals(sociotorcedor.getNome())
					&& socioLista.getDataNascimento().equals(sociotorcedor.getDataNascimento())) {
				throw new Exception("Sócio ja cadastrado no sistema");
			}
		}
		return sociotorcedorrepository.save(sociotorcedor);
	}

	@Override
	public List<SocioTorcedor> listarSocioTorcedor() {
		return sociotorcedorrepository.findAll();
	}

	@Override
	public void excluiSocioTorcedor(SocioTorcedor sociotroecedor) {
		sociotorcedorrepository.delete(sociotroecedor);
	}

	@Override
	public SocioTorcedor atualizaSocioTorcedor(SocioTorcedor sociotorcedor) {
		return sociotorcedorrepository.save(sociotorcedor);
	}
}
