package com.dmeritano.patrones.comportamiento.observer;

import java.util.ArrayList;

public class Emisora {

    private ArrayList<Receptor> receptores = new ArrayList();

    public void agregarReceptor(Receptor receptor){
        this.receptores.add(receptor);
    }

    public void emite(){
        receptores.forEach(receptor -> receptor.recibe());
    }

}
