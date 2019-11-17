package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MainExercitiu {
    public static void main(String[] args) {
        Map<Masina, Proprietar> masiniSiProprietari = new HashMap<>();
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            ResultSet resultSet = connection.createStatement()
                    .executeQuery("select m.id, m.culoare,m.marca, m.cnp_proprietar, p.cnp, p.adresa from masina m join proprietar p on m.cnp_proprietar = p.cnp;");
            while (resultSet.next()) {
                masiniSiProprietari.put(Utils.mapRowToMasina(resultSet), Utils.mapRoWToProprrietar(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.tryToCloseConnection(connection);
        }
        System.out.println(masiniSiProprietari);
    }
}