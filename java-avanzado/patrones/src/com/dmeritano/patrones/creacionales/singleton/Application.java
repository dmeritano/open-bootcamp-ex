package com.dmeritano.patrones.creacionales.singleton;

import java.util.Date;

public class Application {

    private static Application application;
    private static Date appStatedAt;
    private boolean isRunning = false;

    private Application(){}

    public static Application getInstance(){
        if (application == null){
            application = new Application();
        }
        return application;
    }

    public void Run(){
        if (isRunning){
            System.out.println("Application already started at " + appStatedAt.toString());
        }else{
            isRunning = true;
            appStatedAt = new Date();
            System.out.println("Applicatin started!");
        }
    }

}
