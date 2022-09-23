package com.dmeritano;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setEdad(36);
        persona.setNombre("David Meritano");
        persona.setTelefono("5461-54567-01");

        String data = String.format("%s - %s - %s",persona.getNombre(), persona.getEdad(), persona.getTelefono());
        System.out.println(data);

    }
}


class Persona{
    private int edad;
    private String nombre;
    private String telefono;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}