package com.company;

public class Joyau { // Une classe que nous avons finalement pas utilisé pour simplifier le code
    private int[] position = new int[2];
    private String couleur;

    public Joyau(String couleurJoyau, int ligne, int colonne) {
        this.couleur = couleurJoyau;
        this.position[0] = ligne;
        this.position[1] = colonne;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public int[] getPosition() {
        return this.position;
    }
    public static void main(String[] args) {

    }

}