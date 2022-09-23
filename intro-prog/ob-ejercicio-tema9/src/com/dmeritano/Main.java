package com.dmeritano;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setEdad(25);
        cliente.setNombre("Carlos");
        cliente.setTelefono(("13234-234"));
        cliente.setCredito(2423.23);

        String data = String.format("%s - %s - %s - %s",
                cliente.getNombre(),
                cliente.getEdad(),
                cliente.getTelefono(),
                cliente.getCredito());
        System.out.println(data);

        Trabajador trabajador = new Trabajador();
        trabajador.setEdad(38);
        trabajador.setNombre("Mickel");
        trabajador.setTelefono(("54608-100"));
        trabajador.setSalario(4300.28);

        data = String.format("%s - %s - %s - %s",
                trabajador.getNombre(),
                trabajador.getEdad(),
                trabajador.getTelefono(),
                trabajador.getSalario());
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

class Cliente extends Persona{
    private double credito;

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}

class Trabajador extends Persona{
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
