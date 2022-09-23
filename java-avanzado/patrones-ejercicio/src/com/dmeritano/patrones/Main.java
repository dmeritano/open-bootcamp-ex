package com.dmeritano.patrones;

public class Main {

    public static void main(String[] args){

        /*
            Identifica las características principales de los patrones de diseño más conocidos, indica para qué
            valen y un caso de uso para cada uno de ellos:

            --> Ver README.md

            Crea una pequeña aplicación implementando el patrón Singlenton y demuestra que, efectivamente,
            no crea instancias nuevas. Puedes tomar la sesión 7 como referencia.

         */

        //Usamos patron Singleton para manejar conexion a una BD MySQL

        //Obtenemos una instancia de conexion a la BD
        Database db = Database.getInstance();
        System.out.println(db.getConnection());  //Conectado a MySQL 2022-08-22T16:37:39.913971600

        //Obtenemos otra instancia y vemos que la clase nos devolvio la misma instancia creada en la linea anterior
        Database db2 = Database.getInstance();
        System.out.println(db2.getConnection()); //Conectado a MySQL 2022-08-22T16:37:39.913971600

        //Volvemos a comprobamos que la instancia es la misma (misma direccion de memoria)
        System.out.println(db==db2);  //Devuelve true

    }
}
