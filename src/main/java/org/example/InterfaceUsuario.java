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
            switch (opcao2){
                case 1:
                    // TUDO FUNCIONANDO
                    this.createAplicativo();
                    break;
                case 2:
                    // não aparece nenhum aplicativo cadastrado
                    this.readAplicativo();
                    break;
                case 3:
                    // não aparece aplicativos cadastrados
                    this.deleteAplicativo();
                    break;
                case 4:
                    // completar essa parte
                    this.updateAplicativo();
                case 5:
                    System.out.println("Até mais!");
                    break;

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
            switch (opcao3){
                case 1:
                    this.createProduto();
                    break;
                case 2:
                    this.readProduto();
                    break;
                case 3:
                    this.deleteProduto();
                    break;
                case 4:
                    this.updateAplicativo();
                case 5:
                    System.out.println("Até mais!");
                    break;
            }
        } while (opcao3 != 5);

    }

    private void imprimirMenu() {
        int opcao = 0;
        do {
            System.out.println("\n\n### C.R.U.D Aplicativo & Produto ###");
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
        System.out.println("*** Novo aplicativo ***");
        System.out.println("******************");

        System.out.print("Informe o ID do aplicativo: ");
        aplicativo.setId(entrada.nextInt());

        System.out.print("Informe o NOME do aplicativo: ");
        aplicativo.setNome(entrada.next());


        System.out.print("Informe o DESENVOLVEDOR do aplicativo: ");
        aplicativo.setDesenvolvedor(entrada.next());


        System.out.println("Informe o número de DOWNLOADS do aplicativo: ");
        aplicativo.setDownloads(entrada.nextInt());

        if (daoAplicativo.createAplicativo(aplicativo)) {
            System.out.println("Aplicativo criado e  adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao criar o aplicativo!");
        }
        imprimirMenu();
    }

    private void readAplicativo() {
        System.out.println("\n***********************************");
        System.out.println("*** Lista de aplicativos Cadastrados ***");
        System.out.println("***********************************");

        List<Aplicativo> aplicativos = daoAplicativo.read();
        System.out.println("****************************************");


    }

    private void updateAplicativo(){

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


        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Aplicativos Cadastrados ***");
            System.out.println("***********************************");
            List<Aplicativo> aplicativos = daoAplicativo.read();


            System.out.print("Qual aplicativo deseja remover? ");
            int opc = entrada.nextInt();
            //Necessário para ler a quebra de linha (enter)
            entrada.nextLine();


            if (opc >= aplicativos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (daoAplicativo.delete(aplicativos.get(opc))) {
                    System.out.println("Aplicativo " + aplicativos.get(opc).getNome() +
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


        System.out.print("Informe a DESCRIÇÃO do produto: ");
        produto.setDescrição(entrada.next());

        System.out.print("Informe a MARCA do produto: ");
        produto.setMarca(entrada.next());

        System.out.println("Informe o preço do produto: ");
        produto.setPreço(entrada.nextInt());

        if (daoProduto.createProduto(produto)) {
            System.out.println("Produto adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o produto");
        }
        imprimirMenu();
    }

    private void readProduto() {

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Produtos Cadastrados ***");
        System.out.println("***********************************");
        List<Produto> produtos = daoProduto.read();

        System.out.println("****************************************");

    }

    private void deleteProduto() {

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Produtos Cadastrados ***");
            System.out.println("***********************************");

            List<Produto> produtos = daoProduto.read();
            System.out.print("Qual produto deseja remover? ");
            int opc = entrada.nextInt();
            //Necessário para ler a quebra de linha (enter)
            entrada.nextLine();


            if (opc >= produtos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
                System.out.println("Cancelar operação? (Sim = 1, Não = 0)");
                int opc2 = entrada.nextInt();
                if (opc2 == 0){
                    deleteProduto();
                } else {
                    break;
                }
            } else {
                if (daoProduto.delete(produtos.get(opc))) {
                    System.out.println("Produto " + produtos.get(opc).getMarca() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                //Isso para o while infinito
                break;
            }
        }

    }

    private void updateProduto(){

      while (true) {
          System.out.println("\n***********************************");
          System.out.println("*** Lista de Produtos Cadastrados ***");
          System.out.println("***********************************");

          List<Produto> produtos = daoProduto.read();
          System.out.print("Qual produto deseja alterar? ");
          int opc = entrada.nextInt();
          //Necessário para ler a quebra de linha (enter)
          entrada.nextLine();


          if (opc >= produtos.size() || opc < 0) {
              System.out.println("Esta opção não é válida");
              System.out.println("Cancelar operação? (Sim = 1, Não = 0)");
              int opc2 = entrada.nextInt();
              if (opc2 == 0){
                  uptadeProduto();
              } else {
                  break;
              }
          } else {

            System.out.print("\nInforme o ID do produto: ");
            produto.get(opc).setId(entrada.nextInt());


            System.out.print("Informe a DESCRIÇÃO do produto: ");
          produto.get(opc).setDescrição(entrada.next());

            System.out.print("Informe a MARCA do produto: ");
            produto.get(opc).setMarca(entrada.next());

            System.out.println("Informe o preço do produto: ");
            produto.get(opc).setPreço(entrada.nextInt());


              if (daoProduto.update(produtos.get(opc))) {
                  System.out.println("Produto " + produtos.get(opc).getMarca() +
                          " alterado com sucesso");
              } else {
                  System.out.println("OPS: falar ao tentar alterar");
              }
              //Isso para o while infinito
              break;
          }
      }

  }










}
