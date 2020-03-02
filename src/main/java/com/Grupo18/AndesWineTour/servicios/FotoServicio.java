package com.Grupo18.AndesWineTour.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.FotoRepositorio;

@Service
public class FotoServicio {
	@Autowired
	private FotoRepositorio fotoRepositorio;
	
	@Transactional
	public Foto guardar(MultipartFile archivo) {
		if(archivo!=null) {
			try {
				Foto foto = new Foto();
				foto.setMime(archivo.getContentType());
				foto.setContenido(archivo.getBytes());
				foto.setNombre(archivo.getName());
				return fotoRepositorio.save(foto);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return null;
	}
	@Transactional
	public void eliminar(String id) throws ErrorServicio { 
		Optional<Foto> respuesta = fotoRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Foto foto = fotoRepositorio.findById(id).get();
		} else {
			throw new ErrorServicio("No se encuentra la foto que desea eliminar");
		}
	}
}
