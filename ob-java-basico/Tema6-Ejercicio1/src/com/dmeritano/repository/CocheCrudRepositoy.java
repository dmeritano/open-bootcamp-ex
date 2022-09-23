package com.dmeritano.repository;

import com.dmeritano.models.Coche;

import java.util.ArrayList;
import java.util.List;

public class CocheCrudRepositoy {

    public static List<Coche> cochesList = new ArrayList<>();

    public void save(Coche coche){
        cochesList.add(coche);
    }

    public List<Coche> findAll(){
        return cochesList;
    }

    public void deleteById(int idCoche){
        cochesList.removeIf(c -> c.getId() == idCoche);
    }

}
