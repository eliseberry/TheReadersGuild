package com.aca.TheReadersGuild.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBUtil {
        private static String connectionURL =
            "jdbc:mariadb://localhost:3306/thereadersguild?user=root&password=Eb200302";
        public static Connection getConnection(){
                Connection connection = null;


            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(connectionURL);
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
            }

            return connection;
        }
        public static void main(String[] args){
                Connection connection = MariaDBUtil.getConnection();
                if (null != connection) {
                        System.out.println("Real DB Connection");
                }else {
                        System.out.println("No connection");
                }
        }
}
