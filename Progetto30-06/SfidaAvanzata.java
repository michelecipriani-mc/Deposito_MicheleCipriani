/*Java 2025

Sfida Avanzata: Sistema di Gestione della Biblioteca
Requisiti Base:

1️⃣ Creare una Classe Book con:

String title (Titolo del libro)OK
String author (Autore del libro)OK
boolean isAvailable (Disponibilità del libro)OK
Metodo void displayBookInfo() → Mostra le informazioni del libro.OK

2️⃣ Creare una Classe Library con:

ArrayList<Book> books → Una lista dinamica di libri.OK
Metodo void addBook(Book book) → Aggiunge un libro alla biblioteca.OK
Metodo void displayBooks() → Mostra tutti i libri presenti nella biblioteca.OK
Metodo void borrowBook(String title) → Permette di prendere in prestito un libro
(solo se disponibile).OK

3️⃣ Implementare il Programma Principale per:

Aggiungere libri alla biblioteca.
Mostrare tutti i libri disponibili.
Permettere agli utenti di prendere in prestito un libro. 

Se hai completato il progetto in anticipo, prova a implementare queste funzionalità
avanzate:

🔹 4️⃣ Restituzione di un Libro (returnBook(String title))

Implementa un metodo che permette agli utenti di restituire un libro e segnarlo
come disponibile.

🔹 5️⃣ Ricerca di un Libro (searchBook(String keyword))

Permetti agli utenti di cercare un libro per titolo o autore e visualizzare i
risultati.

🔹 6️⃣ Gestione di Più Utenti (User Class - Sistema di Prestiti)

Crea una classe User con attributi come String name e una ArrayList<Book> per
memorizzare i libri presi in prestito.

Modifica il sistema in modo che ogni utente possa prendere in prestito un massimo
di 3 libri alla volta.

🔹 7️⃣ Sistema di Scadenza e Penalità

Implementa un meccanismo che registra la data di prestito e impone una penale se il
libro non viene restituito entro un certo periodo (es. 14 giorni).

Extra Bonus:


Aggiungi un sistema di menu interattivo in main() per permettere
agli utenti di navigare nel sistema con opzioni come:

Aggiungere un nuovo libro

Visualizzare tutti i libri disponibili

Cercare un libro

Prendere in prestito un libro

Restituire un libro

Visualizzare i libri presi in prestito da un utente


*/

import java.util.ArrayList;
import java.util.Scanner;

public class SfidaAvanzata {
    public static void main(String[] args) {
        //inizializzo una variabile per la scelta
        int scelta = 0;
        //dichiarazione libreria
        Library library = new Library();
        //dichiarazione scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScanner2 = new Scanner(System.in);

        //messaggio di benvenuto
        System.out.println("Benvenuto, sei nel menu, queste sono le operazioni disponibili!");
        //ciclo che mi permette di farci vedere il menù ed effettuare le varie scelte
        do {
            System.out.println("=========Biblioteca digitale=========\n1 - Inserisci Libro\n2 - Visualizza tutti i libri\n3 - Prendi in prestito libro\n4 - Restituisci un libro\n5 - Esci dal menu");
            scelta = myScanner.nextInt();
            //verifichiamo attraverso un while che la scelta sia corretta
            while (scelta <=0 && scelta > 5) {
                System.out.println("Errore: Inserisci un numero valido per il menu: ");
                scelta = myScanner.nextInt();
            }

            //switch per permettermi di gestire cosa fa il menù
            switch (scelta) {
                //caso inserisci libro
                case 1:
                    //chiedo il titolo
                    System.out.println("Inserisci il titolo del libro:");
                    String titolo = myScanner2.nextLine();
                    //chiedo il titolo
                    System.out.println("Inserisci l'autore del libro:");
                    String autore = myScanner2.nextLine();
                    library.addBook(new Book(titolo, autore));
                    break;
                //caso visualizza libreria
                case 2:
                    library.displayBook();
                    break;
                //caso prendere in prestito un libro
                case 3:
                    //chiedo il titolo
                    System.out.println("Inserisci il titolo del libro che vuoi prendere in prestito:");
                    String title = myScanner2.nextLine();
                    //invoco il metodo prendi in prestito libro
                    library.borrowBook(title);
                    break;
                //caso restituisco un libro
                case 4:
                    //chiedo il titolo
                    System.out.println("Inserisci il titolo del libro che vuoi restituire:");
                    String title1 = myScanner2.nextLine();
                    //invoco il metodo restituisci libro
                    library.returnBook(title1);
                    break;
                //caso di uscita dal sistema
                case 5:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    break;
            }
        } while (scelta != 5); //verifica della condizione nel while

        //chiusura scanner
        myScanner2.close();
        myScanner.close();
    }
}

//creo la classe book
class Book {
    //dichiarazione attributi classe book
    String title;
    String author;
    boolean isAvailable;

    //costruttore
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    //getter e setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //metodo stampa
    void displayBookInfo() {
        System.out.println("Titolo: " + title + " Author: " + author + " Disponibilità: " + (isAvailable ? "Sì" : "No"));
    }

}

class Library {
    //dichiarazione di un array list di book
    ArrayList<Book> books;

    //costruttore
    public Library() {
        books = new ArrayList<>();
    }

    //metodo per aggiungere un libro in libreria
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Libro aggiunto: " + book.getTitle());
    }

    //metodo per visualizzare tutti i libri della libreria
    public void displayBook() {
        //controllo se la libreia è vuota
        if (books.isEmpty()) {
            System.out.println("Libreria vuota!");
        } else {
            //altrimenti stampo tutti i libri al suo interno
            for (Book book : books) {
                book.displayBookInfo();
            }
        }
    }

    //metodo che mi permette di prendere in prestito il libro
    public void borrowBook(String title) {
        //ciclo gli elementi della libreria
        for (Book book : books) {
            //verifico la presenza del libro
            if (book.getTitle().equalsIgnoreCase(title)) {
                //se disponibile prendo il libro in prestito
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Hai preso in prestito il libro: " + title);
                } else {
                    //altrimenti ne comunico la non disponibilità
                    System.out.println("Libro non disponibile!");
                }
                //interrompo il ciclo se trovo il libro che sto cercando
                return;
            }
        }
        //stampo se il libro non è presente in libreria
        System.out.println("Il libro " + title + " non è presente in libreria...");
    }

    //metodo che mi permette di restituire un libro in prestito
    public void returnBook(String title) {
        //ciclo gli elementi della libreria
        for (Book book : books) {
            //verifico la presenza del libro
            if (book.getTitle().equalsIgnoreCase(title)) {
                //lo restituisco
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Hai restituito il libro: " + title);
                } else {
                    //altrimenti ne comunico la disponibilità
                    System.out.println("Libro disponibile, non era in prestito!");
                }
                //interrompo il ciclo se trovo il libro che sto cercando
                return;
            }
        }
        //stampo se il libro non è presente in libreria
        System.out.println("Il libro " + title + " non è presente in libreria...");
    }

}
