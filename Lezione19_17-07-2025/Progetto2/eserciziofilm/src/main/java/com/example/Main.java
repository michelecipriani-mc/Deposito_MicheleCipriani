package com.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; // sostituire con il nome del DB
        String user = "root"; // utente del DB
        String password = ""; // password del DB
        Scanner myScanner = new Scanner(System.in); //dichiaro lo scanner
        //try per gestire l'eventuale codice che potrebbe creare eccezione
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            //se la connessione va a buon fine
            System.out.println("Connessione riuscita");
            int risposta; // dichiaro la variabile di risposta
            //Ciclo do-while per gestire il menù
            do {
                //menù con le varie scelte
                System.out.println("======= MENù =======");
                System.out.println("1 - Lista 10 film più noleggiati");
                System.out.println("2 - Ordina film dal meno noleggiato");
                System.out.println("3 - ESCI");
                //valorizzo la variabile con la scelta dell'utente
                risposta = myScanner.nextInt();
                //switch per la gestione della scelta
                switch (risposta) {
                    //caso 1 film più noleggiati
                    case 1:
                        //indico cosa sto stampando
                        System.out.println("===FILM PIù NOLEGGIATI===");
                        //creo lo statement
                        Statement stmt1 = conn.createStatement();
                        //creo il result set con la query di riferimento
                        ResultSet rs1 = stmt1.executeQuery("SELECT film.title, COUNT(*) AS num_rentals FROM film INNER JOIN inventory ON film.film_id = inventory.film_id INNER JOIN rental ON inventory.inventory_id = rental.inventory_id GROUP BY film.title ORDER BY num_rentals DESC LIMIT 10;");
                        //successivamente con il while ciclo finchè rs1 ha un valore successivo
                        while (rs1.next()) {
                            //stampo film per film
                            System.out.println("Film: " + rs1.getString("title"));
                        }
                        break;
                    //caso 2 ordinare il film dal meno noleggiato
                    case 2:
                        //indico cosa sto stampando
                        System.out.println("===FILM MENO NOLEGGIATI===");
                        //creo lo statement
                        Statement stmt2 = conn.createStatement();
                        //creo il result set con la query di riferimento
                        ResultSet rs2 = stmt2.executeQuery("SELECT film.title, COUNT(rental.rental_id) AS num_rentals FROM film JOIN inventory ON film.film_id = inventory.film_id JOIN rental ON inventory.inventory_id = rental.inventory_id GROUP BY film.title ORDER BY num_rentals ASC LIMIT 10;");
                        //successivamente con il while ciclo finchè rs2 ha un valore successivo
                        while (rs2.next()) {
                            //stampo film per film con il numero di volte noleggiato
                            System.out.println("Film: " + rs2.getString("title") + ", Noleggiato: " + rs2.getString("num_rentals"));
                        }
                        break;
                    //caso 3 uscita o risposta errata
                    default: 
                        if (risposta == 3) {
                            System.out.println("Programma terminato!");
                        } else {
                            System.out.println("Scelta errata...");
                        }
                        break;
                }
            } while (risposta != 3); //verifica la condizione
        //catch per la gestione dell'eccezione
        } catch (SQLException e) {
            //in caso di connessione errata
            System.out.println("Errore nella connessione");
            //stampo l'errore
            e.printStackTrace();
        }
        //chiusura dello scanner
        myScanner.close();
    }
}