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

	@Autowired
	CampanhaRepository campanharepository;

	@Autowired
	TimeRepository timerepository;
	
	//Verifica se o cliente ja existe através do nome e data de nascimento
	@Override
	public SocioTorcedor verificaSeJaExisteCliente(SocioTorcedor sociotorcedor, Time time, Campanha campanha)
			throws Exception {
		List<SocioTorcedor> listaGeral = sociotorcedorrepository.findAll();
		for (SocioTorcedor socioLista : listaGeral) {
			if (socioLista.getNome().equals(sociotorcedor.getNome())
					&& socioLista.getDataNascimento().equals(sociotorcedor.getDataNascimento())) {
				throw new Exception("Sócio ja cadastrado no sistema");
			} else {
				verificaCampanhaValida(sociotorcedor, time, campanha);
			}
		}
		return sociotorcedorrepository.save(sociotorcedor);
	}
	
	//Verifica se existe um time e uma campnaha no banco de dados
	@Override
	public List<SocioTorcedor> verificaCampanhaValida(SocioTorcedor sociotorcedor, Time time, Campanha campanha)
			throws Exception {
		List<SocioTorcedor> listaGeral = sociotorcedorrepository.findAll();
		List<SocioTorcedor> novaLista = new ArrayList<>();
		for (SocioTorcedor socioLista : listaGeral) {
			if (socioLista.getTime().equals(time.getTime())
					&& socioLista.getCampanha().equals(campanha.getId())) {
				SocioTorcedor save = sociotorcedorrepository.save(socioLista);
				novaLista.add(save);
			}
			
		}return novaLista;
	}

}
