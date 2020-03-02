package com.Grupo18.AndesWineTour.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.Departamento;

import java.util.List;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, String>{

    @Query("Select c from Departamento c where c.nombre like %:nombre%")
public List<Departamento> buscarDepartamentoPorNombre (@Param("nombre") String nombre);
}
