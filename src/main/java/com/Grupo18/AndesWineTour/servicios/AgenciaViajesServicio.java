package com.Grupo18.AndesWineTour.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo18.AndesWineTour.entidades.AgenciaViajes;
import com.Grupo18.AndesWineTour.repositorios.AgenciaViajeRepositorio;

@Service
public class AgenciaViajesServicio {
	@Autowired
	private AgenciaViajeRepositorio agenciaRepositorio;
	
	public List<AgenciaViajes> ListarAgencias(){
		List<AgenciaViajes> agencias = agenciaRepositorio.findAll();
		return agencias;
	}
}
