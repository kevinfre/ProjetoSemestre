package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexãoDB {
    private static String db = "projetoSemestre";
    private static String url = "jdbc:mysql://localhost:32773/" + db;
    private static String user = "root";
    private static String password = "root";
    private static Connection conn;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {

                System.out.println("Falha em criar conexão com database.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver não encontrado.");
        }
        return conn;
    }

    public void close() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception var2) {
                var2.printStackTrace();
            }

            this.conn = null;
        }

    }
}
