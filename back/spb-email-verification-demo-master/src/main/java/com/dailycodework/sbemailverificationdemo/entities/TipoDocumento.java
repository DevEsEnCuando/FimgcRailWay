package com.dailycodework.sbemailverificationdemo.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name = "TipoDocumento")
	public class TipoDocumento implements Serializable{
	    
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "nombre", length=100)
	    private String nombre;
	    
	    @Column(name = "descripcion", length=100)
	    private String descripcion;
	    
	    @Column(name = "sigla", length=100)
	    private String sigla;    
	    
	    /*@OneToMany(mappedBy = "tipoDocumento")
	    private Documento documento;*/
	    // Constructor 
	    public TipoDocumento() {
	    	
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
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getSigla() {
			return sigla;
		}
		public void setSigla(String sigla) {
			this.sigla = sigla;
		}
	    
}
	    

