package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import java.io.File;


public class Menu extends JFrame { // Ce Menu empêche le plateau de se mettre à jour donc lancez directement la classe Game sans cette classe

    public Menu() { // Affichage de départ du jeu
        JPanel pan = new JPanel();
        JButton bouton = new JButton("Cliquez pour jouer !"); // Bouton pour commencer à jour
        bouton.setBounds(320,500,200,29);
        pan.add(bouton);
        this.setTitle("Robot Turtles");
        this.setSize(640, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan.setBackground(Color.WHITE);
        this.setContentPane(new Panneau("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Menu.jpg"));
        setSize(900, 600);
        add(pan);
        this.setVisible(true);
        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // si l'utilisateur clique le jeu commencee
                dispose(); // On ferme cette première fenêtre

                Game game = new Game(); // On créer une partie
                game.initialisationJeu(); // On initialise la partie
                game.Jouer(); // On lance le déroulement du jeu ( la méthode Jouer rentre en conflit avec la partie graphique donc elle fonctionne seulement en console )
            }
        });

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }


}
