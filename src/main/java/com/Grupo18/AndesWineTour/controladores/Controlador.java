package com.Grupo18.AndesWineTour.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.servicios.HotelServicio;

@Controller
public class Controlador {
	@Autowired
	private HotelServicio hotelServicio;
	
	@RequestMapping("/hospedaje")
	private String listarHoteles(Model model) {
		List<Hotel> hoteles = hotelServicio.listarHoteles();
		model.addAttribute("Hoteles", hoteles);
		return "hospedaje";
	}
}
