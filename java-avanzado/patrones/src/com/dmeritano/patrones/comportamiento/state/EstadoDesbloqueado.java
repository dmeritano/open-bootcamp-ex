package com.dmeritano.patrones.comportamiento.state;

public class EstadoDesbloqueado extends Estado{

    public EstadoDesbloqueado(Telefono telefono){
        super(telefono);
    }

    @Override
    public String desbloquear() {
        return "desbloquear(): El telefono ya esta desbloqueado";
    }

    @Override
    public String abrirCamara() {
        telefono.cambiarEstado(new EstadoCamaraAbierta(telefono));
        return "abrirCamara(); Camara abierta, puedes hacer la foto";
    }

    @Override
    public String sacarFoto() {
        return "sacarFoto(): No se puede sacar foto sin abrir la camara";
    }
}
