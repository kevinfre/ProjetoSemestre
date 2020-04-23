package org.example;

public class Aplicativo {
      int id;
      String nome;
      String desenvolvedor;
      int downloads;

    public Aplicativo(int id, String nome, String desenvolvedor, int downloads) {
        this.id = id;
        this.nome = nome;
        this.desenvolvedor = desenvolvedor;
        this.downloads = downloads;
    }

    public Aplicativo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getNome() {
        return nome;
    }

    public  void setNome(String nome) {
        this.nome = nome;
    }

    public  String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public  int getDownloads() {
        return downloads;
    }

    public  void setDownloads(int downloads) {
        this.downloads = downloads;
    }
}
