package com.dmeritano.patrones.comportamiento.strategy;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosFichero implements Usuarios{

    private String ficheroUsuarios = "usuarios.txt";
    private PrintStream fichero;

    public UsuariosFichero(){
        try{
            fichero = new PrintStream(ficheroUsuarios);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void crear(String nombre){
        fichero.println(nombre);
    }

    @Override
    public ArrayList<String> listar(){
        ArrayList<String> usuarios = new ArrayList();
        try {
            Scanner scanner = new Scanner(new File(ficheroUsuarios));
            while(scanner.hasNext()){
                usuarios.add(scanner.next());
            }
            scanner.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Devolviendo lista de usuarios desde UsuariosFichero");
        return usuarios;
    }


}
