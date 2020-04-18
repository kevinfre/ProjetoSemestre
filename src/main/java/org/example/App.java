package org.example;


import java.io.Console;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) {
        int opcao = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out
                    .println("\n\n### C.R.U.D --> PRODUTO & APLICATIVO ###");
            System.out.println("\n                  =========================");
            System.out.println("                  |     1 - PRODUTO         |");
            System.out.println("                  |     2 - APLICATIVO      |");
            System.out.println("                  |     0 - Sair            |");
            System.out.println("                  =========================\n");


            System.out.print("\n");
            switch (opcao) {
                case 1:
                    break;
                case 2:

                    break;

                case 5:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);


    }
}
