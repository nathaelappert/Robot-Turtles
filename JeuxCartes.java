package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class JeuxCartes{
    
    private ArrayList<String> Paquet;
    private int Numeropaquet;

    public JeuxCartes(int nump) { // constructeur
        Paquet = new ArrayList<String>(); // Composé d'une liste de String
        this.Numeropaquet=nump; // Le numéro de paquet en fonction du numéro du joueur
    }

    private boolean addCarte(String carte) {

        return this.Paquet.add(carte);
    }

    public boolean isEmpty() {
        return this.Paquet.isEmpty();
    }


    public void CreaPaquet() { // On créer le paquet en multipliant le nombre de carte par son nom
        String Type[] = {"Bleue", "Jaune", "Violette", "Laser"};
        int Nombre[] = {18, 8, 8, 3};
        for (int i = 0; i < Type.length; i++) {
            for (int n = 0; n < Nombre[i]; n++) {
                addCarte((Type[i]));
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String carte : Paquet) {
            str.append(" | ");
            str.append(carte);
        }
        return str.toString();
    }
    public void Melanger(){
        Collections.shuffle(Paquet);
    } // On mélange aléatoirement grâce à la fonction shuffle
    public int Length(){
        int NombreCarte=0;
        for (String carte : Paquet) {
            NombreCarte+=1;
        }
        return NombreCarte;
    }
    public String get(int i) {
        return Paquet.get(i);
    }
    
    public void remove(int i){
        Paquet.remove(i);
    }
    public int getNum() {
        return Numeropaquet;
    }

    public static void main(String[] args) {

    }
    
}
