package com.Grupo18.AndesWineTour.repositorios;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo18.AndesWineTour.entidades.PuntoTuristico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PuntoTuristicoRepositorio extends JpaRepository<PuntoTuristico, String> {
    @Query("select c from PuntoTuristico c where c.nombre like %:nombre%")
    public List<PuntoTuristico> buscarPuntoTuristicoPorNombre (@Param("nombre") String nombre);
}
