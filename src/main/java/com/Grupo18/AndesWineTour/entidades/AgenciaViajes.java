package com.Grupo18.AndesWineTour.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="agenciaviajes")
public class AgenciaViajes {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	
	private String nombre;
	private String direccion;
	private String descripcion;
	private String telefono;
	private String correo;
	private String link;
	private String servicio;
	
	@OneToMany
	private List<Foto> foto = new ArrayList<>();
	
	@OneToOne
	private Departamento departamento;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
