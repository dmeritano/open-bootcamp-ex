package com.dmeritano.solid;

public class CochesService {

    private CocheRepository repository;

    public CochesService(CocheRepository repository){
        this.repository = repository;
    }

    public void guardar(Coche coche){
        repository.save(coche);
    }

}
