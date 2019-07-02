package br.com.schumaker.reflection.api;

import br.com.schumaker.reflection.framework.Hudwork;
import java.util.Scanner;

public class Main {

    /**
     * Simula o navegador.
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        /*
         * Casos possiveis:
         * /controlador/metodo
         * /controlador/metodo?param1=valor1&param2=valor2
         */
        try (Scanner s = new Scanner(System.in)) {
            String url = s.nextLine();

            Hudwork hudwork = new Hudwork("br.com.schumaker.reflection.api.controle.");
            while (!url.equals("exit")) {
                Object response = hudwork.executa(url);
                System.out.println("Response: " + response);
                url = s.nextLine();
            }
        }
    }
}
