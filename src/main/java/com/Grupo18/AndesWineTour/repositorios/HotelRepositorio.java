package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.Hotel;
<<<<<<< HEAD
@Repository
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

>>>>>>> a08f7ffad7cf46a02ee1ecf9b1a6d0482ecf0704
public interface HotelRepositorio extends JpaRepository<Hotel, String>{

    @Query("select c from Hotel c where c.nombre like %:nombre%")
    public List<Hotel> buscarHotelPorNombre (@Param("nombre") String nombre);
}
