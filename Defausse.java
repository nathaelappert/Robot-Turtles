package com.company;
import java.util.ArrayList;
import java.util.Collections;

// Classe contenant la pile de defausse de chaque joueur
public class Defausse {
    private ArrayList<String> defausse;

    public Defausse() {
        defausse = new ArrayList<String>();
    }
    private boolean add(String carte) {

        return this.defausse.add(carte);
    }
    public void defausser(MainJoueur main,int nombre){ // Defausser un nombre de carte
        if (nombre<=main.Length()){
            for (int i=0; i<nombre;i++){
                defausse.add(main.get(0));
                main.remove(0);
            }
        }
    }
    public void Melanger(){
        Collections.shuffle(defausse);
    } // Melanger la defausse pour la redistribuer

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String carte : defausse) {
            str.append(" | ");
            str.append(carte);
        }
        return str.toString();
    }
}
