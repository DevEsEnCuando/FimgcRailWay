/*
 * package com.dailycodework.sbemailverificationdemo.entities;
 * 
 * 
 * 
 * import java.io.Serializable; import java.util.List;
 * 
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.JoinColumn; import jakarta.persistence.ManyToOne; import
 * jakarta.persistence.OneToMany; import jakarta.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="usuario") public class Usuario implements Serializable {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 * 
 * @Column(name="username",length=150) private String username;
 * 
 * @Column(name="password",length=256) private String password;
 * 
 * @Column(name="nombres",length=100) private String nombres;
 * 
 * @Column(name="apellidos",length=100) private String apellidos;
 * 
 * 
 * @Column(name="nombreCompleto",length=200) private String nombreCompleto;
 * 
 * 
 * 
 * @Column(name="domicilio",length=200) private String domicilio;
 * 
 * 
 * @Column(name="dni",length=8) private String dni;
 * 
 * @Column(name="telefono",length=10) private String telefono;
 * 
 * @Column(name="correoElectronico",length=100) private String
 * correoElectronico;
 * 
 * @Column(name = "estado", length=100) private String estado;
 * 
 * 
 * @JsonIgnoreProperties("usuarios")
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "escuela_id") private Escuela escuela;
 * 
 * 
 * @JsonIgnoreProperties("usuarios")
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "rol_id") private Rol rol;
 * 
 * 
 * 
 * @JsonIgnoreProperties("usuario")
 * 
 * @OneToMany(mappedBy = "usuario") private List<Expediente> expedientes;
 * 
 * 
 * 
 * public Usuario() {
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * 
 * 
 * 
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * 
 * 
 * 
 * 
 * public String getNombres() { return nombres; }
 * 
 * public void setNombres(String nombres) { this.nombres = nombres; }
 * 
 * 
 * 
 * 
 * 
 * public String getApellidos() { return apellidos; }
 * 
 * public void setApellidos(String apellidos) { this.apellidos = apellidos; }
 * 
 * 
 * 
 * 
 * 
 * public String getDni() { return dni; }
 * 
 * public void setDni(String dni) { this.dni = dni; }
 * 
 * 
 * 
 * 
 * 
 * public String getTelefono() { return telefono; }
 * 
 * public void setTelefono(String telefono) { this.telefono = telefono; }
 * 
 * 
 * 
 * 
 * 
 * public String getCorreoElectronico() { return correoElectronico; }
 * 
 * public void setCorreoElectronico(String correoElectronico) {
 * this.correoElectronico = correoElectronico; }
 * 
 * 
 * 
 * 
 * 
 * public String getEstado() { return estado; }
 * 
 * public void setEstado(String estado) { this.estado = estado; }
 * 
 * 
 * 
 * 
 * 
 * public Escuela getEscuela() { return escuela; }
 * 
 * public void setEscuela(Escuela escuela) { this.escuela = escuela; }
 * 
 * 
 * 
 * 
 * public Rol getRol() { return rol; }
 * 
 * public void setRol(Rol rol) { this.rol = rol; }
 * 
 * 
 * 
 * 
 * 
 * public List<Expediente> getExpedientes() { return expedientes; }
 * 
 * public void setExpedientes(List<Expediente> expedientes) { this.expedientes =
 * expedientes; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public static long getSerialversionuid() { return serialVersionUID; }
 * 
 * 
 * 
 * 
 * 
 * public String getNombreCompleto() { return nombreCompleto; }
 * 
 * public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto =
 * nombreCompleto; }
 * 
 * 
 * 
 * public String getDomicilio() { return domicilio; }
 * 
 * public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
 * 
 * 
 * 
 * 
 * 
 * }
 */