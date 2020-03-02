package com.Grupo18.AndesWineTour.servicios;


import java.util.Optional;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo18.AndesWineTour.entidades.Hotel;
import com.Grupo18.AndesWineTour.repositorios.HotelRepositorio;


@Service
public class HotelServicio {
	@Autowired
	private HotelRepositorio hotelRepositorio;

	public void guardarHotel (String nombre,String descripcion, String direccion, String telefono,String correo,String link, Foto foto, Departamento departamento) throws ErrorServicio {
		validar(nombre, descripcion,direccion,telefono,correo,link,foto,departamento);

		Hotel hotel = new Hotel();
		hotel.setNombre(nombre);
		hotel.setDescripcion(descripcion);
		hotel.setDireccion(direccion);
		hotel.setTelefono(telefono);
		hotel.setCorreo(correo);
		hotel.setLink(link);
		hotel.getFoto().add(foto);
		hotel.setDepartamento(departamento);

		hotelRepositorio.save(hotel);

	}

	public void eliminarHotel (String id) throws ErrorServicio{
		if (id.isEmpty() || id== null){
			throw new ErrorServicio("no puede estar vacio el campo de id o ser nulo");
		}

		Optional<Hotel> respuesta = hotelRepositorio.findById(id);

		if (respuesta.isPresent()){
			Hotel hotel = hotelRepositorio.findById(id).get();

			hotelRepositorio.delete(hotel);
		}else{
			throw new ErrorServicio("no se encontro un hotel con ese id");
		}
	}

	public void validar (String nombre, String descripcion,String direccion,String telefono,String correo,String link,Foto foto,Departamento departamento) throws  ErrorServicio{
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
