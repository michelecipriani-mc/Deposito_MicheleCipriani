public class ProvaEreditarietà {
    public static void main(String[] args) {
        //creo l'oggeto car
        Car myCar = new Car();
        //richiamo il metodo del genitore ereditato
        myCar.honk();
        //stampo il tutto
        System.out.println(myCar.brand + " " + myCar.getModelName());

        Bike obj = new Bike(); //crea oggetto 
        obj.run(); //richiama metodo originario

        Bike2 obj1 = new Bike2(); //crea oggetto 
        obj1.run(); //richiama metodo overraidato
    }
}

//creo una classe Vehicle
class Vehicle {
    //creo l'attibuto protected
    protected String brand = "Ford";  
    //metodo
    public void honk() {                    
        System.out.println("Tuut, tuut!"); 
    }
}

// creo un aclasse car che estende Vehicle
class Car extends Vehicle {
    //creo l'attributo per il figlio
    private String modelName = "Fiat";

    //getter e setter
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
}

//creo la classe veicolo
class Veicolo{ 
    //Creazione di una classe genitore. definire un metodo 
    public void run() {
        System.out.println( "Il veicolo è in marcia" );
    } 
} 

//creo la classe bike
class Bike extends Veicolo{ 
    
}

//creo la classe bike 2 che overraida il metodo
class Bike2 extends Veicolo{ 
    //overraide del metodo run
    public void run() {
        System.out.println( "La bici sta correndo in sicurezza" );
    } //metodo della classe genitore 
} 