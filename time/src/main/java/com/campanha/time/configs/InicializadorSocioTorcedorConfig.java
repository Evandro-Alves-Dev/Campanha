package com.campanha.time.configs;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.repositories.SocioTorcedorRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

@Configuration
public class InicializadorSocioTorcedorConfig {

	@Autowired
	SocioTorcedorRepository sociotorcedorrepository;	
	
	@PostConstruct
	public void inicializar() {

		if (sociotorcedorrepository.count() > 0) {
			return;
		}
		
		SocioTorcedor sociotorcedor = new SocioTorcedor();
		sociotorcedor.setNome("Carlos");
		sociotorcedor.setEmail("carlos@everis.com");		
		sociotorcedor.setDataNascimento(LocalDate.of(1980, 10, 27));		
		sociotorcedor.setTime("Santos");
		sociotorcedorrepository.save(sociotorcedor);
		
		
		//SocioTorcedor sociotorcedor1 = new SocioTorcedor();
	}

}
