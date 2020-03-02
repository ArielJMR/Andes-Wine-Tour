package com.Grupo18.AndesWineTour.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Grupo18.AndesWineTour.entidades.AgenciaViajes;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.AgenciaViajeRepositorio;

@Service
public class AgenciaViajesServicio {
	@Autowired
	private AgenciaViajeRepositorio agenciaRepositorio;
	
	@Transactional(readOnly = true)
	public List<AgenciaViajes> ListarAgencias(){
		List<AgenciaViajes> agencias = agenciaRepositorio.findAll();
		return agencias;
	}
	
	@Transactional
	public void CrearAgenciaViaje(String nombre,String direccion,String descripcion,String telefono,String correo,String link,String servicio) throws ErrorServicio{
		
		validar(nombre, direccion, descripcion, telefono, correo, link, servicio);
		
		AgenciaViajes agencia = new AgenciaViajes();
		agencia.setNombre(nombre);
		agencia.setDireccion(direccion);
		agencia.setDescripcion(descripcion);
		agencia.setTelefono(telefono);
		agencia.setCorreo(correo);
		agencia.setLink(link);
		Foto foto = new Foto();
		agencia.getFoto().add(foto);
		agencia.setServicio(servicio);
		
		agenciaRepositorio.save(agencia);
	}
	
	@Transactional
	public void ModificarAgenciaViaje(String id,String nombre,String direccion,String descripcion,String telefono,String correo,String link,String servicio) {
		
		AgenciaViajes agencia = agenciaRepositorio.findById(id).get();
		
		agencia.setNombre(nombre);
		agencia.setDireccion(direccion);
		agencia.setDescripcion(descripcion);
		agencia.setTelefono(telefono);
		agencia.setCorreo(correo);
		agencia.setLink(link);
		agencia.setServicio(servicio);
		
		agenciaRepositorio.save(agencia);

	}
	@Transactional
	public void eliminarDepartamento (String id) throws ErrorServicio {
		if(id.isEmpty()||id==null) {
			throw new ErrorServicio("No puede estar vacio el campo id o ser nulo");
		}
		Optional<AgenciaViajes> respuesta = agenciaRepositorio.findById(id);
		
		if(respuesta.isPresent()) {
			AgenciaViajes agenciaViaje = agenciaRepositorio.findById(id).get();
			agenciaRepositorio.delete(agenciaViaje);
		} else {
			throw new ErrorServicio("no se encontro el departamento que desea eliminar");
		}
	}
	public void validar(String nombre,String direccion,String descripcion,String telefono,String correo,String link,String servicio) throws ErrorServicio {
		if(nombre==null||nombre.isEmpty()) {
			throw new ErrorServicio("El nombre no puede estar vacio");
		}
		if(direccion == null || direccion.isEmpty()) {
			throw new ErrorServicio("La direccion no puede estar vacia");
		}
		if(descripcion==null||descripcion.isEmpty()) {
			throw new ErrorServicio("La descripcion no puede estar vacia");
		}
		if(telefono==null||telefono.isEmpty()) {
			throw new ErrorServicio("El telefono no puede estar vacio");
		}
		if(correo==null||correo.isEmpty()) {
			throw new ErrorServicio("El correo no puede estar vacio");
		}
		if(link==null||link.isEmpty()) {
			throw new ErrorServicio("El link no puede estar vacio");
		}
		if(servicio==null||servicio.isEmpty()) {
			throw new ErrorServicio("El servicio no puede estar vacio");
		}
	}
}
