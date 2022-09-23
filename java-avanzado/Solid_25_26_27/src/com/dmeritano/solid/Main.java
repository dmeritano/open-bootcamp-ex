package com.dmeritano.solid;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nInicia el programa");
        System.out.println("------------------");

        //Implementacion de segregacion de interfaces
        //  ICoche
        //  ICocheElectrico - cargarBateria()
        //  ICocheGasolina -> cargarCombustible()

        //Implementacion de principio de inversion de dependencias
        //   Interface CochesRepository
        //     implementacion 1 --> MySQLRepository
        //     implementacion 2 --> OracleRepository

        //Guardamos coche (interface ICocheElectrico) en BD MySQL
        CocheElectrico cocheElectrico = new CocheElectrico("CHEVROLET", "Captiva SL", 5);
        cocheElectrico.cargarBateria();
        cocheElectrico.acelerar();
        CochesService service = new CochesService(new MySQLRespository());
        service.guardar(cocheElectrico);

        //Guardamos coche (interface ICocheGasolina) en BD Oracle
        CocheGasolina cocheGasolina = new CocheGasolina("PEUGEOT", "3008 SX", 4);
        cocheGasolina.cargarCombustible();
        cocheGasolina.acelerar();
        service = new CochesService(new OracleRepository());
        service.guardar(cocheGasolina);

        System.out.println("\n------------------");
        System.out.println("Fin del programa");
    }
}

/* ****Sample output ***********

    Inicia el programa
    ------------------

    Guardando coche:
    Data {Tipo='CocheElectrico', marca='CHEVROLET', modelo='Captiva SL', velocidad=5}
     en base de datos: MySQLRespository

    Guardando coche:
    Data {Tipo='CocheGasolina', marca='PEUGEOT', modelo='3008 SX', velocidad=10}
     en base de datos: OracleRepository

    ------------------
    Fin del programa

 *********************************/