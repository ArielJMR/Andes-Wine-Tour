package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.RentarCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface RentarCarRepositorio extends JpaRepository<RentarCar, String> {
    @Query("select c from RentarCar c where c.nombre like %:nombre%")
    public List<RentarCar> buscarRentarCarPorNombre (@Param("nombre") String nombre);
}
