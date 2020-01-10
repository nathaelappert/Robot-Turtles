package com.company;
import javax.swing.JFrame;
public class MainInterface {

    public static void main(String[] args) {
	// write your code here
        JFrame fenetre = new JFrame();
        Panneau panneau = new Panneau("C:\\Users\\apara\\RobotTurtles\\Accueil.jpg");
        String click = "Appuyez pour continuer";
        fenetre.setTitle("Robot Turtles");
        fenetre.setSize(640,480); //taille standard fenetre Windows 10
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.add(panneau);
        fenetre.setVisible(true);
    }
}
