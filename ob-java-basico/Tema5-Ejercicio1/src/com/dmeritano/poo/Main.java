package com.dmeritano.poo;

import com.dmeritano.poo.clases.SmartDevice;
import com.dmeritano.poo.clases.SmartPhone;
import com.dmeritano.poo.clases.SmartWatch;

public class Main {

    public static void main(String[] args) {


        SmartDevice device = new SmartDevice("Galaxy S20", "Samnsung", 2020);
        System.out.println(device);
        device.Encender(); //Implementacion de clase padre


        SmartWatch watch = new SmartWatch("Watch 7", "Apple", 2019,
                "20 megapixels", "PVC", true);
        System.out.println(watch);
        watch.Encender(); //Implementacion de clase padre

        SmartPhone phone = new SmartPhone();
        phone.setModel("Iphone 13pro");
        phone.setBrand("Apple");
        phone.setYearAnnounced(2021);
        phone.setNetwork("GSM / CDMA");
        phone.setSelfieCameraResolution("20 megapixels");
        phone.setMainCameraResolution("40 megapixels");
        phone.setOsName("iOS 15");
        phone.setSim("Single SIM");
        System.out.println(phone);
        phone.Encender(); //Implementacion propia de SmartPhone

    }
}

/* Sample output

SmartDevice{model='Galaxy S20', brand='Samnsung', announced year=2020}
SmartDevice encendido
SmartWatch{model='Watch 7', brand='Apple', announced='2019', mainCameraResolution='20 megapixels', strapMaterial='PVC', canAnswerCalls=true}
SmartDevice encendido
SmartPhone{model='Iphone 13pro', brand='Apple', announced='2021', network='GSM / CDMA', selfieCameraResolution='20 megapixels', mainCameraResolution='40 megapixels', osName='iOS 15', sim='Single SIM'}
SmartPhone encendido

 */