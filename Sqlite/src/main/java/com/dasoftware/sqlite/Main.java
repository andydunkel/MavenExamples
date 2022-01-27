package com.dasoftware.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String [] args) {
        Connection conn = null;

        try {
            //Connect to server
            var connString = "jdbc:sqlite:db.sqlite";
            conn = DriverManager.getConnection(connString);
            System.out.println("Connected to: " + connString);

            //Query some data
            var sql = "SELECT id, name, value FROM SystemStatus";
            var statement = conn.createStatement();
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("value"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
