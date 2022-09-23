package com.dmeritano.services;

import com.dmeritano.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getAll(){
        return this.usuarios;
    }

    public Usuario add(Usuario usuario){
        this.usuarios.add(usuario);
        return usuario;
    }

    public Usuario get(String nombre){
        Usuario usuario = usuarios.stream()
                .filter(u -> nombre.equalsIgnoreCase(u.getNombre()))
                .findFirst()
                .orElse(null);

        return usuario;
    }

}
