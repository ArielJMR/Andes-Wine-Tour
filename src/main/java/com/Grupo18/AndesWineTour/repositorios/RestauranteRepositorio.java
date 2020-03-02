package com.Grupo18.AndesWineTour.repositorios;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.Restaurante;

import java.util.List;

@Repository
public interface RestauranteRepositorio extends JpaRepository<Restaurante, String> {
    @Query("select c from Restaurante c where c.nombre like %:nombre%")
    public List<Restaurante> buscarRestaurantePorNombre (@Param("nombre") String nombre);
}
