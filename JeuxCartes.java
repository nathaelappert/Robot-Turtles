package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class JeuxCartes{
    
    private ArrayList<String> Paquet;
    private int Numeropaquet;

    public JeuxCartes(int nump) {
        Paquet = new ArrayList<String>();
        this.Numeropaquet=nump;
    }

    private boolean addCarte(String carte) {

        return this.Paquet.add(carte);
    }

    public boolean isEmpty() {
        return this.Paquet.isEmpty();
    }


    public void CreaPaquet() {
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
    }
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
        /*
        JeuxCartes t = new JeuxCartes();
        t.CreaPaquet();
        t.Melanger();
        System.out.println("Le jeu de carte est "+t.toString());
        System.out.println("Le jeu de carte est "+t.Length());
        MainJoueur main_joueur_1= new MainJoueur();
        main_joueur_1.pioche(t,5);
        System.out.println("Main: "+main_joueur_1.toString());
        System.out.println("Taille "+t.Length());
        Defausse d = new Defausse();
        d.defausser(main_joueur_1,3);
        System.out.println("Main: "+main_joueur_1.toString());
        System.out.println("Défausse: "+d.toString());


        JeuxCartes t2 = new JeuxCartes();
        t2.CreaPaquet();
        t2.Melanger();
        System.out.println("Le jeu de carte est "+t2.toString());
        MainJoueur main_joueur_2= new MainJoueur();
        System.out.println("Main: "+main_joueur_2.toString());
        System.out.println("Taille "+t2.Length());
        Defausse defausse1 = new Defausse();
        defausse1.defausser(1,t2);

*/

    }
    
}
