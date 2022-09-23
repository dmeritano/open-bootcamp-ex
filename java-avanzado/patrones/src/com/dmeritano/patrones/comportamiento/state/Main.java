package com.dmeritano.patrones.comportamiento.state;

public class Main {

    /*  Parton State

        Este patrón se encarga de permitirnos gestionar de una manera sencilla los distintos comportamientos que
        puede tener un objeto en función de su estado. Es realmente útil para modelar máquinas de estado sin
        tener que implementar complejas estructuras condicionales. Util para worfklows

        En el ejemplo vamos a imaginar un telefono movil, en el cual no podemos hacer una foto sin desbloquear el telefono
     */

    public static void main(String[] args) {

        Telefono tel1 = new Telefono();
        System.out.println(tel1.getEstado().abrirCamara());
        System.out.println(tel1.getEstado().sacarFoto());

        tel1.cambiarEstado(new EstadoDesbloqueado(tel1));
        System.out.println(tel1.getEstado().abrirCamara());
        System.out.println(tel1.getEstado().sacarFoto());


    }

}
