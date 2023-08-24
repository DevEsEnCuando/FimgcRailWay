package com.dailycodework.sbemailverificationdemo.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Documento")
public class Documento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long  id;

	@Column(name = "numeroDocumento")
	private String numeroDocumento;

	@Column(name = "fechaGeneracion")
	private Date fechaGeneracion;

	@Column(name = "fechaEnvio")
	private Date fechaEnvio;

	@Column(name = "fechaRecepcion")
	private Date fechaRecepcion;
	
	@Column(name = "archivopdfSF")
	private String archivopdfSF;
	
	@Column(name = "archivopdfCF")
	private String archivopdfCF;
	
	//atributos de Dictamen
	@Column(name = "resultado")
	private String resultado;
	
	@Column(name = "fechaPlazo")
	private Date fechaPlazo;
	
	//atributos de RD
	@Column(name = "fechaSustentacion")
	private Date fechaSustentacion;
	
	@Column(name = "horaSustentacion")
	private String horaSustentacion;
	
	@Column(name = "lugarSustentacion")
	private String lugarSustentacion;
	
	//atributos de RCF
	@Column(name = "fechaSesionCF")
	private Date fechaSesionCF;

	
	

	@ManyToOne
	@JoinColumn
	private TipoDocumento tipoDocumento;

	@ManyToOne
	@JoinColumn
	private Expediente expediente;

	
	// Constructor, getters and setters
	public Documento() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}


	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}


	public Date getFechaEnvio() {
		return fechaEnvio;
	}


	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}


	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}


	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}



	public String getArchivopdfSF() {
		return archivopdfSF;
	}


	public void setArchivopdfSF(String archivopdfSF) {
		this.archivopdfSF = archivopdfSF;
	}


	public String getArchivopdfCF() {
		return archivopdfCF;
	}


	public void setArchivopdfCF(String archivopdfCF) {
		this.archivopdfCF = archivopdfCF;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	public Date getFechaPlazo() {
		return fechaPlazo;
	}


	public void setFechaPlazo(Date fechaPlazo) {
		this.fechaPlazo = fechaPlazo;
	}	

	public Date getFechaSustentacion() {
		return fechaSustentacion;
	}

	public void setFechaSustentacion(Date fechaSustentacion) {
		this.fechaSustentacion = fechaSustentacion;
	}

	public String getHoraSustentacion() {
		return horaSustentacion;
	}

	public void setHoraSustentacion(String horaSustentacion) {
		this.horaSustentacion = horaSustentacion;
	}

	public String getLugarSustentacion() {
		return lugarSustentacion;
	}

	public void setLugarSustentacion(String lugarSustentacion) {
		this.lugarSustentacion = lugarSustentacion;
	}

	public Date getFechaSesionCF() {
		return fechaSesionCF;
	}


	public void setFechaSesionCF(Date fechaSesionCF) {
		this.fechaSesionCF = fechaSesionCF;
	}

	
	
	
	
	
	//G&S de las relaciones

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}




 
