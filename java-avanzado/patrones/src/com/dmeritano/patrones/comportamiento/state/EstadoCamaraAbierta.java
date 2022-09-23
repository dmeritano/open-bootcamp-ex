package com.dmeritano.patrones.comportamiento.state;

public class EstadoCamaraAbierta extends Estado {

    public EstadoCamaraAbierta(Telefono telefono){
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
        telefono.cambiarEstado(new EstadoHacerFoto(telefono));
        return "sacarFoto(): sacando foto...";
    }

}
