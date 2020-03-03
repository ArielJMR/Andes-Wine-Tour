package com.Grupo18.AndesWineTour.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "comentarios")
public class Comentarios {

@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name="uuid" ,strategy = "uuid2")
private String id;
private String cuerpo;
@OneToOne
private Puntuacion puntuacion;

public Puntuacion getPuntuacion() {
	return puntuacion;
}
public void setPuntuacion(Puntuacion puntuacion) {
	this.puntuacion = puntuacion;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCuerpo() {
	return cuerpo;
}
public void setCuerpo(String cuerpo) {
	this.cuerpo = cuerpo;
}



}
