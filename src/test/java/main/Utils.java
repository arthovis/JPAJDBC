package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
    public static Persoana mapRowToPersoana(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        return new Persoana(id, name);
    }

    public static void tryToCloseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/jdbc_db";
        String user = "root";
        String password = "Krevitusmaximus1";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get connection", e);
        }
    }
}
