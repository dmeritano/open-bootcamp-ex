package com.dmeritano.patrones.comportamiento.iterator;

public class Main {

    public static void main(String[] args) {

        //Patron Iterator
        //  Permite recorrer listas sin saber como estar guardada la información de forma subyacente

        Usuarios usuarios = new Usuarios();
        usuarios.crear(new Usuario("Juan Lopez",31 ));
        usuarios.crear(new Usuario("Miguel Perez",28 ));
        usuarios.crear(new Usuario("Minguito Tangalanga",40 ));
        usuarios.crear(new Usuario("Johnny Tolengo",62 ));

        while(usuarios.hasMore()){
            Usuario usuario = usuarios.next();
            System.out.println(usuario);
        }
        /*
            Usuario{nombre='Juan Lopez', edad=31}
            Usuario{nombre='Miguel Perez', edad=28}
            Usuario{nombre='Minguito Tangalanga', edad=40}
            Usuario{nombre='Johnny Tolengo', edad=62}
         */

        usuarios.crear(new Usuario("Marilina Ross",70 ));
        Usuario usuario = usuarios.next();
        System.out.println(usuario);
        /*
            Usuario{nombre='Juan Lopez', edad=31}
            Usuario{nombre='Miguel Perez', edad=28}
            Usuario{nombre='Minguito Tangalanga', edad=40}
            Usuario{nombre='Johnny Tolengo', edad=62}
            Usuario{nombre='Marilina Ross', edad=70}
         */

        while(usuarios.hasMore()){
            usuario = usuarios.next();
            System.out.println(usuario);
        }
        //No imprime nada

        usuarios.reset();
        while(usuarios.hasMore()){
            usuario = usuarios.next();
            System.out.println(usuario);
        }
        /*
            Usuario{nombre='Juan Lopez', edad=31}
            Usuario{nombre='Miguel Perez', edad=28}
            Usuario{nombre='Minguito Tangalanga', edad=40}
            Usuario{nombre='Johnny Tolengo', edad=62}
            Usuario{nombre='Marilina Ross', edad=70}
         */

    }

}
