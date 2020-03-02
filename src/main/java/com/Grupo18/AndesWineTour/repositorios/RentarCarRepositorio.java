package com.Grupo18.AndesWineTour.repositorios;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.RentarCar;
<<<<<<< HEAD
@Repository
public interface RentarCarRepositorio extends JpaRepository<RentarCar, String> {
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
>>>>>>> a08f7ffad7cf46a02ee1ecf9b1a6d0482ecf0704

public interface RentarCarRepositorio extends JpaRepository<RentarCar, String> {
    @Query("select c from RentarCar c where c.nombre like %:nombre%")
    public List<Hotel> buscarRentarCarPorNombre (@Param("nombre") String nombre);
}
