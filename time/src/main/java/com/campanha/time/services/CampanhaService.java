package com.campanha.time.services;

import java.util.List;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;

public interface CampanhaService {

	List<Campanha> campanhaVigente();	
	boolean verificaVigenciaCampanha(Campanha campanha);
	List<Campanha> alteraDataCampanhas();
	List<Campanha> garanteCadastroCorreto(Campanha campanha, Time time);
	Campanha garanteNomeUnico(Campanha campanha);
	
}
