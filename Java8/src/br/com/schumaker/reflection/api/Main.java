package br.com.schumaker.reflection.api;

import br.com.schumaker.reflection.api.dao.ProdutoDao;
import br.com.schumaker.reflection.api.dao.ProdutoDaoMock;
import br.com.schumaker.reflection.framework.Hudwork;
import java.util.Scanner;

/**
 * @author Hudson Schumaker
 */
public class Main {

    /**
     * Simulates a web browser
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
            hudwork.registra(ProdutoDao.class, ProdutoDaoMock.class);
            while (!url.equals("exit")) {
                Object response = hudwork.executa(url);
                System.out.println("Response: " + response);
                url = s.nextLine();
            }
        }
    }
}
