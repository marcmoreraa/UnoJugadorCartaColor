package uno.logica;

import java.util.Stack;

public class Pilo {
    Stack<Carta> cartes= new Stack<Carta>();

    public Stack<Carta> getCartes(){
        return cartes;
    }

    public Carta agafarCarta(){
        return cartes.pop();
    }

    public Carta consultarCarta(){
        return cartes.peek();
    }

    public void  addCarta (Carta carta){
        cartes.add(carta);
    }

}
