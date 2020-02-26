package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepositorio extends JpaRepository<Hotel, String>{

    @Query("select c from Hotel c where c.nombre like %:nombre%")
    public List<Hotel> buscarHotelPorNombre (@Param("nombre") String nombre);
}
