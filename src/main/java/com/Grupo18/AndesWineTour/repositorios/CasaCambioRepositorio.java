package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.CasaCambio;
@Repository
public interface CasaCambioRepositorio extends JpaRepository<CasaCambio, String>{

}
