import java.util.ArrayList;

public class ProvaPolimorfismo {
    ArrayList<Mate> mate = new ArrayList<Mate>();

    void azionatore (Mate objMate) {
        objMate.metodo();
    }

    public static void main(String[] args) {
        Animal myAnimal = new Animal();  
        Animal myPig = new Pig(); 
        Animal myDog = new Dog();  
        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }
}

//classe padre
class Mate {
    public void metodo() {
        //metodo
        System.out.println("Padre");
    }
}

//classe figlio
class Arritmetica extends Mate {
    //metodo sovrascritto
    public void metodo() {
        System.out.println("Figlio di mate");
    }
}

//classe figlio
class Giometria extends Mate {
    //metodo sovrascritto
    public void metodo() {
        System.out.println("Figlio di mate fratello di Arritmetica");
    }
}

class Animal {

    public void animalSound() {
        System.out.println("The animal makes a sound");
    } 
}

class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    } 
}

class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    } 
}

