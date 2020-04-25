package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AplicativoDAOMySQL implements AplicativoDAO {

    private String createSQL = "INSERT INTO Aplicativo VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM Aplicativo";
    private String updateSQL = "UPDATE Aplicativo SET id=?, nome=?, desenvolvedor=?, downloads=? WHERE id=?";
    private String deleteSQL = "DELETE FROM Aplicativo WHERE id=?";


    private final ConexãoDB mysql = new ConexãoDB();




    @Override
    public boolean createAplicativo(Aplicativo aplicativo) {
        Connection conexao = mysql.getConn();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            //Inicializando os valores
            stm.setInt(1, aplicativo.getId());
            stm.setString(2, aplicativo.getNome());
            stm.setString(3, aplicativo.getDesenvolvedor());
            stm.setInt(4, aplicativo.getDownloads());

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

    @Override
    public List<Aplicativo> read() {
        Connection conexao = mysql.getConn();
        List<Aplicativo> aplicativos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();


            while (rs.next()) {
                Aplicativo aplicativo = new Aplicativo();

                aplicativo.setId(rs.getInt("id"));
                aplicativo.setNome(rs.getString("nome"));
                aplicativo.setDesenvolvedor(rs.getString("desenvolvedor"));
                aplicativo.setDownloads(rs.getInt("downloads"));
                aplicativos.add(aplicativo);

                System.out.println("--ID--: " +aplicativo.id + "\n Nome: " + aplicativo.nome + "\n Desenvolvedor: " +
                        aplicativo.desenvolvedor + "\n Downloads: " + aplicativo.downloads);
            }



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

        return aplicativos;
    }

    @Override
    public boolean update(Aplicativo aplicativo) {
        Connection conexao = mysql.getConn();

        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);


            stm.setInt(1, aplicativo.getId() );
            stm.setString(2, aplicativo.getNome());
            stm.setString(3, aplicativo.getDesenvolvedor());
            stm.setInt(4, aplicativo.getDownloads());

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

    @Override
    public boolean delete(Aplicativo aplicativo) {
        Connection conexao = mysql.getConn();

        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setInt(1, aplicativo.getId());

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
