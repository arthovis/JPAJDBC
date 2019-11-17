package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persoana> persoane = new ArrayList<>();
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select id, name from person");
            while (resultSet.next()) {
                persoane.add(Utils.mapRowToPersoana(resultSet));
            }
        } catch (SQLException e) {
            //proceseaza exceptia
            e.printStackTrace();
        } finally {
            Utils.tryToCloseConnection(connection);
        }
        System.out.println(persoane);
    }

}
