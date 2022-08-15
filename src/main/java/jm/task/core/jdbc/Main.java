package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // реализуйте алгоритм здесь
        String url = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String password = "admin";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(url, userName, password);
             Statement statement = conn.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password long not null , PRIMARY KEY (id));");
            statement.executeUpdate("INSERT INTO Users (name, password) VALUES ('max','admin1')");
            statement.executeUpdate("INSERT INTO Users (name, password) VALUES ('ken','admin2')");
            statement.executeUpdate("INSERT INTO Users (name, password) VALUES ('bob','admin3')");
            statement.executeUpdate("INSERT INTO Users (name, password) VALUES ('alex','admin4')");
            ResultSet resultSet = statement.executeQuery("select * from Users");
            while (resultSet.next()) {
                System.out.println("userName: " + resultSet.getString("name"));
                System.out.println("userPassword: " + resultSet.getString("password"));
            }
            statement.execute("drop table Users");
        }

    }
}
