package uno.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Mazo {
    Stack<Carta> cartes= new Stack<Carta>();

    public Mazo() {
        for (Carta.Color color : Carta.Color.values()){
            cartes.push(new Carta(0,color));
            for (int i = 1; i<=9; i++){
                cartes.push(new Carta(i,color));
                cartes.push(new Carta(i,color));
            }
        }

    }

    public ArrayList<Carta> getCartes(){
        return new ArrayList<>(cartes);
    }

    public Carta agafarCarta(){
        return cartes.pop();
    }

    public void barrejar(){
        Collections.shuffle(cartes);
    }

    public void reiniciar(Pilo pilo){
        Carta ultimaCarta;
        ultimaCarta = pilo.agafarCarta();

        while (!pilo.getCartes().empty()){
            cartes.push(pilo.agafarCarta());
        }

        pilo.addCarta(ultimaCarta);

    }

}
