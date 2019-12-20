package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Plateau {

    public static void main(String[] args) {
        Game game = new Game();
        game.initialisationJeu();
        game.Jouer();


    }

    private static char[][] plateau;
    private static int[] position= new int[2];
    private static char direction='S';
    private static Scanner scanner = new Scanner(System.in);

    public Plateau(){
        plateau= new char[8][8];
    }

    public void initialisation(int nombreJoueur) {
        for (int ligne = 0; ligne <= 7; ligne++) {
            for (int colonne = 0; colonne <= 7; colonne++) {
                switch(nombreJoueur){
                    case 2:
                        if (colonne==7){
                            plateau[ligne][colonne]='P';
                        }
                        else if (ligne==7 && colonne==3){
                            plateau[ligne][colonne]='J';
                        }
                        else{
                            plateau[ligne][colonne]=' ';
                        }
                        break;
                    case 3:
                        if (colonne==7){
                            plateau[ligne][colonne]='P';
                        }
                        else if (ligne==7 && (colonne==0 || colonne==3 || colonne==6)){
                            plateau[ligne][colonne]='J';
                        }
                        else{
                            plateau[ligne][colonne]=' ';
                        }
                        break;
                    case 4:
                        if (ligne==7 && (colonne==1 ||  colonne==6)){
                            plateau[ligne][colonne]='J';
                        }
                        else{
                            plateau[ligne][colonne]=' ';
                        }
                        break;
                }
            }
        }
    }

    public static void deplacement(ArrayDeque<String> instructions){
        System.out.println("Instructions: "+instructions);
        for (int i=0; i<5;i++) {
            if (instructions.peek().equals("A")) {
                if (direction == 'N' && position[0]!=0) {
                    plateau[position[0]][position[1]] = ' ';
                    plateau[position[0] - 1][position[1]] = 'X';
                    position[0] -= 1;
                }
                else if (direction == 'S' && position[0]!=7) {
                    plateau[position[0]][position[1]] = ' ';
                    plateau[position[0] + 1][position[1]] = 'X';
                    position[0] += 1;
                }
                else if (direction == 'E' && position[1]!=7) {
                    plateau[position[0]][position[1]] = ' ';
                    plateau[position[0]][position[1] + 1] = 'X';
                    position[1] += 1;
                }
                else if (direction == 'O' && position[1]!=0) {
                    plateau[position[0]][position[1]] = ' ';
                    plateau[position[0]][position[1] - 1] = 'X';
                    position[1] -= 1;
                }
                instructions.remove();
            }
            else if (instructions.peek().equals("G")) {
                if (direction == 'N') {
                    direction = 'O';
                }
                else if (direction == 'S') {
                    direction = 'E';
                }
                else if (direction == 'E') {
                    direction = 'N';
                }
                else if (direction == 'O') {
                    direction = 'S';
                }
                instructions.remove();
            }
            else if (instructions.peek().equals("D")) {
                if (direction == 'N') {
                    direction = 'E';
                }
                else if (direction == 'S') {
                    direction = 'O';
                }
                else if (direction == 'E') {
                    direction = 'S';
                }
                else if (direction == 'O') {
                    direction = 'N';
                }
                instructions.remove();
            }
        }
        afficherPlateau();
    }
    public static void afficherPlateau() {
        for (int ligne=0;ligne<=7;ligne++) {
            for (int colonne = 0; colonne <=7; colonne++) {
                System.out.print("|"+plateau[ligne][colonne]);
            }
            System.out.println('|');
        }
    }
    public boolean CaseVide(int ligne,int colonne){
        if (plateau[ligne][colonne]==' '){
            return true;
        }
        return false;
    }
    public void Test(){

    }
    public void positionJoueur(int ligne, int colonne, int numj){
        if (plateau[ligne][colonne]==' '){
            plateau[ligne][colonne]=(char)(numj+'0');
        }
    }

}

