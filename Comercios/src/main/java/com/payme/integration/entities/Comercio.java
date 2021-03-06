package com.payme.integration.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "comercio")
@Entity
public class Comercio {

	@Id
	private Integer idComercio;
	@Column(length = 75)
	private String nombre;
	@Column(length = 40)
	private String signature;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_integracion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoIntegracion tipoIntegracion;
}
