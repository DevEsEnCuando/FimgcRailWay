package com.dailycodework.sbemailverificationdemo.entities;



import java.io.Serializable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dailycodework.sbemailverificationdemo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Expediente") 
public class Expediente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nroExpediente", length=100,unique=true)
    private String nroExpediente;
    
    @Column(name = "fechaPresentacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPresentacion;

    @Column(name = "instancia")
    private String instancia;

    @Column(name = "estado")
    private String estado;
    
    @Column(name="version")
    private String version;
    
    @Column(name = "rutaDocumento")
    private String rutaDocumento;
    
    //Atributos exclusivo de Bachiller
       
    @Column(name = "concursoAdmision", length=50)
    private String concursoAdmision;

    @Column(name = "nroResolucionIngreso", length=100)
    private String nroResolucionIngreso;

    @Column(name = "fechaPrimMatricula", length=100)
    @Temporal(TemporalType.DATE)
    private Date fechaPrimMatricula;

    @Column(name = "fechaEgreso", length=100)
    @Temporal(TemporalType.DATE)
    private Date fechaEgreso;

    @Column(name = "codReciboCaja", length=100)
    private String codReciboCaja;

    @Column(name = "fechaReciboCaja", length=100)
    @Temporal(TemporalType.DATE)
    private Date fechaReciboCaja;
    
    @Column(name = "nroMemoEscuela")
    private String nroMemoEscuela;
    
    @Column(name = "fechaMemoEscuela")
    @Temporal(TemporalType.DATE)
    private Date fechaMemoEscuela;
    
    @Column(name = "nroDictEscuela")
    private String nroDictEscuela;
    
    @Column(name = "fechaDictEscuela")
    @Temporal(TemporalType.DATE)
    private Date fechaDictEscuela;
       
    @Column(name = "nroCertEstudios")
    private String nroCertEstudios;
    
    @Column(name = "fechaCertEstudios")
    @Temporal(TemporalType.DATE)
    private Date fechaCertEstudios;
    
    @Column(name = "idPlan")
    private Long idPlan;
   
    
    //Atributos exclusivo de Plan
    
    @Column(name = "tituloTesis", length=200)
    private String tituloTesis;
    
    //Atributos exclusivo de Borrador
    
    @Column(name = "fechaObtencionGrado")
    @Temporal(TemporalType.DATE)
    private Date fechaObtencionGrado;
    
    @Column(name = "nroRCU")
    private String nroRCU;
    
    @Column(name = "libro")
    private String libro;
    
    @Column(name = "folio")
    private String folio;
    
    @Column(name = "nroMMAprobacionPlan", length=100,unique=true)
    private String nroMMAprobacionPlan;
    
    @Column(name = "fechaMMAprobacionPlan")
    @Temporal(TemporalType.DATE)
    private Date fechaMMAprobacionPlan;
    
    @Column(name = "nroRDAprobacionPlan", length=100,unique=true)
    private String nroRDAprobacionPlan;
    
    @Column(name = "fechaRDAprobacionPlan")
    @Temporal(TemporalType.DATE)
    private Date fechaRDAprobacionPlan;
    
    //Atributos exclusivo de Titulo
    
    @Column(name = "nroActa")
    private String nroActa;
    
    @Column(name = "fechaSustentacion")
    @Temporal(TemporalType.DATE)
    private Date fechaSustentacion;
    
    @Column(name = "similitud")
    private String similitud;
    
    @Column(name = "calificacion")
    private String calificacion;
    
    
    
    //CONSTRUCTOR SIN ARGUMENTOS PARA JPA----------------------------------------------------------------------
    public Expediente() {
    
    }

    
    //GETTERS AND SETTERS DE LOS ATRIBUTOS DE EXPEDIENTE-------------------------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroExpediente() {
		return nroExpediente;
	}

	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}

	public Date getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getConcursoAdmision() {
		return concursoAdmision;
	}

	public void setConcursoAdmision(String concursoAdmision) {
		this.concursoAdmision = concursoAdmision;
	}

	public String getNroResolucionIngreso() {
		return nroResolucionIngreso;
	}

	public void setNroResolucionIngreso(String nroResolucionIngreso) {
		this.nroResolucionIngreso = nroResolucionIngreso;
	}

	public String getCodReciboCaja() {
		return codReciboCaja;
	}

	public void setCodReciboCaja(String codReciboCaja) {
		this.codReciboCaja = codReciboCaja;
	}

	public String getTituloTesis() {
		return tituloTesis;
	}

	public void setTituloTesis(String tituloTesis) {
		this.tituloTesis = tituloTesis;
	}
   
    public String getNroCertEstudios() {
		return nroCertEstudios;
	}

	public void setNroCertEstudios(String nroCertEstudios) {
		this.nroCertEstudios = nroCertEstudios;
	}

	public String getRutaDocumento() {
		return rutaDocumento;
	}

	public void setRutaDocumento(String rutaDocumento) {
		this.rutaDocumento = rutaDocumento;
	}

	public String getNroMemoEscuela() {
		return nroMemoEscuela;
	}

	public void setNroMemoEscuela(String nroMemoEscuela) {
		this.nroMemoEscuela = nroMemoEscuela;
	}

	public String getNroDictEscuela() {
		return nroDictEscuela;
	}

	public void setNroDictEscuela(String nroDictEscuela) {
		this.nroDictEscuela = nroDictEscuela;
	}

	public Date getFechaObtencionGrado() {
		return fechaObtencionGrado;
	}

	public void setFechaObtencionGrado(Date fechaObtencionGrado) {
		this.fechaObtencionGrado = fechaObtencionGrado;
	}

	public String getNroRCU() {
		return nroRCU;
	}

	public void setNroRCU(String nroRCU) {
		this.nroRCU = nroRCU;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	public String getNroMMAprobacionPlan() {
		return nroMMAprobacionPlan;
	}

	public void setNroMMAprobacionPlan(String nroMMAprobacionPlan) {
		this.nroMMAprobacionPlan = nroMMAprobacionPlan;
	}

	public Date getFechaMMAprobacionPlan() {
		return fechaMMAprobacionPlan;
	}

	public void setFechaMMAprobacionPlan(Date fechaMMAprobacionPlan) {
		this.fechaMMAprobacionPlan = fechaMMAprobacionPlan;
	}

	public String getNroRDAprobacionPlan() {
		return nroRDAprobacionPlan;
	}

	public void setNroRDAprobacionPlan(String nroRDAprobacionPlan) {
		this.nroRDAprobacionPlan = nroRDAprobacionPlan;
	}

	public Date getFechaRDAprobacionPlan() {
		return fechaRDAprobacionPlan;
	}

	public void setFechaRDAprobacionPlan(Date fechaRDAprobacionPlan) {
		this.fechaRDAprobacionPlan = fechaRDAprobacionPlan;
	}

	public Date getFechaPrimMatricula() {
		return fechaPrimMatricula;
	}

	public void setFechaPrimMatricula(Date fechaPrimMatricula) {
		this.fechaPrimMatricula = fechaPrimMatricula;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public Date getFechaReciboCaja() {
		return fechaReciboCaja;
	}

	public void setFechaReciboCaja(Date fechaReciboCaja) {
		this.fechaReciboCaja = fechaReciboCaja;
	}

	public Date getFechaMemoEscuela() {
		return fechaMemoEscuela;
	}

	public void setFechaMemoEscuela(Date fechaMemoEscuela) {
		this.fechaMemoEscuela = fechaMemoEscuela;
	}

	public Date getFechaDictEscuela() {
		return fechaDictEscuela;
	}

	public void setFechaDictEscuela(Date fechaDictEscuela) {
		this.fechaDictEscuela = fechaDictEscuela;
	}

	public Date getFechaCertEstudios() {
		return fechaCertEstudios;
	}

	public void setFechaCertEstudios(Date fechaCertEstudios) {
		this.fechaCertEstudios = fechaCertEstudios;
	}

	public Long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}

	public String getNroActa() {
		return nroActa;
	}

	public void setNroActa(String nroActa) {
		this.nroActa = nroActa;
	}

	public Date getFechaSustentacion() {
		return fechaSustentacion;
	}

	public void setFechaSustentacion(Date fechaSustentacion) {
		this.fechaSustentacion = fechaSustentacion;
	}

	public String getSimilitud() {
		return similitud;
	}

	public void setSimilitud(String similitud) {
		this.similitud = similitud;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}





	//RELACIONES CON LAS OTRAS TABLAS---------------------------------------------------------------------  
	@JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "modalidadIngreso_id")
    private ModalidadIngreso modalidadIngreso;    
    
    
    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
    
    
	/*
	 * +++DE LA UNICA RELACION SALEN 4
	 * 
	 * @JsonIgnoreProperties("expedientes")
	 * @ManyToOne
	 * @JoinColumn(name = "user_id")
	 * private User user;
	 */
    
    
    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_interesado")
    private User interesado;

    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_presidente")
    private User presidente;

    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_miembro")
    private User miembro;
    
    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_asesor")
    private User asesor;
    
    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_secredocente")
    private User secredocente;
    
    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_presidenteescuela")
    private User presidenteescuela;

    @JsonIgnoreProperties("expedientes")
    @ManyToOne
    @JoinColumn(name = "user_id_miembroescuela")
    private User miembroescuela;
    
        
    @JsonIgnoreProperties("expediente")
	@OneToMany(mappedBy = "expediente")
    private List<Documento> documentos;
    
    
    
    //Métodos para obtener sólo el id de los users
    
	/*
	 * +++DE LA UNICA RELACION SALEN 4
	 * @JsonProperty("user_id") 
	 * public Long getUserId() { 
	 * return user != null ? user.getId() : null; }
	 */
	/*
	 * @JsonProperty("user_id_interesado") public Long getClientUserId() { return
	 * interesado != null ? interesado.getId() : null; }
	 * 
	 * @JsonProperty("user_id_presidente") public Long getPresidentUserId() { return
	 * presidente != null ? presidente.getId() : null; }
	 * 
	 * @JsonProperty("user_id_miembro") public Long getMemberUserId() { return
	 * miembro != null ? miembro.getId() : null; }
	 * 
	 * @JsonProperty("user_id_asesor") public Long getAdvisorUserId() { return
	 * asesor != null ? asesor.getId() : null; }
	 */
    
    
    
    //GETTERS & SETTERS DE LAS CLAVES FORÁNEAS----------------------------------------------------------

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	
    public ModalidadIngreso getModalidadIngreso() {
		return modalidadIngreso;
	}

	public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
		this.modalidadIngreso = modalidadIngreso;
	}
	
	
	/*
	 * +++DE LA UNICA RELACION SALEN 4
	 * public User getUser() { 
	 * return user; }
	 * 
	 * public void setUser(User user) {
	 * this.user = user; }
	 */


	public User getInteresado() {
        return interesado;
    }

    public void setInteresado(User interesado) {
        this.interesado = interesado;
    }

    public User getAsesor() {
        return asesor;
    }

    public void setAsesor(User asesor) {
        this.asesor = asesor;
    }

    public User getPresidente() {
        return presidente;
    }

    public void setPresidente(User presidente) {
        this.presidente = presidente;
    }

    public User getMiembro() {
        return miembro;
    }

    public void setMiembro(User miembro) {
        this.miembro = miembro;
    }
    	
	public User getSecredocente() {
		return secredocente;
	}

	public void setSecredocente(User secredocente) {
		this.secredocente = secredocente;
	}

	

	public User getPresidenteescuela() {
		return presidenteescuela;
	}


	public void setPresidenteescuela(User presidenteescuela) {
		this.presidenteescuela = presidenteescuela;
	}


	public User getMiembroescuela() {
		return miembroescuela;
	}


	public void setMiembroescuela(User miembroescuela) {
		this.miembroescuela = miembroescuela;
	}


	public List<Documento> getDocumentos() {
	    if (documentos == null) {
	        documentos = new ArrayList<>();
	    }
	    return documentos;
	}


	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
	
	
	
	public static long getSerialversionuid() { 
		 return serialVersionUID; 
	}
	 
   
	
    
}