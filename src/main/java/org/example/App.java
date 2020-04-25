package org.example;


import java.io.Console;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) {
        AplicativoDAOMySQL aplicativoDao = new AplicativoDAOMySQL();
        ProdutoDAOMySQL produtoDao = new ProdutoDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(produtoDao, aplicativoDao);
        interfaceUsuario.iniciar();
    }
}
