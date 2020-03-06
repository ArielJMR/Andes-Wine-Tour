package com.Grupo18.AndesWineTour.repositorios;

import com.Grupo18.AndesWineTour.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepositorio extends JpaRepository<Usuario,String> {

    @Query("select c from Usuario c where c.email=:user or c.username=:user")
    public Usuario  buscarUsuarioPorMailOUsername (@Param("user") String user);
}
