package uno.logica;

import java.util.ArrayList;

public class Jugador {


    private String nomJugador;
    private ArrayList<Carta> cartes; //


    public Jugador (String nom){
        nomJugador = nom;
        cartes = new ArrayList<>();
    }

    public String getNom() {
        return nomJugador;
    }
    public ArrayList<Carta> getCartes() {
        return cartes;
    }
    public void  addCarta (Carta carta){
        cartes.add(carta);
    }

    public void tirarCartes (Pilo pilo, Carta carta){
        pilo.getCartes().push(carta);
        cartes.remove(carta);
    }

}