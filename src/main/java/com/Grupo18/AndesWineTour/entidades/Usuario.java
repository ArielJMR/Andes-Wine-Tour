package com.Grupo18.AndesWineTour.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cod_Usuario")
	private String id;
	@Column(name = "Nombre_Usuario")
	private String nombre;
	@Column(name = "Apellido_Usuario")
	private String apellido;
	@Column(name = "Email_Usuario")
	private String email;
	@Column(name = "Contraseña_Usuario")
	private String contraseña;
	@OneToOne
	@JoinColumn(name = "Cod_Foto")
	private Foto foto;
	@Temporal(TemporalType.DATE)/*/Tipo date para no guardar las horas/*/
	private Date fecha_nacimiento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_alta;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_baja;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	
	
}
