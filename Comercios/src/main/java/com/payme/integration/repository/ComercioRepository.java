package com.payme.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payme.integration.entities.Comercio;
import com.payme.integration.entities.TipoIntegracion;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Integer> {

	public List<Comercio> findByTipoIntegracion(TipoIntegracion tipoIntegracion);
}
