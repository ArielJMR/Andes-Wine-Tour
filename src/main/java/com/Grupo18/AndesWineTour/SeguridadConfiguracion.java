package com.Grupo18.AndesWineTour;

import com.Grupo18.AndesWineTour.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {



    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        UsuarioServicio usuarioServicio= new UsuarioServicio();
        auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        System.out.println("===============");
        http.headers().frameOptions().sameOrigin().and().authorizeRequests()
                .antMatchers("/css/*","/js/","/login","/registro")
                .permitAll()
                .and().formLogin()
                .loginPage("/logearse")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("nombre")
                .passwordParameter("Contraseña")
                .defaultSuccessUrl("/exito")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll().and().csrf().disable();
    }
}
