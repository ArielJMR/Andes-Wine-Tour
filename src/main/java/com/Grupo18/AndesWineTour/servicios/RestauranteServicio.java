package com.Grupo18.AndesWineTour.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo18.AndesWineTour.entidades.Restaurante;
import com.Grupo18.AndesWineTour.repositorios.RestauranteRepositorio;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Service
public class RestauranteServicio {
	
	@Autowired
	private RestauranteRepositorio restauranteRepositorio;

	public void guardarRestaurante (String nombre, String direccion, String telefono,String correo,String link, Foto foto, Departamento departamento) throws ErrorServicio {
		validar(nombre,direccion,telefono,correo,link,foto,departamento);

		Restaurante restaurante= new Restaurante();
		restaurante.setNombre(nombre);
		restaurante.setDireccion(direccion);
		restaurante.setTelefono(telefono);
		restaurante.setCorreo(correo);
		restaurante.setLink(link);
		restaurante.getFoto().add(foto);
		restaurante.setDepartamento(departamento);

		restauranteRepositorio.save(restaurante);

	}

	public void eliminarRestaurante (String id) throws ErrorServicio{
		if (id.isEmpty() || id== null){
			throw new ErrorServicio("no puede estar vacio el campo de id o ser nulo");
		}

		Optional<Restaurante> respuesta = restauranteRepositorio.findById(id);

		if (respuesta.isPresent()){
			Restaurante restaurante = restauranteRepositorio.findById(id).get();

			restauranteRepositorio.delete(restaurante);
		}else{
			throw new ErrorServicio("no se encontro un restaurante con ese id");
		}
	}

	public void validar (String nombre,String direccion,String telefono,String correo,String link,Foto foto,Departamento departamento) throws  ErrorServicio{
		if  (nombre.isEmpty() || nombre==null){
			throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
		}

		if  (direccion.isEmpty() || direccion==null){
			throw new ErrorServicio("La dirección no puede estar vacia o ser nulo");
		}

		if  (telefono.isEmpty() || telefono==null){
			throw new ErrorServicio("El teléfono no puede estar vacio o ser nulo");
		}

		if  (correo.isEmpty() || correo==null){
			throw new ErrorServicio("El correo no puede estar vacio o ser nulo");
		}

		if  (link.isEmpty() || link==null){
			throw new ErrorServicio("El link no puede estar vacio o ser nulo");
		}

		if  (foto==null){
			throw new ErrorServicio("Tiene que haber por lo menos una foto");
		}

		if  (departamento==null){
			throw new ErrorServicio("Tienen que haber un departamento por lo menos");
		}

		if  (nombre.isEmpty() || nombre==null){
			throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
		}
	}
}
