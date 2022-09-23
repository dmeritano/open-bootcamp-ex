package com.dmeritano.patrones.comportamiento.state;

public class Telefono {

    private Estado estado;

    public Telefono(){
        estado = new EstadoBloqueado(this);
    }

    public void cambiarEstado(Estado estado){
        System.out.println("Estado inicial: " + this.estado.getClass().getName());
        this.estado = estado;
        System.out.println("Estado Final: " + this.estado.getClass().getName());
    }

    public Estado getEstado(){
        return estado;
    }

}
