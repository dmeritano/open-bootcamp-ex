package com.dmeritano.poo.clases;

public class SmartWatch extends SmartDevice {

    private String mainCameraResolution;
    private String strapMaterial;
    private boolean canAnswerCalls;

    public SmartWatch() {

    }

    public SmartWatch(String mainCameraResolution, String strapMaterial, boolean canAnswerCalls) {
        this.mainCameraResolution = mainCameraResolution;
        this.strapMaterial = strapMaterial;
        this.canAnswerCalls = canAnswerCalls;
    }

    public SmartWatch(String name, String brand, int yearAnnounced, String mainCameraResolution,
                      String strapMaterial, boolean canAnswerCalls) {
        super(name, brand, yearAnnounced);
        this.mainCameraResolution = mainCameraResolution;
        this.strapMaterial = strapMaterial;
        this.canAnswerCalls = canAnswerCalls;
    }

    public String getMainCameraResolution() {
        return mainCameraResolution;
    }

    public void setMainCameraResolution(String mainCameraResolution) {
        this.mainCameraResolution = mainCameraResolution;
    }

    public String getStrapMaterial() {
        return strapMaterial;
    }

    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    public boolean isCanAnswerCalls() {
        return canAnswerCalls;
    }

    public void setCanAnswerCalls(boolean canAnswerCalls) {
        this.canAnswerCalls = canAnswerCalls;
    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "model='" + super.getModel() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", announced='" + super.getYearAnnounced() + '\'' +
                ", mainCameraResolution='" + mainCameraResolution + '\'' +
                ", strapMaterial='" + strapMaterial + '\'' +
                ", canAnswerCalls=" + canAnswerCalls +
                "} ";
    }
}
