package com.Grupo18.AndesWineTour.entidades;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Service
public class Administrador {
    @Id
    @GeneratedValue(generator= "uuid")
    @GenericGenerator(name="uuid", strategy= "uuid2")
    private String id;

    public Administrador() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
