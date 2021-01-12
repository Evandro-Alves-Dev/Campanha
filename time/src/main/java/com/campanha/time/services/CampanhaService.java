package com.campanha.time.services;

import java.util.List;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.Time;

public interface CampanhaService {

	public List<Campanha> campanhaVigente();	
	public Campanha verificaVigenciaCampanha(Campanha campanha)throws Exception ;
	public List<Campanha> alteraDataCampanhas();
	public List<Campanha> garanteCadastroCorreto(Campanha campanha, Time time)throws Exception ;	
	public void excluirCampanha(Campanha campanha); 
	public Campanha atualizaCampanha(Campanha campanha);
}
