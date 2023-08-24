package com.dailycodework.sbemailverificationdemo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="escuela")
public class Escuela implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",length=100)
	private String nombre;
	
	@Column(name="director",length=100)
	private String director;

	@Column(name="nombreGradoBachiller",length=100)
	private String nombreGradoBachiller;

	
	
	// Constructor sin argumentos para JPA
    public Escuela() {
    	
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getNombreGradoBachiller() {
		return nombreGradoBachiller;
	}
	public void setNombreGradoBachiller(String nombreGradoBachiller) {
		this.nombreGradoBachiller = nombreGradoBachiller;
	}

	
}
