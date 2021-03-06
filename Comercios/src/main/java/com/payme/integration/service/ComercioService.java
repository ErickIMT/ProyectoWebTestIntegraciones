package com.payme.integration.service;

import java.util.List;

import com.payme.integration.entities.Comercio;
import com.payme.integration.entities.TipoIntegracion;

public interface ComercioService {

	public List<Comercio> listAllComercios();
	
	public List<Comercio> findByTipoIntegracion(TipoIntegracion tipoIntegracion);
	
	public Comercio getComercio(Integer id);
	
	public Comercio createComercio(Comercio comercio);
	
	public Comercio updateComerio(Integer id, Comercio comercio);
	
	public Comercio updateSignature(Integer id, String signature);
	
}
