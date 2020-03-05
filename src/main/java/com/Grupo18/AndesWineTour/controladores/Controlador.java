package com.Grupo18.AndesWineTour.controladores;

import java.awt.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.servicios.HotelServicio;

@Controller

@RequestMapping("/")
public class Controlador {

	@Autowired
	private HotelServicio hotelServicio;

	@GetMapping("/")
	private String index() {
		return "index";
	}
	@GetMapping("/hoteles")
	private String hoteles(Model model) {
		List<Hotel> hoteles = hotelServicio.listarHoteles();
		model.addAttribute("hoteles", hoteles);
		return "hoteles";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
		}

	@GetMapping("/registro")
	public String registro() {
		return "registro";
		}
		//@PostMapping("/registrar")
		//public String registrar(String nombre, String contraseña, String contraseña1)



	@GetMapping("/barra de busqueda")
	public String busqueda() {
		return "busqueda";
		}

	@GetMapping("/hospedaje")
	private String hospedaje() {
		return "hospedaje";
		}

		}
