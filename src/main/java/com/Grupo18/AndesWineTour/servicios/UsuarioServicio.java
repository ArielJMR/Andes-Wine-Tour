package com.Grupo18.AndesWineTour.servicios;

import com.Grupo18.AndesWineTour.entidades.Departamento;
import com.Grupo18.AndesWineTour.entidades.Foto;
import com.Grupo18.AndesWineTour.entidades.Restaurante;
import com.Grupo18.AndesWineTour.entidades.Usuario;
import com.Grupo18.AndesWineTour.error.ErrorServicio;
import com.Grupo18.AndesWineTour.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@SessionAttributes("usuariosession")
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    FotoServicio fotoServicio;

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
    @Transactional
    public void registrar (String nombre, String apellido, String username, String contraseña,String contraseña1, String email, MultipartFile foto) throws ErrorServicio{
    validar(nombre, apellido, username, contraseña, contraseña1, email);

            Usuario usuario= new Usuario();
        Date date = new Date();
            usuario.setUsername(username);
            String encriptada = new BCryptPasswordEncoder().encode(contraseña);
            usuario.setContraseña(encriptada);
            usuario.setApellido(apellido);
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setFecha_alta(date);

            Foto foto1 =fotoServicio.guardar(foto);
            usuario.setFoto(foto1);


            usuarioRepositorio.save(usuario);

        }

        public void validar (String nombre, String apellido, String username, String contraseña, String contraseña1, String email) throws ErrorServicio {
            if (nombre.isEmpty() || nombre == null) {
                throw new ErrorServicio("El nombre no puede estar vacio o ser nulo");
            }

            if (apellido.isEmpty() || apellido == null) {
                throw new ErrorServicio("El apellido no puede estar vacio o ser nulo");
            }

            if (username.isEmpty() || username == null) {
                throw new ErrorServicio("El username no puede estar vacio o ser nulo");
            } else {
                Usuario respuesta = usuarioRepositorio.buscarUsuarioPorMailOUsername(username);
                if (respuesta != null) {
                    throw new ErrorServicio("ya hay un usuario con ese username, por favor cambie el username ");
                }

                if (email.isEmpty() || email == null) {
                    throw new ErrorServicio("El correo no puede estar vacio o ser nulo");
                } else {
                    Usuario respuesta1 = usuarioRepositorio.buscarUsuarioPorMailOUsername(email);
                    if (respuesta != null) {
                        throw new ErrorServicio("ya hay un usuario con ese email, por favor cambie el email ");

                    }

                    if (contraseña.isEmpty() || contraseña == null) {
                        throw new ErrorServicio("La contraseña no puede estar vacia o ser nula");
                    }

                    if (!contraseña.equals(contraseña1)) {
                        throw new ErrorServicio("Las contraseñas tienen que coicidir, por favor vuelve a ingresar la contraseña");
                    }

                }

            }
        }}


