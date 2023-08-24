package com.dailycodework.sbemailverificationdemo.entities;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "PlanEstudios")
public class PlanEstudios implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombrePlan;
    
    @Column(name="tipoC1")
    private String tipoC1;
    
    @Column(name="valorC1")
    private Integer valorC1;
    
    @Column(name="tipoC2")
    private String tipoC2;
    
    @Column(name="valorC2")
    private Integer valorC2;
    
    @Column(name="tipoC3")
    private String tipoC3;
    
    @Column(name="valorC3")
    private Integer valorC3;
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombrePlan() {
		return nombrePlan;
	}


	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}


	public Integer getValorC1() {
		return valorC1;
	}


	public void setValorC1(Integer valorC1) {
		this.valorC1 = valorC1;
	}


	public String getTipoC2() {
		return tipoC2;
	}


	public void setTipoC2(String tipoC2) {
		this.tipoC2 = tipoC2;
	}


	public Integer getValorC2() {
		return valorC2;
	}


	public void setValorC2(Integer valorC2) {
		this.valorC2 = valorC2;
	}


	public String getTipoC3() {
		return tipoC3;
	}


	public void setTipoC3(String tipoC3) {
		this.tipoC3 = tipoC3;
	}


	public Integer getValorC3() {
		return valorC3;
	}


	public void setValorC3(Integer valorC3) {
		this.valorC3 = valorC3;
	}


	public String getTipoC4() {
		return tipoC4;
	}


	public void setTipoC4(String tipoC4) {
		this.tipoC4 = tipoC4;
	}


	public Integer getValorC4() {
		return valorC4;
	}


	public void setValorC4(Integer valorC4) {
		this.valorC4 = valorC4;
	}


	public String getTipoC5() {
		return tipoC5;
	}


	public void setTipoC5(String tipoC5) {
		this.tipoC5 = tipoC5;
	}


	public Integer getValorC5() {
		return valorC5;
	}


	public void setValorC5(Integer valorC5) {
		this.valorC5 = valorC5;
	}


	public String getTipoC6() {
		return tipoC6;
	}


	public void setTipoC6(String tipoC6) {
		this.tipoC6 = tipoC6;
	}


	public Integer getValorC6() {
		return valorC6;
	}


	public void setValorC6(Integer valorC6) {
		this.valorC6 = valorC6;
	}


	public String getTipoC7() {
		return tipoC7;
	}


	public void setTipoC7(String tipoC7) {
		this.tipoC7 = tipoC7;
	}


	public Integer getValorC7() {
		return valorC7;
	}


	public void setValorC7(Integer valorC7) {
		this.valorC7 = valorC7;
	}


	public String getTipoC8() {
		return tipoC8;
	}


	public void setTipoC8(String tipoC8) {
		this.tipoC8 = tipoC8;
	}


	public String getAnioPlan() {
		return anioPlan;
	}


	public void setAnioPlan(String anioPlan) {
		this.anioPlan = anioPlan;
	}


	public Escuela getEscuela() {
		return escuela;
	}


	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}


	public void setTipoC1(String tipoC1) {
		this.tipoC1 = tipoC1;
	}



	@Column(name="tipoC4")
    private String tipoC4;
    
    @Column(name="valorC4")
    private Integer valorC4;
    
    @Column(name="tipoC5")
    private String tipoC5;
    
    @Column(name="valorC5")
    private Integer valorC5;
    
    @Column(name="tipoC6")
    private String tipoC6;
    
    @Column(name="valorC6")
    private Integer valorC6;
    
    @Column(name="tipoC7")
    private String tipoC7;
    
    @Column(name="valorC7")
    private Integer valorC7;
    
    @Column(name="tipoC8")
    private String tipoC8;
    
    public Integer getValorC8() {
		return valorC8;
	}


	public void setValorC8(Integer valorC8) {
		this.valorC8 = valorC8;
	}



	@Column(name="valorC8")
    private Integer valorC8;
    
    public String getTipoC1() {
		return tipoC1;
	}

	

	@Column(name = "anio", nullable = false)
    private String anioPlan;


    @ManyToOne
    @JoinColumn(name="escuela")
    private Escuela escuela;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

    
}