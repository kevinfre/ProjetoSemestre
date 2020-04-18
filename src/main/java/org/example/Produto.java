package org.example;

public class Produto {
    int id;
    String descrição;
    String marca;
    int preço;

    public Produto(int id, String descrição, String marca, int preço){
        this.id = id;
        this.descrição = descrição;
        this.marca = marca;
        this.preço = preço;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPreço() {
        return preço;
    }

    public void setPreço(int preço) {
        this.preço = preço;
    }
}

