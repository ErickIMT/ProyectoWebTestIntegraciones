package com.payme.integration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payme.integration.entities.Comercio;
import com.payme.integration.entities.TipoIntegracion;
import com.payme.integration.service.ComercioServiceImpl;

@RestController
@RequestMapping(value = "comercio")
public class ComercioController {

	@Autowired
	private ComercioServiceImpl serv;
	
	@GetMapping
	public ResponseEntity<List<Comercio>> listComercios(@RequestParam(name = "idTipoIntegracion", required = false) Integer idTipoIntegracion){
		List<Comercio> response= new ArrayList<>();
		
		if(idTipoIntegracion == null) {
			response = serv.listAllComercios();
			if(response.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			response = serv.findByTipoIntegracion(TipoIntegracion.builder().idTipoIntegracion(idTipoIntegracion).build());
			if(response.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}		
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comercio> getComercio(@PathVariable Integer id){
		Comercio response = serv.getComercio(id);
		
		if(response == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Comercio> createComercio(@RequestBody Comercio comercio){
		Comercio response = serv.createComercio(comercio);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comercio> updateComercio(@PathVariable Integer id, @RequestBody Comercio comercio){
		Comercio response = serv.updateComerio(id, comercio);
		
		if(response == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(response);
	}
	
	
}
