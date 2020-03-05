package com.Grupo18.AndesWineTour.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Grupo18.AndesWineTour.entidades.AgenciaViajes;
@Repository
public interface AgenciaViajeRepositorio extends JpaRepository<AgenciaViajes, String>{
	
@Query(value =" select c from AgenciaViajes c where c.nombre like %:nombre%")
	public List<AgenciaViajes> buscarAgenciaPorNombre(@Param("nombre") String nombre);
}
