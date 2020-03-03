package com.Grupo18.AndesWineTour.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Grupo18.AndesWineTour.entidades.Comentarios;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.ComentariosRepositorio;

@Service
public class ComentariosServicio {
	@Autowired
	private ComentariosRepositorio comentariosRepositorio;
	
	@Transactional
	public void agregarComentario(String cuerpo) throws ErrorServicio {

		Comentarios comentarios = new Comentarios();

		comentarios.setCuerpo(cuerpo);

		comentariosRepositorio.save(comentarios);

	}
	@Transactional
	public void eliminaComentarios(String id) throws ErrorServicio {
		if (id.isEmpty() || id == null) {
			throw new ErrorServicio("No puede estar vacio el campo id o ser nulo");
		}

		Optional<Comentarios> respuesta = comentariosRepositorio.findById(id);

		if (respuesta.isPresent()) {
			Comentarios comentarios = comentariosRepositorio.findById(id).get();
			comentariosRepositorio.delete(comentarios);
		} else {
			throw new ErrorServicio("No encontramos el comentario a eliminar");
		}

	}

    @Transactional(readOnly = true)
	public List<Comentarios> listarComentarios() throws ErrorServicio{
		
		List<Comentarios>comentarios= comentariosRepositorio.findAll();
		return comentarios;
		
	}
	@Transactional
	public void modificaComentarios(String id, String cuerpo) throws ErrorServicio{
	
	if(id.isEmpty() || id == null) {
		throw new ErrorServicio("El comentario que desea modificar no existe");
	}
	Optional<Comentarios> respuesta = comentariosRepositorio.findById(id);
	
	if(respuesta.isPresent()) {
		Comentarios comentarios = new Comentarios();
		comentarios.setCuerpo(cuerpo);
		comentariosRepositorio.save(comentarios);
	} else {
		throw new ErrorServicio("No se a encontrado el comentario");
	}
	
}







}
