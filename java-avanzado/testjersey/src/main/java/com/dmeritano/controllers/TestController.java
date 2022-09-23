package com.dmeritano.controllers;

import com.dmeritano.models.Usuario;
import com.dmeritano.services.UsuarioService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class TestController {

    private UsuarioService usuarioService;

    public TestController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;

        this.usuarioService.add(new Usuario("David", 12.3));
        this.usuarioService.add(new Usuario("Juan", 9.23));
        this.usuarioService.add(new Usuario("Jose", 0.123));
    }

    @GET
    @Path("/usuarios")
    @Produces("application/json")
    public List<Usuario> getUsuarios(){
        return usuarioService.getAll();
    }

    @GET
    @Path("/usuarios/{nombre}")
    @Produces("application/json")
    public Usuario getUsuario(@PathParam("nombre") String nombre){
        System.out.println(nombre);
        return usuarioService.get(nombre);
    }

    @POST
    @Path("/usuarios")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUsuario(Usuario usuario){
        System.out.println(usuario);
        Usuario usuarioCreado = usuarioService.add(usuario);

        return Response.created(URI.create("/usuarios/" + usuario.getNombre())).entity(usuarioCreado)
                .build();
    }

}
