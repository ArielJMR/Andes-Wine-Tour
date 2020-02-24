package com.Grupo18.AndesWineTour.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "departamento")
public class Departamento {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	
	private String departamento;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
