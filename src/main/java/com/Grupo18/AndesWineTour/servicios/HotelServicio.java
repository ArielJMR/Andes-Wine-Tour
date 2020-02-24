package com.Grupo18.AndesWineTour.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.repositorios.HotelRepositorio;

@Service
public class HotelServicio {
	@Autowired
	private HotelRepositorio hotelRepositorio;
	
	public List<Hotel> listarHoteles(){
		List<Hotel> hoteles = hotelRepositorio.findAll();
		return hoteles;
	}
}
