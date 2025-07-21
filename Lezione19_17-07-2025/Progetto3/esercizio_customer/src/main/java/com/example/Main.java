package com.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; // sostituire con il nome del DB
        String user = "root";       // utente del DB
        String password = "";       // password del DB
        //dichiaro lo scanner
        Scanner myScanner = new Scanner(System.in);
        //try-catch per la gestione delle eccezioni
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            //connessione riuscita
            System.out.println("Connessione riuscita");
            //richiamo la funzione menù e passo lo scanner e la Connectiom
            menù(myScanner, conn);

        } catch (SQLException e) {
            //connessione non riuscita
            System.out.println("Errore nella connessione");
            //stampa dell'errore
            e.printStackTrace();
        }
        //chiusura dello scanner
        myScanner.close();
    }


    //funzione per la ricerca dei clienti con la lettera A
    public static void clientiConLetteraA(Connection conn) throws SQLException {
        //salvo la query in una variabile di tipo stringa
        String sql = "SELECT first_name, last_name FROM customer WHERE first_name LIKE 'A%'";
        //utilizzo un try-catch per la gestione delle eccezioni creo lo statement e il resultset
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            //output guida
            System.out.println("Nome e Cognome dei clienti con il Nome che inizia per A:");
            //stampa di tutti i dati reperiti dal DB con un ciclo while che verifica la presenza del successivo
            while (rs.next()) {
               System.out.println(rs.getString("first_name") + " " + rs.getString("last_name")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //funzione per la ricerca dei clienti per ogni città
    public static void clientiPerCittà(Connection conn) throws SQLException {
        //salvo la query in una variabile di tipo stringa
        String sql = "SELECT ci.city, COUNT(c.customer_id) AS customer_count\n" + //
                        "FROM customer c\n" + //
                        "JOIN address a ON c.address_id = a.address_id\n" + //
                        "JOIN city ci ON a.city_id = ci.city_id\n" + //
                        "GROUP BY ci.city\n" + //
                        "ORDER BY customer_count DESC";
        //utilizzo un try-catch per la gestione delle eccezioni creo lo statement e il resultset
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            //output guida
            System.out.println("Numero clienti registrati per Città:");
            //stampa di tutti i dati reperiti dal DB con un ciclo while che verifica la presenza del successivo
            while (rs.next()) {
               System.out.println("Città: " + rs.getString("city") + " - Utenti: " + rs.getString("customer_count")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //funzione per la ricerca dei 5 clienti più recenti
    public static void clientiRecenti(Connection conn) throws SQLException {
        //salvo la query in una variabile di tipo stringa
        String sql = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date DESC LIMIT 5";
        //utilizzo un try-catch per la gestione delle eccezioni creo lo statement e il resultset
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            //output guida
            System.out.println("5 Clienti più recenti:");
            //stampa di tutti i dati reperiti dal DB con un ciclo while che verifica la presenza del successivo
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " - " + rs.getString("create_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //funzione per ordinare i clienti in ordine DESC
    public static void ordineClienti(Connection conn) throws SQLException {
        //salvo la query in una variabile di tipo stringa
        String sql = "SELECT first_name, last_name FROM customer ORDER BY create_date ASC";
        //utilizzo un try-catch per la gestione delle eccezioni creo lo statement e il resultset
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            //output guida
            System.out.println("Anzianità Clienti dal più vecchio al più recente:");
            //stampa di tutti i dati reperiti dal DB con un ciclo while che verifica la presenza del successivo
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //funzione menù
    public static void menù(Scanner myScanner, Connection conn) {
        try {
            //inizializzo la variabile risposta
            int risposta;
            do {
                //menù con le varie scelte
                System.out.println("======= MENù =======");
                System.out.println("1 - Lista clienti con nome che inizia per lettera A");
                System.out.println("2 - Clienti registrati per Città");
                System.out.println("3 - Mostra i 5 clienti più recenti");
                System.out.println("4 - Ordina dal più vecchio tutti i clienti");
                System.out.println("5 - ESCI");
                //valorizzo la variabile con la scelta dell'utente
                risposta = myScanner.nextInt();
                //switch per la gestione della scelta
                switch (risposta) {
                    //caso 1 clienti con lettera A
                    case 1:
                        clientiConLetteraA(conn);
                        break;
                    //caso 2 per ogni città
                    case 2:
                        clientiPerCittà(conn);
                        break;
                    //caso 3 5 clienti più recenti
                    case 3:
                        clientiRecenti(conn);
                        break;
                    //caso 4 ordinamento dei clienti dal più vecchio al più recente
                    case 4:
                        ordineClienti(conn);
                        break;
                    //caso 3 uscita o risposta errata
                    default: 
                        if (risposta == 5) {
                            System.out.println("Programma terminato!");
                        } else {
                            System.out.println("Scelta errata...");
                        }
                        break;
                }
            } while (risposta != 5); //verifica la condizione
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}