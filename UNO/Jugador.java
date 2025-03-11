package UNO;

import java.util.ArrayList;

public class Jugador {


        private String nomJugador;
        private ArrayList<Carta> cartas; // no va


       public Jugador (String nom){
             nomJugador = nom;
             cartas = new ArrayList<>();
       }

        public String getNom() {
            return nomJugador;
        }
        public ArrayList<Carta> getCarta() {
            return cartas;
        }


}
