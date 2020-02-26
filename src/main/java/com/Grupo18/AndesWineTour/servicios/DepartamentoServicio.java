package com.Grupo18.AndesWineTour.servicios;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServicio {
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

   public void guardarDepartamento (String nombre) throws ErrorServicio {
    validar(nombre);

    Departamento departamento = new Departamento();
    departamento.setNombre(nombre);

    departamentoRepositorio.save(departamento);

   }

   public void eliminarDepartamento (String id) throws ErrorServicio{
       if (id.isEmpty() || id== null){
           throw new ErrorServicio("no puede estar vacio el campo de id o ser nulo");
       }

       Optional<Departamento> respuesta = departamentoRepositorio.findById(id);

       if (respuesta.isPresent()){
           Departamento departamento = departamentoRepositorio.findById(id).get();

           departamentoRepositorio.delete(departamento);
       }else{
           throw new ErrorServicio("no se encontro un departamento con ese id");
       }
   }

   public void validar (String nombre) throws  ErrorServicio{
       if  (nombre.isEmpty() || nombre==null){
           throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
       }
   }
}
