package com.dmeritano;

public class Main {

    public static void main(String[] args) {

        String quoteWords[] = {"La","vida","es","demasiado","corta","para","quitar","el","USB","con","seguridad"};

        //Con for.. each
        String quote = "";
        for(String palabra : quoteWords){
            quote += palabra + " ";
        }
        System.out.println(quote);

        //Con while
        int contador = 0;
        quote = "";
        while(contador < quoteWords.length){
            quote += quoteWords[contador] + " ";
            contador++;
        }
        System.out.println(quote);

    }
}


/*  Sample output

    La vida es demasiado corta para quitar el USB con seguridad
    La vida es demasiado corta para quitar el USB con seguridad

 */