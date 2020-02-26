package com.Grupo18.AndesWineTour.repositorios;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo18.AndesWineTour.entidades.RentarCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentarCarRepositorio extends JpaRepository<RentarCar, String> {
    @Query("select c from RentarCar c where c.nombre like %:nombre%")
    public List<Hotel> buscarRentarCarPorNombre (@Param("nombre") String nombre);
}
