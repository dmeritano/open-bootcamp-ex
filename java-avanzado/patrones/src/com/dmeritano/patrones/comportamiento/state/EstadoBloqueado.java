package com.dmeritano.patrones.comportamiento.state;

public class EstadoBloqueado extends Estado{

    public EstadoBloqueado(Telefono telefono){
        super(telefono);
    }

    @Override
    public String desbloquear() {
        telefono.cambiarEstado(new EstadoDesbloqueado(telefono));
        return "desbloquear(): Movil desbloqueado";
    }

    @Override
    public String abrirCamara() {
        return "abrirCamara(): La camara esta no esta accesible. Desbloquea el telefono antes de querer ususarla";
    }

    @Override
    public String sacarFoto() {
        return "sacarFoto(): La camara esta no esta accesible. Desbloquea el telefono antes de querer ususarla";
    }
}
