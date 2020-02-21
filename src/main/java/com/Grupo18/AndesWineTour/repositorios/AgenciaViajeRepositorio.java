package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.AgenciaViajes;
@Repository
public interface AgenciaViajeRepositorio extends JpaRepository<AgenciaViajes, String>{

}
