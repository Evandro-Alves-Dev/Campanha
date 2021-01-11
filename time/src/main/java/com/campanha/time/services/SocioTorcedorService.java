package com.campanha.time.services;

import com.campanha.time.models.SocioTorcedor;

public interface SocioTorcedorService {
	
	public SocioTorcedor verificaSeJaExisteCliente(SocioTorcedor sociotorcedor) throws Exception;
	
	//public SocioTorcedor verificaCampanhasVinculadasSocio(SocioTorcedor sociotorcedor);
	
	//public SocioTorcedor vinculaCampanha(SocioTorcedor sociotorcedor, Campanha campanha);
}
