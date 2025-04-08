package uno.logica;

public class Carta {
    //Enumeració
    public enum Color{
        Groc,
        Vermell,
        Blau,
        Verd
        

    }

    //Variables
    private int numeroCarta;
    private Color colorCarta;


    //Constructor
    public Carta (int numCarta , Color colCarta){
        numeroCarta = numCarta;
        colorCarta = colCarta;
    }

    // Agafar numero i color
    public int getNumero() {

        return numeroCarta;
    }

    public Color getColor() {

        return colorCarta;
    }


}


