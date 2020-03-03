package com.Grupo18.AndesWineTour.servicios;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.entidades.PuntoTuristico;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.PuntoTuristicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class PuntoTuristicoServicio {
    @Autowired
    private PuntoTuristicoRepositorio puntoTuristicoRepositorio;

    @Transactional
    public void guardarPuntoTuristico(String nombre, String descripcion, String direccion, Foto foto, Departamento departamento) throws ErrorServicio {
        validar(nombre, descripcion, direccion, foto, departamento);

        PuntoTuristico puntoTuristico = new PuntoTuristico();
        puntoTuristico.setNombre(nombre);
        puntoTuristico.setDescripcion(descripcion);
        puntoTuristico.setDireccion(direccion);
        puntoTuristico.getFoto().add(foto);
        puntoTuristico.setDepartamento(departamento);

        puntoTuristicoRepositorio.save(puntoTuristico);

    }

    @Transactional
    public void eliminarPuntoTuristico(String id) throws ErrorServicio {
        if (id.isEmpty() || id == null) {
            throw new ErrorServicio("no puede estar vacio el campo de id o ser nulo");
        }

        Optional<PuntoTuristico> respuesta = puntoTuristicoRepositorio.findById(id);

        if (respuesta.isPresent()) {
            PuntoTuristico puntoTuristico = puntoTuristicoRepositorio.findById(id).get();

            puntoTuristicoRepositorio.delete(puntoTuristico);
        } else {
            throw new ErrorServicio("no se encontro un punto turístico con ese id");
        }
    }

    @Transactional
    public List<PuntoTuristico> buscarTodosPuntoTuristico() throws ErrorServicio{
        List <PuntoTuristico> respuesta= new ArrayList<PuntoTuristico>();
        respuesta =puntoTuristicoRepositorio.findAll();
        if(respuesta.isEmpty()){
            throw new ErrorServicio("No se han encontrado Puntos Turisticos");
        }
        return respuesta;
    }

    @Transactional
    public List<PuntoTuristico> buscarPuntoTuristico(String nombre) throws ErrorServicio{
        List <PuntoTuristico> respuesta= new ArrayList<PuntoTuristico>();
        respuesta = puntoTuristicoRepositorio.buscarPuntoTuristicoPorNombre(nombre);
        if(respuesta.isEmpty()){
            throw new ErrorServicio("No se han encontrado Puntos Turisticos con ese nombre");
        }
        return respuesta;
    }

    @Transactional
    public void agregarFotos(List<Foto> fotos, String id) throws ErrorServicio{

        if (fotos.isEmpty()){
            throw  new ErrorServicio("tiene que pasar por lo menos una foto");
        }

        if (id.isEmpty() || id ==null){
            throw new ErrorServicio("el id no puede ser nulo o estar vacio");
        }

        Optional<PuntoTuristico>respuesta = puntoTuristicoRepositorio.findById(id);
        if (respuesta.isPresent()){
            PuntoTuristico puntoTuristico =respuesta.get();
            puntoTuristico.getFoto().addAll(fotos);
            puntoTuristicoRepositorio.save(puntoTuristico);
        }
    }

    @Transactional
    public void modificarPuntoTuristico(String id,String nombre, String descripcion, String direccion, Departamento departamento) throws ErrorServicio{
        validar(nombre, descripcion, direccion, departamento);
        if (id==null || id.isEmpty()){
            throw  new ErrorServicio("El id no puede estar vacio o nulo");
        }

        Optional <PuntoTuristico> respuesta= puntoTuristicoRepositorio.findById(id);
        if (respuesta.isPresent()){
            PuntoTuristico puntoTuristico= puntoTuristicoRepositorio.findById(id).get();

            puntoTuristico.setNombre(nombre);
            puntoTuristico.setDescripcion(descripcion);
            puntoTuristico.setDireccion(direccion);
            puntoTuristico.setDepartamento(departamento);

            puntoTuristicoRepositorio.save(puntoTuristico);
        }else{
            throw new ErrorServicio ("No se ha encontrado un Punto Turístico con ese id");
        }



    }

    public void validar(String nombre, String descripcion, String direccion, Foto foto, Departamento departamento) throws ErrorServicio {
        if (nombre.isEmpty() || nombre == null) {
            throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
        }

        if (direccion.isEmpty() || direccion == null) {
            throw new ErrorServicio("La dirección no puede estar vacia o ser nulo");
        }


        if (foto == null) {
            throw new ErrorServicio("Tiene que haber por lo menos una foto");
        }

        if (departamento == null) {
            throw new ErrorServicio("Tienen que haber un departamento por lo menos");
        }

        if (nombre.isEmpty() || nombre == null) {
            throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
        }
    }

    public void validar(String nombre, String descripcion, String direccion, Departamento departamento) throws ErrorServicio {
        if (nombre.isEmpty() || nombre == null) {
            throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
        }

        if (direccion.isEmpty() || direccion == null) {
            throw new ErrorServicio("La dirección no puede estar vacia o ser nulo");
        }


        if (departamento == null) {
            throw new ErrorServicio("Tienen que haber un departamento por lo menos");
        }

        if (nombre.isEmpty() || nombre == null) {
            throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
        }
    }
}

