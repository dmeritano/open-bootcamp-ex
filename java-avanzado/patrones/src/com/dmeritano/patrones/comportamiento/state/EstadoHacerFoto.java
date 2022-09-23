package com.dmeritano.patrones.comportamiento.state;

public class EstadoHacerFoto extends Estado{

    public EstadoHacerFoto(Telefono telefono){
        super(telefono);
    }

    @Override
    public String desbloquear() {
        return "desbloquear(): El telefono ya esta desbloqueado";
    }

    @Override
    public String abrirCamara() {
        return "abrirCamara(): La camara ya esta abierta";
    }

    @Override
    public String sacarFoto() {
        telefono.cambiarEstado(new EstadoBloqueado(telefono));
        return "sacarFoto(): foto sacada";
    }
}
