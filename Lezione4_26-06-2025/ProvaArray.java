public class ProvaArray {
    public static void main(String[] args) {

        //dichiarazione di array vuoto
        int[] numeri = new int[5];

        //inizializzazione di un array
        int[] valori = {1,2,3,4,5};

        //dichiarazione di un array multidimensionale vuoto
        int[][] matrice = new int[3][3]; //prima parentesi righe seconda parentesi colonne
        //inizializzazione di un rray multidimensionale
        int[][] matricePredefinita = { //prima parentesi righe seconda parentesi colonne
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        //inizializzazione variabile
        int valore = 1;

        //stampa array
        System.out.println("Primo valore: " + valori[0]);
        //stampa array multidimensionale
        System.out.println("Elemento centrale: " + matricePredefinita[1][1]);

        //riempire l'array vuoto con il for
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = i + 1;
            // System.out.println("Indice " + i + " dell'array: " + numeri[i]); // da non fare -sicuro
        }

        //Stampa dell'array con il for
        for (int i = 0; i < numeri.length; i++) {
            System.out.println("Indice " + i + " dell'array: " + numeri[i]);
        }

        //riempimento array multidimensionale
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                matrice[i][j] = valore++;
            }
        }

        //stampa array multidimensionale
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                System.out.println(matrice[i][j] + "\t");
            }
            System.out.println(); //riga di formattazione della matrice
        }

    }

}
