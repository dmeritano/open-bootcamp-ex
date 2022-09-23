package com.dmeritano.solid;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nInicia el programa");
        System.out.println("------------------\n");

        Coche coche = new Coche("CHEVROLET","Captiva SL",5);
        coche.acelerar();
        coche.acelerar();
        System.out.println(coche);

        //Single responsability - La exportacion la hace otra clase
        coche.exportarDatos();


        //Open for extension
        CocheGasolina cocheGasolina = new CocheGasolina("PEUGEOT","3008 SX",4 );
        cocheGasolina.cargarCombustible();
        cocheGasolina.acelerar();
        cocheGasolina.acelerar();
        cocheGasolina.frenar();
        System.out.println(cocheGasolina);


        //Liskov principle
        CocheElectrico cocheElectrico = new CocheElectrico("TESLA","SX 2022", 2);
        cocheElectrico.cargarBateria();
        cocheElectrico.acelerar();
        cocheElectrico.acelerar();
        System.out.println(cocheElectrico);

        CocheGasolina cocheGasolinaTurbo = new CocheGasolinaTurbo("BWM","XTS 300cv", 4);
        cocheGasolinaTurbo.acelerar();
        cocheGasolinaTurbo.acelerar();
        cocheGasolinaTurbo.cargarCombustible();
        System.out.println(cocheGasolinaTurbo);

        Coche cocheComun = new CocheGasolina("FIAT", "Space One",5);
        cocheComun.acelerar();
        cocheComun.acelerar();
        cocheComun.acelerar();
        cocheComun.frenar();
        System.out.println(cocheComun);

        System.out.println("\nFin del programa");

    }
}


/* Sample output *************************************

        Inicia el programa
        ------------------

        Data {Tipo='Coche', marca='CHEVROLET', modelo='Captiva SL', velocidad=2}

        -------------------------------
          Coche Marca   : CHEVROLET
          Coche Modelo  : Captiva SL
          Coche Puertas : 5
        -------------------------------

        Data {Tipo='CocheGasolina', marca='PEUGEOT', modelo='3008 SX', velocidad=10}
        Data {Tipo='CocheElectrico', marca='TESLA', modelo='SX 2022', velocidad=10}
        Data {Tipo='CocheGasolinaTurbo', marca='BWM', modelo='XTS 300cv', velocidad=60}
        Data {Tipo='CocheGasolina', marca='FIAT', modelo='Space One', velocidad=20}

        Fin del programa

 **************************************/