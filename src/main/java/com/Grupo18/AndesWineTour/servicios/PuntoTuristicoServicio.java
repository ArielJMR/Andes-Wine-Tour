package com.Grupo18.AndesWineTour.servicios;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.entidades.PuntoTuristico;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.PuntoTuristicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PuntoTuristicoServicio {
    @Autowired
    private PuntoTuristicoRepositorio puntoTuristicoRepositorio;

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
}
