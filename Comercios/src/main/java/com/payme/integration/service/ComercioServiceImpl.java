package com.payme.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payme.integration.entities.Comercio;
import com.payme.integration.entities.TipoIntegracion;
import com.payme.integration.repository.ComercioRepository;

@Service
public class ComercioServiceImpl implements ComercioService{

	@Autowired
	private ComercioRepository repo;
	
	@Override
	public List<Comercio> listAllComercios() {

		return repo.findAll();
	}

	@Override
	public List<Comercio> findByTipoIntegracion(TipoIntegracion tipoIntegracion) {
		
		return repo.findByTipoIntegracion(tipoIntegracion);
	}

	@Override
	public Comercio getComercio(Integer id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Comercio createComercio(Comercio comercio) {
		
		return repo.save(comercio);
	}

	@Override
	public Comercio updateComerio(Integer id, Comercio comercio) {
		
		Comercio comerciodb = getComercio(id);
		
		if(comerciodb == null) {
			return null;
		}
		
		comerciodb.setNombre(comercio.getNombre());
		comerciodb.setSignature(comercio.getSignature());
		comerciodb.setTipoIntegracion(comercio.getTipoIntegracion());
		
		return repo.save(comerciodb);
	}

	@Override
	public Comercio updateSignature(Integer id, String signature) {
		Comercio comerciodb = getComercio(id);
		
		if(comerciodb == null) {
			return null;
		}
		
		comerciodb.setSignature(signature);
		
		return repo.save(null);
	}

}
