public class ProvaAstrazione {
    public static void main(String[] args) {
        //creo un oggetto pig e un oggeto dog
        Animal myPig = new Pig1(); 
        Animal myDog = new Dog1();  
        //ne stampo il suo suono
        myPig.animalSound();
        myDog.animalSound();
    }
}
//creo un aclasse astratta
abstract class Animal {
    //metodo astratto
    public abstract void animalSound();
    //metodo reale
    public void sleep() {
        System.out.println("Zzz");
    } 
}
//creo una classe che estende la classe astratta
class Pig1 extends Animal {
    //specializzazione della classe astratta
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    } 
}
//creo una classe che estende la classe astratta
class Dog1 extends Animal {
    //specializzazione della classe astratta
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    } 
}


