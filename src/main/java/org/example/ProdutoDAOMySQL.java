package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOMySQL {
    private String createSQL = "INSERT INTO Produto VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM Produto";
    private String updateSQL = "UPDATE Produto SET id=?, descricao=?, marca=?, preco=? WHERE id=?";
    private String deleteSQL = "DELETE FROM Produto WHERE id=?";

    private final ConexãoDB mysql = new ConexãoDB();



    public boolean createProduto(Produto produto) {
        Connection conexao = mysql.getConn();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            //Inicializando os valores
            stm.setInt(1, produto.getId());
            stm.setString(2, produto.getDescrição());
            stm.setString(3, produto.getMarca());
            stm.setInt(4, produto.getPreço());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return  registros > 0 ? true : false;

        } catch (SQLException e) {
            System.out.println("Falha de conexão com a database!");
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Produto> read() {
        Connection conexao = mysql.getConn();
        List<Produto> produtos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();


                Produto.setId(rs.getInt("id"));
                Produto.setDescrição(rs.getString("descricao"));
                Produto.setMarca(rs.getString("marca"));
                Produto.setPreço(rs.getInt("preco"));
            }

            return produtos;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        }    finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }

        return produtos;
    }

    public boolean update(Produto produto) {
        Connection conexao = mysql.getConn();

        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);


            stm.setInt(1, Produto.getId() );
            stm.setString(2, Produto.getDescrição());
            stm.setString(3, Produto.getMarca());
            stm.setInt(4, Produto.getPreço());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(Produto produto) {
        Connection conexao = mysql.getConn();

        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setInt(1, Produto.getId());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


}
