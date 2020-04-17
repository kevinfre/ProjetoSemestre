package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args )
    {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String user = "root";
            String psw = "root";

            conn = DriverManager.getConnection(url,user,psw);

            String sql = "INSERT INTO `controleFrequencia`.`alunos`\n" +
                    "(`tia`,\n" +
                    "`horaEntrada`,\n" +
                    "`horaSaida`)\n" +
                    "VALUES\n" +
                    "(31706525, '7:00', '11:00');";
            PreparedStatement pstm = conn.prepareStatement(sql);


            int rs = pstm.executeUpdate();

            conn.close();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
