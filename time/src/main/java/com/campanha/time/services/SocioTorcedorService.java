package com.campanha.time.services;

import java.util.List;

import com.campanha.time.models.Campanha;
import com.campanha.time.models.SocioTorcedor;
import com.campanha.time.models.Time;

public interface SocioTorcedorService {
	
	public SocioTorcedor verificaSeJaExisteCliente(SocioTorcedor sociotorcedor) throws Exception;	
	public List<SocioTorcedor> listarSocioTorcedor();
	public void excluiSocioTorcedor(SocioTorcedor sociotroecedor);
	public SocioTorcedor atualizaSocioTorcedor(SocioTorcedor sociotorcedor);	
}
