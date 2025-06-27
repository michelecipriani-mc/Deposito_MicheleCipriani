public class ProvaEspressioni {

    public static void main(String[] args) {
        
        //Inizializzo le variabili
        int x = 20, y = 18;
        int time = 20;
        int day = 4;
        String result;
        //eseguo una condizione IF
        if (20 > 18) {
            System.out.println("20 is greater than 18");
        }

        //eseguo una condizione IF con le variabili
        if (x > y) {
            System.out.println("x is greater than y");
        }

        //eseguo una condizione IF ELSE
        if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        //eseguo una condizione con ELSE IF
        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        //eseguo un operatore ternario
        result = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

        //SWITCH
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                break;
        }

    }

}