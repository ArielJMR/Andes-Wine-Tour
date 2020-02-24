package com.Grupo18.AndesWineTour.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.repositorios.FotoRepositorio;

@Service
public class FotoServicio {
	@Autowired
	private FotoRepositorio fotoRepo;
	
	public Foto guardar(MultipartFile archivo) {
		if(archivo!=null) {
			try {
				Foto foto = new Foto();
				foto.setMime(archivo.getContentType());
				foto.setContenido(archivo.getBytes());
				foto.setNombre(archivo.getName());
				return fotoRepo.save(foto);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return null;
	}
}
