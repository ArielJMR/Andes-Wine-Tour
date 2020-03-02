package com.Grupo18.AndesWineTour.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Controlador {

	@GetMapping("/")
	private String index() {
		return "hospedaje.html";
	}
}
