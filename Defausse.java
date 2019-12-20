package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class Defausse {
    private ArrayList<String> defausse;

    public Defausse() {
        defausse = new ArrayList<String>();
    }
    private boolean add(String carte) {

        return this.defausse.add(carte);
    }
    public void defausser(MainJoueur main,int nombre){
        if (nombre<=main.Length()){
            for (int i=0; i<nombre;i++){
                defausse.add(main.get(0));
                main.remove(0);
            }
        }
    }
    public void Melanger(){
        Collections.shuffle(defausse);
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String carte : defausse) {
            str.append(" | ");
            str.append(carte);
        }
        return str.toString();
    }
}
