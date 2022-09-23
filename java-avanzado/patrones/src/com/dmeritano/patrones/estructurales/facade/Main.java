package com.dmeritano.patrones.estructurales.facade;

import java.io.File;

public class Main {

    //Simplicar el sistema desde el punto de vista de quien lo va a utilizar/consumir
    // Ejemplo desde https://refactoring.guru/

    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...

        converter = new VideoConversionFacade();
        File oggVideo = converter.convertVideo("youtubevideo.mp4", "ogg");
        // ...
    }
}
