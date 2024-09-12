package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ordenes")

public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_orden")
	private Date fecha_orden;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicita")
	private Date fecha_solicita;

	@Column(name = "estado")
	private String estado;

	// relacion de muchos a uno oden a pago

	@ManyToOne
	@JoinColumn(name = "forma_pago_id", nullable = false)
	private Formapago formapago;

	// relacion de muchos a uno almacenes a orden

	@ManyToOne
	@JoinColumn(name = "almacen_id", nullable = false)
	private Almacen almacen;

	// relacion de muchos a uno proveedores a orden

	@ManyToOne
	@JoinColumn(name = "proveedor_id", nullable = false)
	private Proveedor proveedor;

	// relacion de muchos a uno tipoorden a orden

	@ManyToOne
	@JoinColumn(name = "tipo_orden_id", nullable = false)
	private Tipoorden tipoorden;

}
