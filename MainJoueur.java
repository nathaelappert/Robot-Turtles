package com.company;

import java.util.ArrayList;

public class MainJoueur {
    private ArrayList<String> mainjoueur;


    public MainJoueur() {
        mainjoueur = new ArrayList<String>();
    }

    public void pioche(JeuxCartes paquet,int piocher) {
        if (piocher <= paquet.Length()){
            for ( int i=0; i<piocher;i++){
                mainjoueur.add(paquet.get(0));
                paquet.remove(0);
            }
        }
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String carte : mainjoueur) {
            str.append(" | ");
            str.append(carte);
        }
        return str.toString();
    }

    public String get(int i) {
        return mainjoueur.get(i);
    }
    public int Length(){
        int NombreCarte=0;
        for (String carte : mainjoueur) {
            NombreCarte+=1;
        }
        return NombreCarte;
    }

    public void remove(int i) {
        mainjoueur.remove(i);
    }
}

