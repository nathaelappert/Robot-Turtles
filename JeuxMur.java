package com.company;

import java.util.ArrayList;

public class JeuxMur {
    private ArrayList<Mur> MurListe;
    private int Numero;


    public JeuxMur(int num) {
        MurListe = new ArrayList<Mur>();
        for (int i=0;i<3;i++){ // On ajoute 3 murs de Pierre pour le joueur
            MurListe.add(new Mur(false,"Pierre"));
        }
        for (int i=0;i<2;i++){ // et 2 murs de Glace
            MurListe.add(new Mur(true,"Glace"));
        }
        this.Numero=num;
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Mur carte : MurListe) {
            str.append(" | ");
            str.append(carte.getType());
        }
        return str.toString();
    }
    public int getNum() {
        return Numero;
    }
    public void remove(int i){
        MurListe.remove(i);
    }
    public int Length(){
        int NombreCarte=0;
        for (Mur mur : MurListe) {
            NombreCarte+=1;
        }
        return NombreCarte;
    }
    public String get(int i) {
        return MurListe.get(i).getType();
    }





/*
    public static void main(String[] args) {
        ListeMur m = new ListeMur(1);
        System.out.println("Liste de Mur "+m.toString());
    }

 */

}
