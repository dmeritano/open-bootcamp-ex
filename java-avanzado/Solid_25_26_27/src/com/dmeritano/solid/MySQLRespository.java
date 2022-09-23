package com.dmeritano.solid;

public class MySQLRespository implements CocheRepository{


    @Override
    public void save(Coche coche) {
        System.out.println("\nGuardando coche:");
        System.out.println(coche);
        System.out.println(" en base de datos: " + this.getClass().getSimpleName());
    }
}
