package com.dmeritano.service;

import com.dmeritano.models.Coche;
import com.dmeritano.repository.CocheCrudRepositoy;
import java.util.List;

public class CocheCrudImpl implements ICocheCrud {

    CocheCrudRepositoy repository = new CocheCrudRepositoy();

    @Override
    public void save(Coche coche) {
        repository.save(coche);
        System.out.println("Guardado: " + coche);
    }

    @Override
    public List<Coche> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int idCoche) {
        repository.deleteById(idCoche);
        System.out.println("Borrado coche con ID " + idCoche);
    }
}
