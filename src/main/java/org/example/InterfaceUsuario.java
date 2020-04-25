package org.example;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    ProdutoDAO daoProduto;
    AplicativoDAO daoAplicativo;
    int opcao = 0;
    Scanner entrada = new Scanner(System.in);

    public InterfaceUsuario(ProdutoDAO daoProduto, AplicativoDAO daoAplicativo) {
        this.daoProduto = daoProduto;
        this.daoAplicativo = daoAplicativo;
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    public void imprimirMenuAplicativo(){
        int opcao2 = 0;
        do {
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Delete");
            System.out.println("\t4. Update");
            System.out.println("\t5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao2 = entrada.nextInt();
            this.createAplicativo();
            switch (opcao2){
                case 1:
                    this.createAplicativo();
                case 2:
                    this.readAplicativo();
                case 3:
                    this.deleteAplicativo();
            }
        } while (opcao2 != 5);

    }

    public void imprimirMenuProduto(){
        int opcao3 = 0;
        do {
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Delete");
            System.out.println("\t4. Update");
            System.out.println("\t5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao3 = entrada.nextInt();
            this.createAplicativo();
            switch (opcao3){
                case 1:
                    this.createProduto();
                case 2:
                    this.readProduto();
                case 3:
                    this.deleteProduto();
            }
        } while (opcao3 != 5);

    }

    private void imprimirMenu() {
        int opcao = 0;
        do {
            System.out.println("\n\n### Sistema de controle Charger Locker's ###");
            System.out.println("\n                 ============================================ ");
            System.out.println("                  |     1 - APLICATIVO         |");
            System.out.println("                  |     2 - PRODUTO            |");
            System.out.println("                  |     3 - SAIR               |");
            System.out.println("                  ============================================\n");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                   imprimirMenuAplicativo();
                    break;
                case 2:
                    imprimirMenuProduto();
                    break;
                case 3:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opcao != 3);
    }

    private void createAplicativo() {
        Aplicativo aplicativo = new Aplicativo();
        System.out.println("\n******************");
        System.out.println("*** Novo aluno ***");
        System.out.println("******************");
        System.out.print("\nInforme o ID do aplicativo: ");
        aplicativo.setId(entrada.nextInt());
        //necessário para ler o \n da entrada (enter)
        entrada.nextInt();

        System.out.print("Informe o NOME do aplicativo: ");
        aplicativo.setNome(entrada.nextLine());

        System.out.print("Informe o DESENVOLVEDOR do aplicativo: ");
        aplicativo.setDesenvolvedor(entrada.nextLine());

        System.out.println("Informe o número de DOWNLOADS do aplicativo: ");
        aplicativo.setDownloads(entrada.nextInt());

        if (daoAplicativo.createAplicativo(aplicativo)) {
            System.out.println("Aluno adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o aluno");
        }
    }

    private void readAplicativo() {
        List<Aplicativo> alunos = daoAplicativo.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de aplicativos Cadastrados ***");
        System.out.println("***********************************");
        for(Aplicativo aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void UpdateAplicativo() {
      List<Aplicativo> alunos = daoAplicativo.read();

      while (true) {
          System.out.println("\n***********************************");
          System.out.println("*** Lista de Alunos\\ Cadastrados ***");
          System.out.println("***********************************");
          int i = 0;
          for (Aplicativo aluno : alunos) {
              System.out.println(i + " - " + aluno);
              i++;
          }
          System.out.println(i + " - Cancelar operação");

          System.out.print("Qual aluno deseja alterar ?");
          int opc = entrada.nextInt();
          //Necessário para ler a quebra de linha (enter)
          entrada.nextLine();

          if (opc==i) {
              // Cancelar operação
              break;
          }

          if (opc >= alunos.size() || opc < 0) {
              System.out.println("Esta opção não é válida");
          } else {

              System.out.print("Informe o NOME do aplicativo: ");
              alunos.get(opc).setNome(entrada.nextLine());

              System.out.print("Informe o DESENVOLVEDOR do aplicativo: ");
              alunos.get(opc).setDesenvolvedor(entrada.nextLine());

              System.out.println("Informe o número de DOWNLOADS do aplicativo: ");
              alunos.get(opc).setDownloads(entrada.nextInt());

              if (daoAplicativo.update(alunos.get(opc))) {
                  System.out.println("Aluno " + alunos.get(opc).getNome() +
                          " alterado com sucesso");
              } else {
                  System.out.println("OPS: falar ao tentar alterar");
              }
              //Isso para o while infinito
              break;
          }
      }
  }
    private void deleteAplicativo() {
        List<Aplicativo> alunos = daoAplicativo.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Alunos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Aplicativo aluno : alunos) {
                System.out.println(i + " - " + aluno);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual aluno deseja remover? ");
            int opc = entrada.nextInt();
            //Necessário para ler a quebra de linha (enter)
            entrada.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= alunos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (daoAplicativo.delete(alunos.get(opc))) {
                    System.out.println("Aluno " + alunos.get(opc).getNome() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                //Isso para o while infinito
                break;
            }
        }
    }

    private void createProduto() {
        Produto produto = new Produto();

        System.out.println("\n******************");
        System.out.println("*** Novo Produto ***");
        System.out.println("******************");
        System.out.print("\nInforme o ID do produto: ");
        produto.setId(entrada.nextInt());
        //necessário para ler o \n da entrada (enter)
        entrada.nextInt();

        System.out.print("Informe a DESCRIÇÃO do produto: ");
        produto.setDescrição(entrada.nextLine());

        System.out.print("Informe a MARCA do produto: ");
        produto.setMarca(entrada.nextLine());

        if (daoProduto.createProduto(produto)) {
            System.out.println("Produto adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o produto");
        }
    }

    private void readProduto() {
        List<Produto> produtos = daoProduto.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Produtos Cadastrados ***");
        System.out.println("***********************************");
        for(Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private void deleteProduto() {
        List<Produto> produtos = daoProduto.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Produtos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Produto produto : produtos) {
                System.out.println(i + " - " + produto);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual produto deseja remover? ");
            int opc = entrada.nextInt();
            //Necessário para ler a quebra de linha (enter)
            entrada.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= produtos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (daoProduto.delete(produtos.get(opc))) {
                    System.out.println("Aluno " + produtos.get(opc).getId() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                //Isso para o while infinito
                break;
            }
        }
    }










}
