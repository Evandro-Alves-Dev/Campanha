package com.campanha.time.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campanha.time.models.Campanha;
import com.campanha.time.repositories.CampanhaRepository;
import com.campanha.time.responses.BaseResponse;

@Service
public class CampanhasService {

	@Autowired
	CampanhaRepository campanharepository;

	public BaseResponse inserir(Campanha campanha) {
		BaseResponse baseresponse = new BaseResponse();
		baseresponse.setStatusCode(400);

		boolean validacao = verificaNomeCampanhaIgual(campanha);
		if (validacao) {
			baseresponse.setMessage("Campanha existente. Tente outro nome!");
			return baseresponse;
		} else {
			verificaVigenciaCampanha(campanha);
		}
		
		campanharepository.save(campanha);
		baseresponse.setMessage("Campanha inserida com sucesso!");
		return baseresponse;		
	}

	public boolean verificaNomeCampanhaIgual(Campanha campanha) {
		List<Campanha> nomeVerificado = campanharepository.findAll();
		for (Campanha nomeLista : nomeVerificado) {
			if (nomeLista.getNomeCampanha().equals(campanha.getNomeCampanha())) {
				return true;
			}
		}
		return false;
	}

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
