package com.dmeritano.patrones;


import java.time.LocalDateTime;
import java.util.Date;

public class Database {

    private static Database instance;
    private String connection;
    private String url = "jdbc:mysql:// localhost:3306/proveedores";
    private String usuario = "root";
    private String password = "root";

    private Database(){
        this.connection = dummyDriverManagerGetConnection(url, usuario, password);
    }
    public String getConnection() {
        return connection;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


    private String dummyDriverManagerGetConnection(String url, String usuario, String password){
        return "Conectado a MySQL " + LocalDateTime.now();
    }
}