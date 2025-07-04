package ProvaInterfaccia;
//creo una classe che implementa l'interfaccia ed è obbligata a richiamare i metodi dell'interfaccia e ad implementarli
public class Pig implements AnimalInterface{

    @Override //implemento il metodo sound dell'interfaccia
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }

    @Override //implemento il metodo sleep dell'interfaccia
    public void sleep() {
        System.out.println("Zzz");
    }
    
}
