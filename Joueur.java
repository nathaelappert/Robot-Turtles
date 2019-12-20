package com.company;
import java.util.Iterator;
import java.util.Scanner;

public class Joueur {
    public char DirectionJoueur;
    public int[] PositionJoueur;
    private int NumeroJoueur;
/*
    public Joueur(){
        DirectionJoueur='S';
        PositionJoueur=new int[2];
    }

 */

    public Joueur(int[] PositionJoueur,int numj,char Direction){
        this.PositionJoueur=PositionJoueur;
        this.NumeroJoueur=numj;
        this.DirectionJoueur=Direction;
    }

    public void PositionInitiale(int nbrj, int numj){
        DirectionJoueur = 'S';
        PositionJoueur[0] = 0;
        switch(nbrj){
            case 2 : switch(numj){
                case 1 : PositionJoueur[1] = 1; break;
                case 2 : PositionJoueur[1] = 5; break;
            }
            break;
            case 3 : switch(numj){
                case 1 : PositionJoueur[1] = 0; break;
                case 2 : PositionJoueur[1] = 3; break;
                case 3 : PositionJoueur[1] = 6; break;
            }
            break;
            case 4 : switch(numj){
                case 1 : PositionJoueur[1] = 0; break;
                case 2 : PositionJoueur[1] = 2;;break;
                case 3 : PositionJoueur[1] = 5; break;
                case 4 : PositionJoueur[1] = 7; break;
            }
            break;
        }
    }

    public static void main(String[] args) {

    }
    public int getNum() {
        return NumeroJoueur;
    }



}
