package com.campanha.time.services;

import java.util.List;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.models.Time;

public interface SocioTorcedorService {
	
	public SocioTorcedor verificaSeJaExisteCliente(SocioTorcedor sociotorcedor, Time time, Campanha campanha) throws Exception;
	
	public List<SocioTorcedor> verificaCampanhaValida(SocioTorcedor sociotorcedor, Time time, Campanha campanha) throws Exception;
	
	//public SocioTorcedor vinculaCampanha(SocioTorcedor sociotorcedor, Campanha campanha);
}
