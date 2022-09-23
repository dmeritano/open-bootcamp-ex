package com.dmeritano.patrones.comportamiento.iterator;

public interface UsuarioIterator {

    public Usuario next();
    public boolean hasMore();
    public void reset();

}
