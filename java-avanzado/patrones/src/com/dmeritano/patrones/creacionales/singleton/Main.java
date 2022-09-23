package com.dmeritano.patrones.creacionales.singleton;

public class Main {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        singleton.setContador(15);
        System.out.println(singleton.getContador());
        System.out.println(singleton);

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.getContador());
        System.out.println(singleton2);

        System.out.println("\n\n");

        //  Application
        Application app = Application.getInstance();
        Application app2 = Application.getInstance();
        app.Run();
        app2.Run();

        System.out.println(app + "  " + app2);

    }
}
