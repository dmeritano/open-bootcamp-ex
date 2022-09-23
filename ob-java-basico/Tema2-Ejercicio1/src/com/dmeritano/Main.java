package com.dmeritano;

public class Main {

    public static void main(String[] args) {

        //Datos primitivos numericos
        byte number = 5;
        mostrarDatos( (Object)number,"byte", String.valueOf(number) );

        short number2 = 15;
        mostrarDatos( (Object)number2,"short", String.valueOf(number2) );

        int number3 = 213032;
        mostrarDatos( (Object)number3,"int", String.valueOf(number3) );

        long number4 = 130002130;
        mostrarDatos( (Object)number4,"long", String.valueOf(number4) );

        float number5 = 50.523f;
        mostrarDatos( (Object)number5,"float", String.valueOf(number5) );

        double number6 = 15065.5d;
        mostrarDatos( (Object)number6,"double", String.valueOf(number6) );

        //Otros datos primitivos
        char character = 'a';
        mostrarDatos( (Object)character,"char", String.valueOf(character) );

        boolean encendido = false;
        mostrarDatos( (Object)encendido,"boolean", String.valueOf(encendido) );

        String cadena = "Java 11";
        mostrarDatos( (Object)cadena,"String", cadena );

    }

    private static void mostrarDatos(Object object, String tipoPrimitivo, String valor){
        String javaClass = object.getClass().getName();
        String output = "Tipo primitivo: " + tipoPrimitivo + ", Valor: <" +valor + ">, clase: " + javaClass;

        switch (javaClass){
            case "java.lang.Byte":
                output += ", MAX_VALUE: " + String.valueOf(Byte.MAX_VALUE);
                break;
            case "java.lang.Short":
                output += ", MAX_VALUE: " + String.valueOf(Short.MAX_VALUE);
                break;
            case "java.lang.Integer":
                output += ", MAX_VALUE: " + String.valueOf(Integer.MAX_VALUE);
                break;
            case "java.lang.Long":
                output += ", MAX_VALUE: " + String.valueOf(Long.MAX_VALUE);
                break;
            case "java.lang.Float":
                output += ", MAX_VALUE: " + String.valueOf(Float.MAX_VALUE);
                break;
            case "java.lang.Double":
                output += ", MAX_VALUE: " + String.valueOf(Double.MAX_VALUE);
                break;
            case "java.lang.Boolean":
                break;
            case "java.lang.Character":
                output += ", ASCII_VALUE: " + (int)valor.charAt(0);
                break;
            case "java.lang.String":
                break;
            default:
                output += "Sin datos";
        }
        System.out.println(output);
    }
}

/* Sample output:
    Tipo primitivo: byte, Valor: <5>, clase: java.lang.Byte, MAX_VALUE: 127
    Tipo primitivo: short, Valor: <15>, clase: java.lang.Short, MAX_VALUE: 32767
    Tipo primitivo: int, Valor: <213032>, clase: java.lang.Integer, MAX_VALUE: 2147483647
    Tipo primitivo: long, Valor: <130002130>, clase: java.lang.Long, MAX_VALUE: 9223372036854775807
    Tipo primitivo: float, Valor: <50.523>, clase: java.lang.Float, MAX_VALUE: 3.4028235E38
    Tipo primitivo: double, Valor: <15065.5>, clase: java.lang.Double, MAX_VALUE: 1.7976931348623157E308
    Tipo primitivo: char, Valor: <a>, clase: java.lang.Character, ASCII_VALUE: 97
    Tipo primitivo: boolean, Valor: <false>, clase: java.lang.Boolean
    Tipo primitivo: String, Valor: <Java 11>, clase: java.lang.String
 */