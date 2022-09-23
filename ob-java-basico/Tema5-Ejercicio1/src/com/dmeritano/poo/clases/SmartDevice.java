package com.dmeritano.poo.clases;


public class SmartDevice {

    private String model;
    private String brand;
    private int yearAnnounced;

    public SmartDevice() {

    }

    public SmartDevice(String name, String brand, int yearAnnounced) {
        this.model = name;
        this.brand = brand;
        this.yearAnnounced = yearAnnounced;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearAnnounced() {
        return yearAnnounced;
    }

    public void setYearAnnounced(int yearAnnounced) {
        this.yearAnnounced = yearAnnounced;
    }

    public void Encender(){
        System.out.println("SmartDevice encendido");
    }

    public void Apagar(){
        System.out.println("SmartDevice apagado");
    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", announced year=" + yearAnnounced +
                '}';
    }
}
