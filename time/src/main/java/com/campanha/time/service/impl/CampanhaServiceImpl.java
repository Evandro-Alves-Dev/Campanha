package com.campanha.time.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.modelo.Campanha;
import com.campanha.time.repository.CampanhaRepository;
import com.campanha.time.service.CampanhaService;

@Service
public class CampanhaServiceImpl implements CampanhaService {

	@Autowired
	CampanhaRepository campanharepository;

	//Seleciona apenas as datas que não estão vencidas de acordo com o dia em que o relatório foi puxado
	@Override
	public List<Campanha> campanhaVigente() {
		List<Campanha> listaCorreta = new ArrayList<>();
		List<Campanha> lista = campanharepository.findAll();
		for (Campanha campanha : lista) {
			if (campanha.getDataFimVigencia().isAfter(LocalDate.now())) {
				Campanha save = campanharepository.save(campanha);
				listaCorreta.add(save);
			}
		}
		return listaCorreta;
	}

	// Verifica se as datas das campanhas existentes são iguais as novas que serão cadastradas
	@Override
	public boolean verificaVigenciaCampanha(Campanha campanha) {
		List<Campanha> listaGeral = campanharepository.findAll();
		for (Campanha itemLista : listaGeral) {
			if (itemLista.getDataFimVigencia().equals(campanha.getDataFimVigencia())) {
				return true;
			}
		}
		return false;
	}

	//Acrscenta 1 dia em todas as campanhas ja cadastradas
	@Override
	public List<Campanha> alteraDataCampanhas() {
		List<Campanha> listaAtualizada = new ArrayList<>();
		List<Campanha> listaGeral = campanharepository.findAll();
		for (Campanha itemLista : listaGeral) {
			itemLista.setDataFimVigencia(itemLista.getDataFimVigencia().plusDays(1));
			Campanha save = campanharepository.save(itemLista);
			listaAtualizada.add(save);
		}
		return listaAtualizada;
	}

};