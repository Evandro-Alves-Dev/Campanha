package com.campanha.time.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.repositories.TimeRepository;
import com.campanha.time.responses.BaseResponse;
import com.campanha.time.services.CampanhaService;

import ch.qos.logback.core.status.Status;

@Service
public class CampanhaServiceImpl implements CampanhaService {

	@Autowired
	CampanhaRepository campanharepository;

	@Autowired
	TimeRepository timerepository;

	// Seleciona apenas as datas que não estão vencidas de acordo com o dia em que o
	// relatório foi puxado
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

	// Garante que não haverá campanhas com nomes iguais (ANDA NÃO FUNCIONA)
	@Override
	public Campanha garanteNomeUnico(Campanha campanha) {
		List<Campanha> listaGeral = campanharepository.findAll();
		for (Campanha itemLista : listaGeral) {
			if (itemLista.getNomeCampanha().equals(campanha.getNomeCampanha())) {
				return null;
			}
		}
		return campanha;
	}

	// Garante que a campanha só sera criada com o id do time
	@Override
	public List<Campanha> garanteCadastroCorreto(Campanha campanha, Time time) {
		List<Campanha> listaNova = new ArrayList<>();
		List<Time> listaTime = timerepository.findAll();
		for (Time timeLista : listaTime) {
			if (timeLista.getId().equals(campanha.getTime())) {
				Campanha save = campanharepository.save(campanha);
				listaNova.add(save);
			}
		}
		return listaNova;
	}

	// Verifica se as datas das campanhas existentes são iguais as novas que serão
	// cadastradas
	@Override
	public boolean verificaVigenciaCampanha(Campanha campanha) {
		List<Campanha> listaGeral = campanharepository.findAll();
		for (Campanha itemLista : listaGeral) {
			if (itemLista.getDataFimVigencia().equals(campanha.getDataFimVigencia())
					&& itemLista.getDataInicioVigencia().equals(campanha.getDataInicioVigencia())) {
				alteraDataCampanhas();
			}

		}
		return false;
	}

	// Acrscenta 1 dia em todas as campanhas ja cadastradas
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

}