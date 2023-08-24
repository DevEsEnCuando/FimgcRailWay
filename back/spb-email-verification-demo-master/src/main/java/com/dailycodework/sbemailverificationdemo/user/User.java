package com.dailycodework.sbemailverificationdemo.user;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.entities.Expediente;
import com.dailycodework.sbemailverificationdemo.entities.Rol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sampson Alfred
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    
    @NaturalId(mutable = true)
    @Column(name = "username", unique = true)
    private String username;
    
	private String password;
	
    private boolean isEnabled = false;
    
    @Column(name="dni",length=8)
	private String dni;
	
	@Column(name="telefono",length=10)
	private String telefono;
	
	@Column(name="gradoAcademico")
	private String gradoAcademico;
	
	
	
	//CONSTRUCTOR Y G&S POR LOMBOK------------------------------------------------------------------------
	
	
	//RELACIONES CON LAS OTRAS TABLAS--------------------------------------------------------------------- 
	@JsonIgnoreProperties("usuarios")
	@ManyToOne
	@JoinColumn(name = "escuela_id")
	private Escuela escuela;
	
	@JsonIgnoreProperties("usuarios")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginToken> loginTokens;
	
	/*
	 * @JsonIgnoreProperties("usuarios")
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "escuela_id") private Escuela escuela;
	 * 
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "rol_id") private Rol rol;
	 */
	

    //GETTERS & SETTERS DE LAS CLAVES FORÁNEAS----------------------------------------------------------
	
	
	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
    
    

}
