package com.Grupo18.AndesWineTour.servicios;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.entidades.RentarCar;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.RentarCarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class RetarCarServicio {

    @Autowired
    private RentarCarRepositorio rentarCarRepositorio;

    public void guardarRentarCar (String nombre,String descripcion, String direccion, String telefono,String correo,String link, Foto foto, Departamento departamento) throws ErrorServicio {
        validar(nombre, descripcion,direccion,telefono,correo,link,foto,departamento);

        RentarCar rentarCar = new RentarCar();
        rentarCar.setNombre(nombre);
        rentarCar.setDescripcion(descripcion);
        rentarCar.setDireccion(direccion);
        rentarCar.setTelefono(telefono);
        rentarCar.setCorreo(correo);
        rentarCar.setLink(link);
        rentarCar.getFoto().add(foto);
        rentarCar.setDepartamento(departamento);

        rentarCarRepositorio.save(rentarCar);

    }

    public void eliminarRentarCar (String id) throws ErrorServicio{
        if (id.isEmpty() || id== null){
            throw new ErrorServicio("no puede estar vacio el campo de id o ser nulo");
        }

        Optional<RentarCar> respuesta = rentarCarRepositorio.findById(id);

        if (respuesta.isPresent()){
            RentarCar rentarCar = rentarCarRepositorio.findById(id).get();

            rentarCarRepositorio.delete(rentarCar);
        }else{
            throw new ErrorServicio("no se encontro un rent a car con ese id");
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
