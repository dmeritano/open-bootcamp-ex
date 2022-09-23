package com.dmeritano.poo.clases;

public class SmartPhone extends SmartDevice{

    private String network;
    private String selfieCameraResolution;
    private String mainCameraResolution;
    private String osName;
    private String sim;

    public SmartPhone(){

    }

    public SmartPhone(String network, String selfieCameraResolution, String mainCameraResolution,
                      String osName, String sim) {
        this.network = network;
        this.selfieCameraResolution = selfieCameraResolution;
        this.mainCameraResolution = mainCameraResolution;
        this.osName = osName;
        this.sim = sim;
    }

    public SmartPhone(String name, String brand, int yearAnnounced, String network, String selfieCameraResolution,
                      String mainCameraResolution, String osName, String sim) {
        super(name, brand, yearAnnounced);
        this.network = network;
        this.selfieCameraResolution = selfieCameraResolution;
        this.mainCameraResolution = mainCameraResolution;
        this.osName = osName;
        this.sim = sim;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getSelfieCameraResolution() {
        return selfieCameraResolution;
    }

    public void setSelfieCameraResolution(String selfieCameraResolution) {
        this.selfieCameraResolution = selfieCameraResolution;
    }

    public String getMainCameraResolution() {
        return mainCameraResolution;
    }

    public void setMainCameraResolution(String mainCameraResolution) {
        this.mainCameraResolution = mainCameraResolution;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    @Override
    public void Encender() {
        System.out.println("SmartPhone encendido");
    }

    @Override
    public void Apagar() {
        System.out.println("SmartPhone apagado");
    }


    @Override
    public String toString() {
        return "SmartPhone{" +
                "model='" + super.getModel() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", announced='" + super.getYearAnnounced() + '\'' +
                ", network='" + network + '\'' +
                ", selfieCameraResolution='" + selfieCameraResolution + '\'' +
                ", mainCameraResolution='" + mainCameraResolution + '\'' +
                ", osName='" + osName + '\'' +
                ", sim='" + sim + '\'' +
                "} ";
    }
}
