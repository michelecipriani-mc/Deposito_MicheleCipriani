package com.example;

import java.sql.*;

public class Main {
    
    public static void main(String[] args) {
        //salvo la query nella variabile sql
        String sql = "SELECT actor_id, first_name, last_name FROM actor";
        //try-catch per gestire eventuale codice che crea eccezione creo la connection il prepared statement e il result set
        try (Connection conn = DbManager.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            //output per far capire cosa stampiamo
            System.out.println("Elenco attori dal database Sakila:");
            //while per ciclare tutti gli attori presenti verificando con next() finchè avremo un successivo 
            while (rs.next()) {
                //prendo i dati e li salvo in variabili
                int id = rs.getInt("actor_id");
                String nome = rs.getString("first_name");
                String cognome = rs.getString("last_name");
                //stampo il tutto utilizzando le variabili
                System.out.println("Id: " + id + ", Nome: " + nome + ", Cognome: " + cognome); 
            }
        //catch per gestile le SQLException
        } catch (SQLException e) {
            //stampa dell'errore
            System.err.println("Errore nella connessione o nella query: " + e.getMessage());
        }
    }
}
//classe DbManager per gestire il collegamento al Db
class DbManager {
    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

