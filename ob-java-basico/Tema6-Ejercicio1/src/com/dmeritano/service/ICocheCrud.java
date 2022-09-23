package com.dmeritano.service;

import com.dmeritano.models.Coche;

import java.util.List;

public interface ICocheCrud {

    public void save(Coche coche);
    public List<Coche> findAll();
    public void delete(int idCoche);

}
