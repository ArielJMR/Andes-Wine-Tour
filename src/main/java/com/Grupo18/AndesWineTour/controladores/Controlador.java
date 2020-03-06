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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.servicios.HotelServicio;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	@GetMapping("/logincheck")
	private String logincheck() {
		return "logincheck";
	}

	@GetMapping("/hoteles")
	private String hoteles(Model model) {
		List<Hotel> hoteles = hotelServicio.listarHoteles();
		model.addAttribute("hoteles", hoteles);
		return "hoteles";
	}

	@GetMapping("/login")
	public String login(@RequestParam(required = false) String error, @RequestParam (required = false)String logout, ModelMap model) {
		if (error!=null){
			model.put("error","Usuario o clave incorrectos.");
		}
if (logout != null){
	model.put("logout", "Ha salido correctamente");
}
		return "login";
		}

	@GetMapping("/registro")
	public String registro() {
		return "registro";
		}

		@PostMapping("/registro")
		public String registro(ModelMap modelo, MultipartFile foto, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String username, @RequestParam String contraseña, @RequestParam String contraseña1, @RequestParam String email){
		try {
			usuarioServicio.registrar(nombre,apellido, username, contraseña, contraseña1, email, foto);
		}catch (ErrorServicio e){
				modelo.put("error", e.getMessage());
				modelo.put("nombre", nombre);
				modelo.put("apellido",apellido);
				modelo.put("username",username);
				modelo.put("contraseña", contraseña);
				modelo.put("contraseña1", contraseña1);
				modelo.put("email",email);
			return "registro";
		}


			return "bienvenida";
		}



	@GetMapping("/sheraton")
	public String sheraton() {
		return "sheraton";
		}

	@GetMapping("/inter")
	public String inter() {
		return "inter";
	}
	@GetMapping("/bienvenida")
	public String bienvenida() {
		return "bienvenida";
	}

	@GetMapping("/hyatt")
	private String hyatt() {
		return "hyatt";
		}

		}
