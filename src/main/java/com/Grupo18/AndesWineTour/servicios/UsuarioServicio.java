package com.Grupo18.AndesWineTour.servicios;

import com.Grupo18.AndesWineTour.entidades.Usuario;
import com.Grupo18.AndesWineTour.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionAttributes("usuariosession")
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarUsuarioPorMailOUsername(username);

        if (usuario != null){
            List<GrantedAuthority> permisos = new ArrayList<>();

            GrantedAuthority p1 =new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
            permisos.add(p1);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession",usuario);

            User user =new User(usuario.getUsername(),usuario.getContraseña(),permisos);
            return user;
        } else{
            throw new UsernameNotFoundException("No se ha encontrado un usuario con ese username o mail");
        }
    }
}

