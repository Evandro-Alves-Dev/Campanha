package com.campanha.time.configs;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.campanha.time.models.Campanha;
import com.campanha.time.repositories.CampanhaRepository;

@Configuration
public class InicializadorCampanhaConfig {	
		
	@Autowired
	CampanhaRepository campanharepository;
	
	@PostConstruct
	public void inicializar() {
		
		if (campanharepository.count() > 0) {
			return;
		}
		
		Campanha campanha = new Campanha();
		campanha.setNomeCampanha("Verdão");
		campanha.setDataInicioVigencia(LocalDate.of(2021, 01, 01));
		campanha.setDataFimVigencia(LocalDate.of(2021, 01, 20));		
		campanharepository.save(campanha);
		
		//Campanha campanha1 = new Campanha();
	}
	
	
	
	

}
