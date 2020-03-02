package com.Grupo18.AndesWineTour.repositorios;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.PuntoTuristico;
<<<<<<< HEAD
@Repository
public interface PuntoTuristicoRepositorio extends JpaRepository<PuntoTuristico, String> {
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
>>>>>>> a08f7ffad7cf46a02ee1ecf9b1a6d0482ecf0704

public interface PuntoTuristicoRepositorio extends JpaRepository<PuntoTuristico, String> {
    @Query("select c from PuntoTuristico c where c.nombre like %:nombre%")
    public List<PuntoTuristico> buscarPuntoTuristicoPorNombre (@Param("nombre") String nombre);
}
