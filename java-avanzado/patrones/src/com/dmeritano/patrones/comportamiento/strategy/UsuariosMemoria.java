package com.dmeritano.patrones.comportamiento.strategy;

import java.util.ArrayList;

public class UsuariosMemoria implements Usuarios{

    private ArrayList<String> usuarios = new ArrayList();

    @Override
    public void crear(String nombre){
        this.usuarios.add(nombre);
    }

    @Override
    public ArrayList<String> listar(){
        System.out.println("Devolviendo lista de usuarios desde UsuariosMemoria");
        return usuarios;
    }

}
