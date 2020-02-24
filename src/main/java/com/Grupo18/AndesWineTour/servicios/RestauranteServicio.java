package com.Grupo18.AndesWineTour.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo18.AndesWineTour.entidades.Restaurante;
import com.Grupo18.AndesWineTour.repositorios.RestauranteRepositorio;

@Service
public class RestauranteServicio {
	
	@Autowired
	private RestauranteRepositorio restauranteRepositorio;
	
	public List<Restaurante> ListarRestaurantes(){
		List<Restaurante> restaurantes = restauranteRepositorio.findAll();
		return restaurantes;
	}

}
