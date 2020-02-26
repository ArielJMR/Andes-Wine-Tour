package com.Grupo18.AndesWineTour.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.servicios.HotelServicio;

@Controller
@RequestMapping("/")
public class Controlador {

	@GetMapping("/")
	private String index() {
		return "hospedaje.html";
	}
}
