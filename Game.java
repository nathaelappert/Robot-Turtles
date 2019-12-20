package com.company;

import java.util.*;

public class Game{
    public static Scanner scanner = new Scanner(System.in);

    private Joueur Tourdujoueur;
    private JeuxCartes Paquetdujoueur;
    private Plateau plateau;
    private Defausse defausse;
    private int nbrjoueurs;
    private List<ArrayDeque> ListeProg;
    private List<Joueur> Listejoueurs = new ArrayList<Joueur>();
    private List<JeuxCartes> Listepaquets = new ArrayList<JeuxCartes>();


    public void initialisationJeu() {

        System.out.print("Bienvenue dans Robot Turtles !\nCommencez par choisir un nombre de Joueurs qui vont participé à cette partie : ");
        nbrjoueurs = scanner.nextInt();
        while(nbrjoueurs != 2 && nbrjoueurs != 3 && nbrjoueurs != 4){
            System.out.println("le nombre de joueurs entrée n'est pas valide. Il faut un nombre de joueurs entre 2 et 4\nRentrez un nombre de joueurs : ");
            nbrjoueurs = scanner.nextInt();
        }
        System.out.println("Création du jeu avec "+nbrjoueurs+ " joueurs");
        Joueur joueur1 = new Joueur(new int[2], 1,'S');
        Listejoueurs.add(joueur1);
        Joueur joueur2 = new Joueur(new int[2], 2,'S');
        Listejoueurs.add(joueur2);
        joueur1.PositionInitiale(nbrjoueurs,1);
        joueur2.PositionInitiale(nbrjoueurs,2);
        JeuxCartes paquet1 = new JeuxCartes(1);
        paquet1.CreaPaquet();
        paquet1.Melanger();
        Listepaquets.add(paquet1);
        JeuxCartes paquet2 = new JeuxCartes(2);
        paquet2.CreaPaquet();
        paquet2.Melanger();
        Listepaquets.add(paquet2);
        Joueur joueur3 = null;
        Joueur joueur4 = null;
        plateau= new Plateau();
        defausse = new Defausse();
        plateau.initialisation(nbrjoueurs);
        plateau.positionJoueur(joueur1.PositionJoueur[0],joueur1.PositionJoueur[1],1);
        plateau.positionJoueur(joueur2.PositionJoueur[0],joueur2.PositionJoueur[1],2);
        switch (nbrjoueurs){
            case 4 :
                joueur4 = new Joueur(new int[2], 4,'S');
                Listejoueurs.add(joueur4);
                joueur4.PositionInitiale(nbrjoueurs,4);
                plateau.positionJoueur(joueur4.PositionJoueur[0],joueur4.PositionJoueur[1],4);
                JeuxCartes paquet4 = new JeuxCartes(3);
                paquet4.CreaPaquet();
                paquet4.Melanger();
                Listepaquets.add(paquet4);
            case 3 : joueur3=new Joueur(new int[2], 3,'S');
                Listejoueurs.add(joueur3);
                joueur3.PositionInitiale(nbrjoueurs,3);
                plateau.positionJoueur(joueur3.PositionJoueur[0],joueur3.PositionJoueur[1],3);
                JeuxCartes paquet3 = new JeuxCartes(4);
                paquet3.CreaPaquet();
                paquet3.Melanger();
                Listepaquets.add(paquet3);
                break;
        }
        ListeProg = new ArrayList<ArrayDeque>();
        Plateau.afficherPlateau();
        Tourdujoueur = joueur1;
        Paquetdujoueur= paquet1;


    }
    public void Jouer(){
        do{
            int choix=0;
            do{
                System.out.println("Au tour du joueur "+Tourdujoueur.getNum());
                Plateau.afficherPlateau();
                System.out.println("Entrez un choix\n"+"1. Compléter le programmer\n"+"2. Construire un mur\n"+"3.Executer le programme");
                choix= scanner.nextInt();
            }while (choix!=1 && choix!=2 && choix!=3);
            switch(choix){
                case 1:
                    CompleterProg();
                    break;
                case 2:break;
                case 3:break;
            }
            int defausser;
            System.out.println("Combien voulez vous défausser de cartes ?: ");
            defausser = scanner.nextInt();
            if (defausser>0){

            }
            prochainTour();
        }while (!FinduJeu(nbrjoueurs));
    }

    public  boolean FinduJeu(int nombreJoueur){
        switch (nombreJoueur){
            case 2:
                if (Tourdujoueur.PositionJoueur[0]==7 && Tourdujoueur.PositionJoueur[1]==3){
                    return true;
                }
            case 3:
                if (Tourdujoueur.PositionJoueur[0]==7 && (Tourdujoueur.PositionJoueur[1]==0 || Tourdujoueur.PositionJoueur[1]==3 || Tourdujoueur.PositionJoueur[1]==6 )){
                    return true;
                }
            case 4:
                if (Tourdujoueur.PositionJoueur[0]==7 && (Tourdujoueur.PositionJoueur[1]==1 || Tourdujoueur.PositionJoueur[1]==6)){
                    return true;
                }
        }
        return false;
    }

    public void Test(){
        System.out.println("Num du joueur: "+Tourdujoueur.getNum());
        System.out.println("Num du joueur: "+Paquetdujoueur.toString());

    }

    public void prochainTour() {
        int num = Tourdujoueur.getNum();
        if (num < nbrjoueurs) {
            num++;
        } else {
            num = 1;
        }
        Tourdujoueur = getJoueur(num);
        Paquetdujoueur= getPaquet(num);
    }
    public Joueur getJoueur(int numJoueur) {
        Iterator<Joueur> iterator = Listejoueurs.iterator();
        while (iterator.hasNext()) {
            Joueur joueur = iterator.next();
            if (joueur.getNum() == numJoueur) {
                return joueur;
            }
        }
        return null;
    }
    public JeuxCartes getPaquet(int numJoueur) {
        Iterator<JeuxCartes> iterator = Listepaquets.iterator();
        while (iterator.hasNext()) {
            JeuxCartes paquet=iterator.next();
            if (paquet.getNum() == numJoueur) {
                return paquet;
            }
        }
        return null;
    }
    public void CompleterProg(){
        int nombreCarte;
        do{
            System.out.println("Entrez le nombre de cartes que vous voulez jouer: ");
            nombreCarte = scanner.nextInt();
        }while(nombreCarte>5 || nombreCarte<1);
        ArrayDeque<String> programme = new ArrayDeque<>();
        String choix="B";
        do {
            do {
                //System.out.println("Position ligne: "+position[0] +" colonne: "+position[1]);
                //System.out.println("Direction: "+direction);
                System.out.println("“B” pour avancer");
                System.out.println("“J” pour faire un quart de tour vers la gauche");
                System.out.println("“V” pour faire un quart de tour vers la droite");
                choix = scanner.nextLine();
                if (!choix.equals("B") && !choix.equals("J") && !choix.equals("V")) {
                    System.out.println("<!> La saisie est incorrect ressayez <!>");
                }
            }while(!choix.equals("B") && !choix.equals("J") && !choix.equals("V"));
            programme.add(choix);
        }while( programme.size()!=nombreCarte);
        ListeProg.set(Tourdujoueur.getNum(), programme);
    }
    
    public static boolean ispathright(String joueur){
        switch (nbrjoueurs){
            case 2 :
                break;
            case 3 :
                break;
            case 4:
                break;
        }
        joueur.positionjoueur[];
        Joyau.getposition();
    }
   

}
