package com.company;

import java.io.IOException;
import java.util.*;

public class Game{
    public static Scanner scanner = new Scanner(System.in);

    private Joueur Tourdujoueur; // Variable prenant le joueur dont c'est le tour
    private JeuxCartes Paquetdujoueur; // Variable prenant le paquet du joueur dont c'est le tour
    private MainJoueur MainDuJoueur; // idem
    private JeuxMur MurduJoueur; // idem
    private Plateau plateau;
    private Defausse defausse;
    private int nbrjoueurs;
    private List<ArrayDeque> ListeProg; // Liste des files de programmes de chaque joueur
    private List<Joueur> Listejoueurs = new ArrayList<>(); // Liste des joueurs
    private List<JeuxCartes> Listepaquets = new ArrayList<>(); // Liste des paquets
    private List<MainJoueur> ListeMain = new ArrayList<>(); // Liste des mains des joueurs
    private List<JeuxMur> ListeMurJoueur = new ArrayList<>(); // Liste de leurs murs
    public FenetreGraphique fenetre;
    boolean FinduJeu=false; // On initialise à faux  la fin de partie


    public void initialisationJeu() {


        fenetre = new FenetreGraphique();
        fenetre.setVisible(true);
        nbrjoueurs = Integer.parseInt(fenetre.getNombrejoueurs()); // On demande aux joueurs par la fenetre graphique
/*
        System.out.println("Entrez nombre joueur: ");
        nbrjoueurs = scanner.nextInt();
        while(nbrjoueurs != 2 && nbrjoueurs != 3 && nbrjoueurs != 4){
            System.out.println("le nombre de joueurs entrée n'est pas valide. Il faut un nombre de joueurs entre 2 et 4\nRentrez un nombre de joueurs : ");
            nbrjoueurs = scanner.nextInt();
        }

 */

        System.out.println("Création du jeu avec "+nbrjoueurs+ " joueurs");
        Joueur joueur1 = new Joueur(new int[2], 1,'S'); // On inititalise les paramètres des joueurs
        Listejoueurs.add(joueur1); // On l'ajoute à la liste des joueurs
        Joueur joueur2 = new Joueur(new int[2], 2,'S');
        Listejoueurs.add(joueur2);
        joueur1.PositionInitiale(nbrjoueurs,1); // On initialise sa position
        joueur2.PositionInitiale(nbrjoueurs,2);
        JeuxCartes paquet1 = new JeuxCartes(1); // On créer son paquet de carte
        paquet1.CreaPaquet();
        paquet1.Melanger();
        MainJoueur main_joueur1 = new MainJoueur(1); // On créer sa main
        main_joueur1.pioche(paquet1,5); // On pioche les 5 premières cartes
        Listepaquets.add(paquet1); // On ajoute son paquet dans la liste
        ListeMain.add(main_joueur1); // Idem pour sa main
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
        JeuxMur listeMurjoueur3= null;
        plateau= new Plateau(); // On créer le plateau en console
        defausse = new Defausse();
        plateau.initialisation(nbrjoueurs); // On initialise le plateau
        plateau.deplacementJoueur(joueur1.PositionJoueur[0],joueur1.PositionJoueur[1],1); // On positionne le joueur à sa position de départ
        plateau.deplacementJoueur(joueur2.PositionJoueur[0],joueur2.PositionJoueur[1],2);
        JeuxMur listeMurjoueur1= new JeuxMur(1);
        ListeMurJoueur.add(listeMurjoueur1);
        JeuxMur listeMurjoueur2= new JeuxMur(2);
        ListeMurJoueur.add(listeMurjoueur2);
        switch (nbrjoueurs){ // On recommence le tout en fonction du nombre de joueurs
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
                listeMurjoueur3= new JeuxMur(3);
                ListeMurJoueur.add(listeMurjoueur3);
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
                listeMurjoueur3= new JeuxMur(3);
                ListeMurJoueur.add(listeMurjoueur3);
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
                JeuxMur listeMurjoueur4= new JeuxMur(4);
                ListeMurJoueur.add(listeMurjoueur4);
                break;
        }
        ListeProg = new ArrayList<ArrayDeque>(); // On initialise la liste des programmes
        ListeProg.add(null); // index 0 est null
        for (int i = 0; i < nbrjoueurs; i++){ // On ajoute le nombre de programme en fonction du nombre de joueurs
            ListeProg.add(new ArrayDeque());
        }
        Plateau.afficherPlateau(); // On l'affiche en console
        Tourdujoueur = joueur1; // Premier tour donc le joueur 1 commence
        Paquetdujoueur= paquet1;
        MainDuJoueur= main_joueur1;
        MurduJoueur=listeMurjoueur1;
        fenetre.updatePlateau(plateau.getPlateau());// On update le plateau de la fenetre graphique en fonction de la console
        fenetre.updateCarte(MainDuJoueur);
        fenetre.updateMur(MurduJoueur);
        fenetre.repaint(); // Pas forcément obligatoire mais c'est un sécurité pour la mis à jour du plateau
        fenetre.revalidate(); // idem

    }
    public void Jouer(){ // On lance le jeu
        fenetre.setVisible(true);
        do{ // Tant que les joueurs n'ont pas atteint les joyaux on continue
            int choix;
            do{
                //fenetre.updateCarte(MainDuJoueur);
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
                    System.out.println("Votre Main: "+MainDuJoueur.toString()); // On affiche sa main
                    CompleterProg();
                    break;
                case 2:
                    System.out.println("Votre Main: "+MurduJoueur.toString());
                    PlacerMur();
                    fenetre.updateMur(MurduJoueur);
                    break;
                case 3:
                    ExecuterProg(ListeProg.get(Tourdujoueur.getNum())); // On récupère le programme du joueur dans la liste
                    break;
            }
            System.out.println("Votre Main: "+MainDuJoueur.toString());
            int Nbrdefausser;
            System.out.println("Combien voulez vous défausser de cartes ?: ");
            Nbrdefausser = scanner.nextInt();
            if (Nbrdefausser>0){
                defausse.defausser(MainDuJoueur,Nbrdefausser);// Defausse le nombre de carte souhaiter
                fenetre.updateCarte(MainDuJoueur);
            }

            if (MainDuJoueur.Length()<5){ // On fait piocher le joueur jusqu'à qu'il est 5 cartes
                MainDuJoueur.pioche(Paquetdujoueur,5-MainDuJoueur.Length());
                fenetre.updateCarte(MainDuJoueur);
            }
            prochainTour(); // On change les paramètres du joueur : paquet, main , position etc..
            fenetre.updatePlateau(Plateau.getPlateau());// On update le plateau en console
            fenetre.updateCarte(MainDuJoueur);
            fenetre.updateMur(MurduJoueur);
            fenetre.repaint();
            fenetre.revalidate();
        }while(!FinduJeu);
        System.exit(0);
    }


    public void prochainTour() { // Tous les paramètres du joueur change en fonction de son numéro
        int num = Tourdujoueur.getNum();
        if (num < nbrjoueurs) { // Pour passer du joueur 1 au joueur 2 par exemple
            num+=1;
        } else {
            num = 1; // Pour passer du joueur 4 au joueur 1 par exemple
        }
        Tourdujoueur = getJoueur(num);
        Paquetdujoueur= getPaquet(num);
        MainDuJoueur= getMain(num);
        MurduJoueur=getListeMur(num);
    }
    public Joueur getJoueur(int numJoueur) { // Méthode pour récupérer le joueur dont c'est le tour
        for (Joueur joueur : Listejoueurs) {
            if (joueur.getNum() == numJoueur) {
                return joueur;
            }
        }
        return null;
    }
    public JeuxCartes getPaquet(int numJoueur) { // Méthode pour récupérer le paquet du joueur dont c'est le tour
        for (JeuxCartes paquet : Listepaquets) {
            if (paquet.getNum() == numJoueur) {
                return paquet;
            }
        }
        return null;
    }
    public MainJoueur getMain(int numJoueur) { // Méthode pour récupérer la main du joueur dont c'est le tour
        for (MainJoueur mainjoueur : ListeMain) {
            if (mainjoueur.getNum() == numJoueur) {
                return mainjoueur;
            }
        }
        return null;
    }
    public JeuxMur getListeMur(int numJoueur) { // Méthode pour récupérer les murs du joueur dont c'est le tour
        for (JeuxMur listeMur : ListeMurJoueur) {
            if (listeMur.getNum() == numJoueur) {
                return listeMur;
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

        while (ListeProg.get(Tourdujoueur.getNum()).size()<5 && programme.size()!=0){ // On ajoute les instructions tant qu'elles ne dépassent pas 5
            ListeProg.get(Tourdujoueur.getNum()).add(programme.peekFirst());
            programme.removeFirst();
        }

    }

    public void PlacerMur(){
        System.out.println("Voulez vous placer un mur de Glace (entrez G) ou de Pierre (entrez P): ");
        char mur=scanner.next().charAt(0);
        System.out.println("A quelle ligne (0-7) ?: ");
        int ligne=scanner.nextInt();
        System.out.println("A quelle colonne (0-7) ?: ");
        int colonne=scanner.nextInt();
        plateau.PlacerMur(ligne,colonne,mur); // On place le mur en question
        if (mur=='G'){
            for(int i=0;i<MurduJoueur.Length();i++){
                if (MurduJoueur.get(i).equals("Glace")){
                    MurduJoueur.remove(i); // On enlève le mur de la liste de mur du joueur
                    break;
                }
            }
        }
        if (mur=='P'){
            for(int i=0;i<MurduJoueur.Length();i++){
                if (MurduJoueur.get(i).equals("Pierre")){
                    MurduJoueur.remove(i);
                    break;
                }
            }
        }
    }

    public void ExecuterProg(ArrayDeque<String> instructions){ // Execute le programme en paramètre
        System.out.println("Instructions: "+instructions);
        int nbrInstructions=instructions.size();
        loop : for (int i=0; i<nbrInstructions;i++) {
            switch (instructions.peek()) { // On récupère le premier élément du programme
                case "Bleue":
                    if (Tourdujoueur.DirectionJoueur == 'N' && Tourdujoueur.PositionJoueur[0] != 0) { // Pour éviter les sorties de plateau
                        if(plateau.CaseVide(Tourdujoueur.PositionJoueur[0] - 1,Tourdujoueur.PositionJoueur[1])){ // Si la case en face est vide
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]); // On efface le joueur sur sa position initiale
                            Tourdujoueur.PositionJoueur[0] -= 1; // On le fait avance d'une case dans sa direction
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum()); // On met à jour sa nouvelle position
                        }
                        else if(plateau.CaseMur(Tourdujoueur.PositionJoueur[0] - 1,Tourdujoueur.PositionJoueur[1])){ // S'il y a collision avec un Mur
                            System.out.println("Collision Mur");
                            Tourdujoueur.DirectionJoueur='S'; // On inverse sa direction
                        }
                        else if(plateau.CaseJoueur(Tourdujoueur.PositionJoueur[0] - 1, Tourdujoueur.PositionJoueur[1])){ // S'il y a collision avec un joueur
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]); // On efface sa case
                            int numj = plateau.CollisionJoueur(Tourdujoueur.PositionJoueur[0] - 1, Tourdujoueur.PositionJoueur[1]); // On récupère le numéro du joueur que l'on percute
                            System.out.println("Collision avec le joueur "+numj+" Retour à la case départ");
                            plateau.EffacerCase(getJoueur(numj).PositionJoueur[0], getJoueur(numj).PositionJoueur[1]); // On efface la case du joueur que l'on percute
                            Tourdujoueur.PositionInitiale(nbrjoueurs,Tourdujoueur.getNum()); // On remet à la position de départ le joueur
                            getJoueur(numj).PositionInitiale(nbrjoueurs,numj); // On remet à la position de départ le joueur que l'on percute
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.getNum()); // mis à jour des nouvelles positions des deux joueurs
                            plateau.deplacementJoueur(getJoueur(numj).PositionJoueur[0],getJoueur(numj).PositionJoueur[1],numj);
                        }
                        else if(plateau.CaseJoyau(Tourdujoueur.PositionJoueur[0] - 1, Tourdujoueur.PositionJoueur[1])){ // Si le joyau est atteint
                            System.out.println("Bravo vous avez atteint le joyau !");
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]); // On fait tout de même le déplacement du joueur
                            Tourdujoueur.PositionJoueur[0] -= 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                            FinduJeu=true; // Le jeu est fini
                            break loop;
                        }
                    } // On recommence ce processus selon la direction du joueur
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
                        else if(plateau.CaseJoyau(Tourdujoueur.PositionJoueur[0] + 1, Tourdujoueur.PositionJoueur[1])){
                            System.out.println("Bravo vous avez atteint le joyau !");
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[0] += 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                            FinduJeu=true;
                            break loop;
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
                        else if(plateau.CaseJoyau(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]+1)){
                            System.out.println("Bravo vous avez atteint le joyau !");
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[1] += 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                            FinduJeu=true;
                            break loop;
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
                        else if(plateau.CaseJoyau(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]-1)){
                            System.out.println("Bravo vous avez atteint le joyau !");
                            plateau.EffacerCase(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1]);
                            Tourdujoueur.PositionJoueur[1] -= 1;
                            plateau.deplacementJoueur(Tourdujoueur.PositionJoueur[0], Tourdujoueur.PositionJoueur[1], Tourdujoueur.getNum());
                            FinduJeu=true;
                            break loop;
                        }
                    }
                    else if (Tourdujoueur.DirectionJoueur == 'N' && Tourdujoueur.PositionJoueur[0] == 0){ // Si le joueur sort retour à la case départ
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
                    instructions.remove(); // On enlève l'instruction de la file
                    break;

                case "Jaune": // On fait pivoter le joueur vers la gauche selon sa direction
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

                case "Violette": // On fait pivoter le joueur vers la droite selon sa direction
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
                case "Laser": // On appelle la méthode Laser du plateau
                    plateau.Laser(Tourdujoueur.PositionJoueur[0],Tourdujoueur.PositionJoueur[1],Tourdujoueur.DirectionJoueur);
                    instructions.remove();
                    break;
                default:
                    instructions.remove();
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.initialisationJeu();
        game.Jouer();

    }
}