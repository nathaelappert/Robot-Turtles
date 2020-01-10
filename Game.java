package com.company;

import java.util.*;

public class Game{
    public static Scanner scanner = new Scanner(System.in);

    private Joueur Tourdujoueur;
    private JeuxCartes Paquetdujoueur;
    private MainJoueur MainDuJoueur;
    private Plateau plateau;
    private Defausse defausse;
    private int nbrjoueurs;
    private List<ArrayDeque> ListeProg;
    private List<Joueur> Listejoueurs = new ArrayList<>();
    private List<JeuxCartes> Listepaquets = new ArrayList<>();
    private List<MainJoueur> ListeMain = new ArrayList<>();


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
        MainJoueur main_joueur1 = new MainJoueur(1);
        main_joueur1.pioche(paquet1,5);
        Listepaquets.add(paquet1);
        ListeMain.add(main_joueur1);
        JeuxCartes paquet2 = new JeuxCartes(2);
        paquet2.CreaPaquet();
        paquet2.Melanger();
        MainJoueur main_joueur2 = new MainJoueur(2);
        main_joueur2.pioche(paquet2,5);
        Listepaquets.add(paquet2);
        ListeMain.add(main_joueur2);
        Joueur joueur3 = null;
        JeuxCartes paquet3 = null;
        MainJoueur main_joueur3 = null;
        plateau= new Plateau();
        defausse = new Defausse();
        plateau.initialisation(nbrjoueurs);
        plateau.deplacementJoueur(joueur1.PositionJoueur[0],joueur1.PositionJoueur[1],1);
        plateau.deplacementJoueur(joueur2.PositionJoueur[0],joueur2.PositionJoueur[1],2);
        switch (nbrjoueurs){
            case 3 :
                joueur3=new Joueur(new int[2], 3,'S');
                Listejoueurs.add(joueur3);
                joueur3.PositionInitiale(nbrjoueurs,3);
                plateau.deplacementJoueur(joueur3.PositionJoueur[0],joueur3.PositionJoueur[1],3);
                paquet3 = new JeuxCartes(3);
                paquet3.CreaPaquet();
                paquet3.Melanger();
                main_joueur3 = new MainJoueur(3);
                main_joueur3.pioche(paquet3,5);
                Listepaquets.add(paquet3);
                ListeMain.add(main_joueur3);
                break;
            case 4 :
                joueur3=new Joueur(new int[2], 3,'S');
                Listejoueurs.add(joueur3);
                joueur3.PositionInitiale(nbrjoueurs,3);
                plateau.deplacementJoueur(joueur3.PositionJoueur[0],joueur3.PositionJoueur[1],3);
                paquet3 = new JeuxCartes(3);
                paquet3.CreaPaquet();
                paquet3.Melanger();
                main_joueur3 = new MainJoueur(3);
                main_joueur3.pioche(paquet3,5);
                Listepaquets.add(paquet3);
                ListeMain.add(main_joueur3);
                Joueur joueur4 = new Joueur(new int[2], 4,'S');
                Listejoueurs.add(joueur4);
                joueur4.PositionInitiale(nbrjoueurs,4);
                plateau.deplacementJoueur(joueur4.PositionJoueur[0],joueur4.PositionJoueur[1],4);
                JeuxCartes paquet4 = new JeuxCartes(4);
                paquet4.CreaPaquet();
                paquet4.Melanger();
                MainJoueur main_joueur4 = new MainJoueur(4);
                main_joueur4.pioche(paquet4,5);
                Listepaquets.add(paquet4);
                ListeMain.add(main_joueur4);
                break;
        }
        ListeProg = new ArrayList<ArrayDeque>();
        ListeProg.add(null);
        for (int i = 0; i < nbrjoueurs; i++){
            ListeProg.add(new ArrayDeque());
        }
        Plateau.afficherPlateau();
        Tourdujoueur = joueur1;
        Paquetdujoueur= paquet1;
        MainDuJoueur= main_joueur1;



    }
    public void Jouer(){
        while (!FinduJeu(nbrjoueurs)){
            int choix=0;
            do{
                System.out.println("Au tour du joueur "+Tourdujoueur.getNum());
                System.out.println("Position ligne: "+Tourdujoueur.PositionJoueur[0] +" colonne: "+Tourdujoueur.PositionJoueur[1]);
                System.out.println("Direction: "+Tourdujoueur.DirectionJoueur);
                Plateau.afficherPlateau();
                System.out.println("Entrez un choix\n"+"1. Compléter le programmer\n"+"2. Construire un mur\n"+"3. Executer le programme");
                choix= scanner.nextInt();
            }while (choix!=1 && choix!=2 && choix!=3);
            scanner.nextLine();
            switch(choix){
                case 1:
                    System.out.println("Votre Main: "+MainDuJoueur.toString());
                    CompleterProg();
                    break;
                case 2:
                    System.out.println("Voulez vous placer un mur de Glace (entrez G) ou de Pierre (entrez P): ");
                    char mur=scanner.next().charAt(0);
                    System.out.println("A quelle ligne (0-7) ?: ");
                    int ligne=scanner.nextInt();
                    System.out.println("A quelle colonne (0-7) ?: ");
                    int colonne=scanner.nextInt();
                    plateau.PlacerMur(ligne,colonne,mur);
                    break;
                case 3:
                    ExecuterProg(ListeProg.get(Tourdujoueur.getNum()));
                    break;
            }
            System.out.println("Votre Main: "+MainDuJoueur.toString());
            int Nbrdefausser;
            System.out.println("Combien voulez vous défausser de cartes ?: ");
            Nbrdefausser = scanner.nextInt();
            if (Nbrdefausser>0){
                defausse.defausser(MainDuJoueur,Nbrdefausser);
            }

            if (MainDuJoueur.Length()<5){
                MainDuJoueur.pioche(Paquetdujoueur,5-MainDuJoueur.Length());
            }

            prochainTour();
        }
    }

    public  boolean FinduJeu(int nombreJoueur){
        switch (nombreJoueur) {
            case 2:
                if (Tourdujoueur.PositionJoueur[0] == 7 && Tourdujoueur.PositionJoueur[1] == 3) {
                    System.out.println("Fin du jeu 2");
                    return true;
                }
                break;
            case 3:
                if (Tourdujoueur.PositionJoueur[0] == 7 && (Tourdujoueur.PositionJoueur[1] == 0 || Tourdujoueur.PositionJoueur[1] == 3 || Tourdujoueur.PositionJoueur[1] == 6)) {
                    System.out.println("Fin du jeu 3");
                    return true;
                }
                break;
            case 4:
                if (Tourdujoueur.PositionJoueur[0] == 7 && (Tourdujoueur.PositionJoueur[1] == 1 || Tourdujoueur.PositionJoueur[1] == 6)) {
                    System.out.println("Fin du jeu 4");
                    return true;
                }
                break;
        }
        return false;
    }

    public void Test(){
        System.out.println("Num du joueur: "+Tourdujoueur.getNum());
    }

    public void prochainTour() {
        int num = Tourdujoueur.getNum();
        if (num < nbrjoueurs) {
            num+=1;
        } else {
            num = 1;
        }
        Tourdujoueur = getJoueur(num);
        Paquetdujoueur= getPaquet(num);
        MainDuJoueur= getMain(num);

    }
    public Joueur getJoueur(int numJoueur) {
        for (Joueur joueur : Listejoueurs) {
            if (joueur.getNum() == numJoueur) {
                return joueur;
            }
        }
        return null;
    }
    public JeuxCartes getPaquet(int numJoueur) {
        for (JeuxCartes paquet : Listepaquets) {
            if (paquet.getNum() == numJoueur) {
                return paquet;
            }
        }
        return null;
    }
    public MainJoueur getMain(int numJoueur) {
        for (MainJoueur mainjoueur : ListeMain) {
            if (mainjoueur.getNum() == numJoueur) {
                return mainjoueur;
            }
        }
        System.out.println("<!> Error ");
        return null;
    }
    public void CompleterProg(){
        //System.out.println("Voici votre main: "+MainDuJoueur.toString());
        int nombreCarte;
        do{
            System.out.println("Entrez le nombre de cartes que vous voulez jouer: ");
            nombreCarte = scanner.nextInt();
        }while(nombreCarte>5 || nombreCarte<1);
        scanner.nextLine();
        ArrayDeque<String> programme = new ArrayDeque<>();
        String choix;
        do {
            do {
                System.out.println("“Bleue” pour avancer");
                System.out.println("“Jaune” pour faire un quart de tour vers la gauche");
                System.out.println("“Violette” pour faire un quart de tour vers la droite");
                System.out.println("“Laser” ppur détruire un mur de glace");
                choix = scanner.nextLine();
                if (!choix.equals("Bleue") && !choix.equals("Jaune") && !choix.equals("Violette") && !choix.equals("Laser")) {
                    System.out.println("<!> La saisie est incorrect ressayez <!>");
                }
            }while(!choix.equals("Bleue") && !choix.equals("Jaune") && !choix.equals("Violette") && !choix.equals("Laser"));
            for(int i=0;i<MainDuJoueur.Length();i++){
                if (MainDuJoueur.get(i).equals(choix)){
                    MainDuJoueur.remove(i);
                    break;
                }
            }
            programme.add(choix);
        }while( programme.size()!=nombreCarte);
        ListeProg.set(Tourdujoueur.getNum(), programme);
    }

    public void ExecuterProg(ArrayDeque<String> instructions){
        System.out.println("Instructions: "+instructions);
        int nbrInstructions=instructions.size();
        for (int i=0; i<nbrInstructions;i++) {
            switch (instructions.peek()) {
                case "Bleue":
                    if (Tourdujoueur.DirectionJoueur == 'N' && Tourdujoueur.PositionJoueur[0] != 0) {
                        if(plateau.CaseVide(Tourdujoueur.PositionJoueur[0] - 1,Tourdujoueur.PositionJoueur[1])){
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[0] -= 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                        }
                        else if(plateau.CaseMur(Tourdujoueur.PositionJoueur[0] - 1,Tourdujoueur.PositionJoueur[1])){
                            System.out.println("Collision Mur");
                            Tourdujoueur.DirectionJoueur='S';
                        }
                        else if(plateau.CaseJoueur(Tourdujoueur.PositionJoueur[0] - 1, Tourdujoueur.PositionJoueur[1])){
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            int numj = plateau.CollisionJoueur(Tourdujoueur.PositionJoueur[0] - 1, Tourdujoueur.PositionJoueur[1]);
                            System.out.println("Collision avec le joueur "+numj+" Retour à la case départ");
                            plateau.EffacerCase(getJoueur(numj).PositionJoueur[0], getJoueur(numj).PositionJoueur[1]);
                            Tourdujoueur.PositionInitiale(nbrjoueurs,Tourdujoueur.getNum());
                            getJoueur(numj).PositionInitiale(nbrjoueurs,numj);
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                            plateau.deplacementJoueur(getJoueur(numj).PositionJoueur[0],getJoueur(numj).PositionJoueur[1],numj);
                        }
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'S' && Tourdujoueur.PositionJoueur[0] != 7) {
                        if(plateau.CaseVide(Tourdujoueur.PositionJoueur[0] + 1,Tourdujoueur.PositionJoueur[1])) {
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[0] += 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                        }
                        else if(plateau.CaseMur(Tourdujoueur.PositionJoueur[0] + 1,Tourdujoueur.PositionJoueur[1])){
                            System.out.println("Collision Mur");
                            Tourdujoueur.DirectionJoueur='N';
                        }
                        else if(plateau.CaseJoueur(Tourdujoueur.PositionJoueur[0] + 1, Tourdujoueur.PositionJoueur[1])) {
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            int numj = plateau.CollisionJoueur(Tourdujoueur.PositionJoueur[0] + 1, Tourdujoueur.PositionJoueur[1]);
                            System.out.println("Collision avec le joueur " + numj + " Retour à la case départ");
                            plateau.EffacerCase(getJoueur(numj).PositionJoueur[0], getJoueur(numj).PositionJoueur[1]);
                            Tourdujoueur.PositionInitiale(nbrjoueurs, Tourdujoueur.getNum());
                            getJoueur(numj).PositionInitiale(nbrjoueurs, numj);
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                            plateau.deplacementJoueur(getJoueur(numj).PositionJoueur[0],getJoueur(numj).PositionJoueur[1],numj);
                        }
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'E' && Tourdujoueur.PositionJoueur[1] != 7) {
                        if(plateau.CaseVide(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1]+1)) {
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[1] += 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                        }
                        else if(plateau.CaseMur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1]+1)){
                            System.out.println("Collision Mur");
                            Tourdujoueur.DirectionJoueur='O';
                        }
                        else if(plateau.CaseJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]+1)) {
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            int numj = plateau.CollisionJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1] + 1);
                            System.out.println("Collision avec le joueur " + numj + " Retour à la case départ");
                            plateau.EffacerCase(getJoueur(numj).PositionJoueur[0], getJoueur(numj).PositionJoueur[1]);
                            Tourdujoueur.PositionInitiale(nbrjoueurs, Tourdujoueur.getNum());
                            getJoueur(numj).PositionInitiale(nbrjoueurs, numj);
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                            plateau.deplacementJoueur(getJoueur(numj).PositionJoueur[0],getJoueur(numj).PositionJoueur[1],numj);
                        }
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'O' && Tourdujoueur.PositionJoueur[1] != 0) {
                        if(plateau.CaseVide(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1]-1)) {
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[1] -= 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                        }
                        else if(plateau.CaseMur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1]-1)){
                            System.out.println("Collision Mur");
                            Tourdujoueur.DirectionJoueur='O';
                        }
                        else if(plateau.CaseJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]-1)) {
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            int numj = plateau.CollisionJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1] - 1);
                            System.out.println("Collision avec le joueur " + numj + " Retour à la case départ");
                            plateau.EffacerCase(getJoueur(numj).PositionJoueur[0], getJoueur(numj).PositionJoueur[1]);
                            Tourdujoueur.PositionInitiale(nbrjoueurs, Tourdujoueur.getNum());
                            getJoueur(numj).PositionInitiale(nbrjoueurs, numj);
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                            plateau.deplacementJoueur(getJoueur(numj).PositionJoueur[0],getJoueur(numj).PositionJoueur[1],numj);
                        }
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'N' && Tourdujoueur.PositionJoueur[0] == 0){
                        System.out.println("Sortie du plateau, retour à la case départ");
                        plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                        Tourdujoueur.PositionInitiale(nbrjoueurs,Tourdujoueur.getNum());
                        plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'S' && Tourdujoueur.PositionJoueur[0] == 7) {
                        System.out.println("Sortie du plateau, retour à la case départ");
                        plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                        Tourdujoueur.PositionInitiale(nbrjoueurs,Tourdujoueur.getNum());
                        plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'E' && Tourdujoueur.PositionJoueur[1] == 7){
                        System.out.println("Sortie du plateau, retour à la case départ");
                        plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                        Tourdujoueur.PositionInitiale(nbrjoueurs,Tourdujoueur.getNum());
                        plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'O' && Tourdujoueur.PositionJoueur[1] == 0) {
                        System.out.println("Sortie du plateau, retour à la case départ");
                        plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                        Tourdujoueur.PositionInitiale(nbrjoueurs,Tourdujoueur.getNum());
                        plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum());
                    }
                    instructions.remove();
                    break;

                case "Jaune":
                    if (Tourdujoueur.DirectionJoueur == 'N') {
                        Tourdujoueur.DirectionJoueur = 'O';
                    } else if (Tourdujoueur.DirectionJoueur == 'S') {
                        Tourdujoueur.DirectionJoueur = 'E';
                    } else if (Tourdujoueur.DirectionJoueur == 'E') {
                        Tourdujoueur.DirectionJoueur = 'N';
                    } else if (Tourdujoueur.DirectionJoueur == 'O') {
                        Tourdujoueur.DirectionJoueur = 'S';
                    }
                    instructions.remove();
                    break;

                case "Violette":
                    if (Tourdujoueur.DirectionJoueur == 'N') {
                        Tourdujoueur.DirectionJoueur = 'E';
                    } else if (Tourdujoueur.DirectionJoueur == 'S') {
                        Tourdujoueur.DirectionJoueur = 'O';
                    } else if (Tourdujoueur.DirectionJoueur == 'E') {
                        Tourdujoueur.DirectionJoueur = 'S';
                    } else if (Tourdujoueur.DirectionJoueur == 'O') {
                        Tourdujoueur.DirectionJoueur = 'N';
                    }
                    instructions.remove();
                    break;
                case "Laser":
                    plateau.Laser(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.DirectionJoueur);
                    instructions.remove();
                    break;
                default:
                    instructions.remove();
                    break;
            }
        }
    }
    /*
    public char InverserSens(char direction){
        if (direction=='N'){
            return direction='S';
        }
        else if (direction=='S'){
            return direction='N';
        }
        else if (direction=='O'){
            return direction='E';
        }
        else {
            return direction='O';
        }
    }

     */
}