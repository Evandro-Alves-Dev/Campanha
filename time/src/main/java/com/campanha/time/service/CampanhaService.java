package com.campanha.time.service;

import java.util.List;

import com.campanha.time.modelo.Campanha;

public interface CampanhaService {

	List<Campanha> campanhaVigente();
	boolean verificaVigenciaCampanha(Campanha campanha);
	List<Campanha> alteraDataCampanhas();
	
}
