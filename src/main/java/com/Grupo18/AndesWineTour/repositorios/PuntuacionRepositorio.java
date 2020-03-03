package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.Puntuacion;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion, String>{

}
