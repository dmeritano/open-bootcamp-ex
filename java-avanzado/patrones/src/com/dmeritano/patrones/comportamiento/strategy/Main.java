package com.dmeritano.patrones.comportamiento.strategy;

import java.util.ArrayList;

public class Main {

    /* Patron Strategy
        Implementar funciones similiares (al menos en cuanto al nombre) y que por debajo
        realicen el proceso de forma diferente.

       Por ejemplo pagar()  .... podria ser la funcion a llamar y por debajo la forma de pagar
       podria ser totalmente diferente si pagamos con visa o con paypal, por ejemplo.
    */

    public static void main(String[] args) {

        int tipoRepositorio = 0;
        Usuarios usuarios;

        if (tipoRepositorio == 0){
            usuarios = new UsuariosMemoria();
        }else{
            usuarios = new UsuariosFichero();
        }

        crear(usuarios, "Jose");
        crear(usuarios, "Carlos");
        crear(usuarios, "Miguel");

        for (String usuario : listar(usuarios)){
            System.out.println(usuario);
        }

    }

    /*  Envolotorio - Recibe como parametro la interfaz que define el repositorio */
    private static void crear(Usuarios usuarios, String nombre){
        usuarios.crear(nombre);
    }
    private static ArrayList<String> listar(Usuarios usuarios){
        return usuarios.listar();
    }


}
