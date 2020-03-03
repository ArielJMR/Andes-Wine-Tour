package com.Grupo18.AndesWineTour.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Grupo18.AndesWineTour.entidades.Puntuacion;

import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.PuntuacionRepositorio;

@Service
public class PuntuacionServicio {
	@Autowired
	private PuntuacionRepositorio puntuacionRepositorio;

	@Transactional
	public void AgregarPuntuacion(String id, Integer valor) {
		Puntuacion puntuacion = new Puntuacion();

		puntuacion.setValor(valor);

		puntuacionRepositorio.save(puntuacion);

	}

	@Transactional
	public void eliminarPuntuacion(String id) throws ErrorServicio {
		if (id.isEmpty() || id == null) {
			throw new ErrorServicio("La puntuacion que deseas eliminar no existe");
		}

		Optional<Puntuacion> respuesta = puntuacionRepositorio.findById(id);

		if (respuesta.isPresent()) {
			Puntuacion puntuacion = puntuacionRepositorio.findById(id).get();

			puntuacionRepositorio.delete(puntuacion);
		} else {
			throw new ErrorServicio("no se encontro un rent a car con ese id");
		}
	}

	@Transactional
	public void modificarPuntuacion(String id, Integer valor) throws ErrorServicio {
		validar(id);
		Optional<Puntuacion> respuesta = puntuacionRepositorio.findById(id);

		if (respuesta.isPresent()) {
			Puntuacion puntuacion = puntuacionRepositorio.findById(id).get();
			puntuacion.setId(id);
			puntuacion.setValor(valor);

			puntuacionRepositorio.save(puntuacion);

		} else {
			throw new ErrorServicio("No se ha encontrado una puntuacion con ese id");

		}
	}

	public void validar(String id) throws ErrorServicio {

		if (id.isEmpty() || id == null) {
			throw new ErrorServicio("El id no puede estar vacio o ser nulo");
		}

	}

}