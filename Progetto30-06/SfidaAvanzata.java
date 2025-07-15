import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class SfidaAvanzata {
    public static void main(String[] args) {
        //inizializzo una variabile per la scelta
        int scelta = 0;
        String userName;
        //dichiarazione libreria
        Library library = new Library();

        //dichiarazione scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScanner2 = new Scanner(System.in);

        //chiedo il nome all'utente
        System.out.println("Inserisci il tuo nome:");
        userName = myScanner2.nextLine();

        //messaggio di benvenuto
        System.out.println("Benvenuto," + userName + " sei nel menu, queste sono le operazioni disponibili!");
        //ciclo che mi permette di farci vedere il menù ed effettuare le varie scelte
        do {
            System.out.println("=========Biblioteca digitale=========\n1 - Inserisci Libro\n2 - Visualizza tutti i libri\n3 - Prendi in prestito libro\n4 - Restituisci un libro\n5 - Cerca libro\n6 - Visualizza libri per utente\n7 - Esci dal menù");
            scelta = myScanner.nextInt();
            //verifichiamo attraverso un while che la scelta sia corretta
            while (scelta <=0 || scelta > 7) {
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
                    library.borrowBook(title, userName);
                    break;
                //caso restituisco un libro
                case 4:
                    //chiedo il titolo
                    System.out.println("Inserisci il titolo del libro che vuoi restituire:");
                    String title1 = myScanner2.nextLine();
                    //invoco il metodo restituisci libro
                    library.returnBook(title1);
                    break;
                //caso ricerca libro attraverso una keyword
                case 5:
                    //chiedo una parola chiave
                    System.out.println("Inserisci una parola chiave (Titolo/Autore):");
                    String keyword = myScanner2.nextLine().toLowerCase();
                    //invoco il metodo cerca libro
                    library.searchBook(keyword);
                    break;
                //caso visualizzo libri per utente
                case 6:
                    System.out.println("Inserisci il nome utente:");
                    String nome = myScanner2.nextLine();
                    User user = library.getOrCreateUser(nome);
                    //verifico se l'utente ha libri in prestito
                    if (user.borrowedBooks.isEmpty()) {
                        System.out.println("L'utente " + nome + " non ha libri in prestito.");
                    } else {
                        System.out.println("Libri in prestito a " + nome + ":");
                        for (Book book : user.borrowedBooks) {
                            book.displayBookInfo();
                        }
                    }
                    break;
                //caso di uscita dal sistema
                case 7:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    break;
            }
        } while (scelta != 7); //verifica della condizione nel while

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
    LocalDate localDate;
    User currentBarrower;

    //costruttore
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.localDate = null;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    
    public User getCurrentBarrower() {
        return currentBarrower;
    }

    //metodo di set currentBarrower custom
    public void currentBarrower(User user) {
        currentBarrower = user;
    }

    //metodo stampa
    void displayBookInfo() {
        System.out.println("Titolo: " + title + " Author: " + author + " Disponibilità: " + (isAvailable ? "Sì" : "No" + " In prestito a: " + currentBarrower.getNome()));
    }

}

//creo la classe Library
class Library {
    //dichiarazione di un array list di book
    ArrayList<Book> books;
    ArrayList<User> users;
    static final int delay = 14; //periodo massimo di prestito

    //costruttore
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    //metodo per registrare un utente
    public User getOrCreateUser(String nomeUtente) {
        //controllo se l'utente esiste
        for (User user : users) {
            if (user.getNome().equalsIgnoreCase(nomeUtente)) {
                return user;
            }
        }
        //altrimenti lo registro
        User newUser = new User(nomeUtente);
        users.add(newUser);
        return newUser;  
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
    public void borrowBook(String title, String nomeUtente) {
        User user = getOrCreateUser(nomeUtente);
        //ciclo gli elementi della libreria
        for (Book book : books) {
            //verifico la presenza del libro
            if (book.getTitle().equalsIgnoreCase(title)) {
                //se disponibile prendo il libro in prestito
                if (book.isAvailable()) {
                    //e se l'utente ha meno di 3 libri in prestito
                    if (user.borrowedBooks.size() < 3) {
                        //rendo il libro non disponibile, aggiungo la data del prestito, associo il libro all'utente, inserisco il libro nella lista dei libri in suo possesso e comunico che il libro è stato preso in prestito
                        book.setAvailable(false);
                        book.setLocalDate(LocalDate.now());
                        book.currentBarrower(user);
                        user.borrowedBooks.add(book);
                        System.out.println("Hai preso in prestito il libro: " + title + " in data: " + book.getLocalDate() + ", ti ricordiamo di restituirlo entro " + delay + " giorni!");
                    }
                } else {
                    //altrimenti ne comunico la non disponibilità
                    System.out.println("Libro non disponibile!È in prestito a " + book.getCurrentBarrower().getNome());
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
                    User barrower = book.getCurrentBarrower();
                    //se il barrower c'è quindi il libro è noleggiato, rimuovo il libro e setto tutti i dati che servono successivamente per ri noleggiarlo
                    if (barrower != null) {
                        barrower.borrowedBooks.remove(book);
                        book.setAvailable(true);
                        //verifico che la data di acquisizione del libro sia presente
                        if (book.getLocalDate() != null) {
                            //verifico la distanza tra il giorno in cui ho preso il libro e il giorno della riconsegna
                            long daysBetween = ChronoUnit.DAYS.between(book.getLocalDate(), LocalDate.now());
                            //se il divario è maggiore di 14gg applico la penale e con la variabile overDay specifico di quanti giorni è in ritardo rispetto alla consegna
                            if (daysBetween > delay) {
                                long overDay = daysBetween - delay;
                                System.out.println("ATTENZIONE! il libro " + title + " è stato restituito con un ritardo di " + overDay + " giorni. Verrà applicata una penale aggiuntiva...");
                            }
                        }
                        //dopodichè resetto gli altri dati e comunico la restituzione del libro
                        book.setLocalDate(null);
                        book.currentBarrower(null);
                        System.out.println("Hai restituito il libro: " + title);
                    }
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

    public void searchBook(String keyword) {
        boolean esito = false;
        //ciclo gli elementi della libreria
        for (Book book : books) {
            //verifico la presenza del libro con la keyword
            if (book.getTitle().toLowerCase().contains(keyword) || book.getAuthor().toLowerCase().contains(keyword)) {
                //lo restituisco attraverso il metodo di stampa
                book.displayBookInfo();
                esito = true;
            }
        }
        //verifico l'esito della verifica
        if (!esito) {
            //stampo se il libro non è presente in libreria
            System.out.println("Nessun libro trovato con la parola chiave: " + keyword);
            
        }
    }

}

//creo la classe user
class User {
    //dichiarazione attributi
    String nome;
    ArrayList<Book> borrowedBooks;

    //costruttore
    public User(String nome) {
        this.nome = nome;
        this.borrowedBooks = new ArrayList<>();
    }

    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 

}
