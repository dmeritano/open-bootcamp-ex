package com.dmeritano;

import com.dmeritano.service.ICocheCrud;
import com.dmeritano.models.Coche;
import com.dmeritano.service.CocheCrudImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ICocheCrud cocheCrud = new CocheCrudImpl();

        //Agregar coches
        System.out.println("\nAgregando coches\n");
        cocheCrud.save(new Coche(1, "Renault", "Clio", 2, 4));
        cocheCrud.save(new Coche(2, "Ford", "Taurus", 5, 4));
        cocheCrud.save(new Coche(3, "Nissan", "Frontier LE", 4, 4));

        //Obtener lista de coches
        System.out.println("\nLista de coches:\n");
        List<Coche> coches = cocheCrud.findAll();
        for (Coche coche : coches){
            System.out.println(" --> " + coche);
        }

        System.out.println("\n");
        //Borrar el primer coche de la lista de coches;
        cocheCrud.delete(coches.get(0).getId());

    }
}

/* Sample output:

    Agregando coches

    Guardado: Coche{id=1, marca='Renault', modelo='Clio', numPuertas=2, numRuedas=4}
    Guardado: Coche{id=2, marca='Ford', modelo='Taurus', numPuertas=5, numRuedas=4}
    Guardado: Coche{id=3, marca='Nissan', modelo='Frontier LE', numPuertas=4, numRuedas=4}

    Lista de coches:

     --> Coche{id=1, marca='Renault', modelo='Clio', numPuertas=2, numRuedas=4}
     --> Coche{id=2, marca='Ford', modelo='Taurus', numPuertas=5, numRuedas=4}
     --> Coche{id=3, marca='Nissan', modelo='Frontier LE', numPuertas=4, numRuedas=4}


    Borrado coche con ID 1

 */