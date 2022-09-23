package com.dmeritano.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tests/hola").permitAll()
                .antMatchers("/tests/bootstrap").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    
    // por si queremos permitir caracteres especiales en las urls
    //   Por defecto el firewall de spring los bloquea, con lo cual
    //   si queremos eso no habria que generar el siguente bean.
    @Bean
    public HttpFirewall looseHttpFirewall(){
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);
        firewall.setAllowSemicolon(true);
        firewall.setAllowUrlEncodedSlash(true);
        // ...
        // ...
        return firewall;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }	
	
}
