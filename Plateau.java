package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Plateau {



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

    public void deplacementJoueur(int ligne, int colonne, int numj){
        if (numj<1 || numj>4 ){
            plateau[ligne][colonne]=' ';
        }
        else{
            plateau[ligne][colonne]=(char)(numj+'0');
        }
    }
    public boolean CaseMur(int ligne, int colonne){
        if (plateau[ligne][colonne]=='P'|| plateau[ligne][colonne]=='G'){
            return true;
        }
        return false;
    }
    public boolean CaseJoueur(int ligne,int colonne){
        for (int i=1;i<5;i++){
            if(plateau[ligne][colonne]==(char) (i + '0')){
                return true;
            }
        }
        return false;
    }
    public int CollisionJoueur(int ligne, int colonne){
        int i;
        for ( i=1;i<5;i++) {
            if (plateau[ligne][colonne] == (char) (i + '0')) {
                break;
            }
        }
        return i;
    }
    public void Laser(int ligne, int colonne, char direction){
        if (direction=='N'){
            for (int i=1;i<=ligne;i++){
                if (plateau[ligne-i][colonne]=='G'){
                    plateau[ligne-i][colonne]=' ';
                    break;
                }
            }
        }
        else if(direction=='S'){
            for (int i=1;i<=7-ligne;i++){
                if (plateau[ligne+i][colonne]=='G'){
                    plateau[ligne+i][colonne]=' ';
                    break;
                }
            }
        }
        else if(direction=='O'){
            for (int i=1;i<=colonne;i++){
                if (plateau[ligne][colonne-i]=='G'){
                    plateau[ligne][colonne-i]=' ';
                    break;
                }
            }
        }
        else if(direction=='E'){
            for (int i=1;i<=7-colonne;i++){
                if (plateau[ligne][colonne+i]=='G'){
                    plateau[ligne][colonne+i]=' ';
                    break;
                }
            }
        }
    }
    public boolean CaseJoyau(int ligne, int colonne){
        if (plateau[ligne][colonne]=='J'){
            return true;
        }
        return false;
    }
    public void EffacerCase(int ligne,int colonne){
        plateau[ligne][colonne]=' ';
    }
    public void PlacerMur(int ligne,int colonne, char Type){
        if (plateau[ligne][colonne]==' '){
            plateau[ligne][colonne]=Type;
        }
    }
    /*

    public boolean JoyauAccessible(int ligne,int colonne){
        if (plateau[ligne+1][colonne]!=' ' || plateau[ligne-1][colonne]!=' ' || plateau[ligne][colonne+1]!=' ' || plateau[ligne][colonne-1]!=' ') {
            return false;
        }
        int n=1;
        while (plateau[ligne+1][colonne]==' ' || plateau[ligne-1][colonne]==' ' || plateau[ligne][colonne+1]==' ' || plateau[ligne][colonne-1]==' '){
            
        }
    }
     */


}

