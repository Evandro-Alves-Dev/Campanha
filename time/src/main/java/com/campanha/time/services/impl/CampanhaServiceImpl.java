package com.campanha.time.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.repositories.TimeRepository;
import com.campanha.time.services.CampanhaService;

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

	// Garante que a campanha só sera criada com o id do time (PRECISO USAR)
	@Override
	public List<Campanha> garanteCadastroCorreto(Campanha campanha, Time time) throws Exception {
		List<Campanha> listaNova = new ArrayList<>();
		List<Time> listaTime = timerepository.findAll();
		for (Time timeLista : listaTime) {
			if (timeLista.getId().equals(campanha.getTime())) {
				Campanha save = campanharepository.save(campanha);
				listaNova.add(save);
			}else { 
				throw new Exception("Time inválido, favor verificar.");				
			}
		}
		return listaNova;
	}

	// Verifica se as datas das campanhas existentes são iguais as novas que serão
	// cadastradas e que o nome não seja repetido
	@Override
	public Campanha verificaVigenciaCampanha(Campanha campanha) throws Exception {
		List<Campanha> listaGeral = campanharepository.findAll();
		for (Campanha itemLista : listaGeral) {
			if (itemLista.getDataFimVigencia().equals(campanha.getDataFimVigencia())
					&& itemLista.getDataInicioVigencia().equals(campanha.getDataInicioVigencia())) {
				alteraDataCampanhas();
			}
			if (itemLista.getNomeCampanha().equals(campanha.getNomeCampanha())) {
				throw new Exception("Campanha ja existe, tente outro nome.");
			}
		}
		return campanharepository.save(campanha);
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

	@Override
	public void excluirCampanha(Campanha campanha) {
		campanharepository.delete(campanha);
	}

	@Override
	public Campanha atualizaCampanha(Campanha campanha) {
		return campanharepository.save(campanha);
	}

}