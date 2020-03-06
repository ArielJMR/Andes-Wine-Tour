package com.Grupo18.AndesWineTour.controladores;

import java.awt.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.servicios.HotelServicio;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/")
public class Controlador {

	@Autowired
	private HotelServicio hotelServicio;

	@Autowired
	private UsuarioServicio usuarioServicio;

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

		@PostMapping("/registro")
		public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String username, @RequestParam String contraseña,@RequestParam String contraseña1, @RequestParam String email){
		try {
			usuarioServicio.registrar(nombre,apellido, username, contraseña, contraseña1, email);

		}catch (ErrorServicio e){
			Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE,null,e);
			return "registro";
		}


			return "index";
		}



	@GetMapping("/barra de busqueda")
	public String busqueda() {
		return "busqueda";
		}

	@GetMapping("/hyatt")
	private String hyatt() {
		return "hyatt";
		}

		}
