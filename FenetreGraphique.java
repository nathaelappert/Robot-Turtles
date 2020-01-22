package com.company;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FenetreGraphique extends JFrame {

    private JPanel contentPane;
    private JTextField NbrCarteDefausser;
    private JButton[][] Case = new JButton[8][8];
    private JButton[] Carte = new JButton[5];
    private JButton[] Mur= new JButton[5];

    int taille = 8;
    ImageIcon Glace= new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Glace.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon Pierre= new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Wall2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon Joueur1=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Joueur1.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon Joueur2=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Joueur2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon Joueur3=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Joueur3.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon Joueur4=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Joueur4.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon JoyauBleu=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/joyauBleu.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon JoyauVert=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/joyauVert.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon JoyauRouge=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/joyauRouge.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon JoyauViolet=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/joyauViolet.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    ImageIcon CarteBleue=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/cards/BlueCard.png").getImage().getScaledInstance(82, 100, Image.SCALE_DEFAULT));
    ImageIcon CarteJaune=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/cards/YellowCard.png").getImage().getScaledInstance(82, 100, Image.SCALE_DEFAULT));
    ImageIcon CarteViolette=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/cards/PurpleCard.png").getImage().getScaledInstance(82, 100, Image.SCALE_DEFAULT));
    ImageIcon CarteLaser=new ImageIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/cards/LaserCard.png").getImage().getScaledInstance(82, 100, Image.SCALE_DEFAULT));

    public static void main(String[] args) {

        File imageCheck = new File("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Wall2.png");

        if(imageCheck.exists())
            System.out.println("Image file found!");
        else
            System.out.println("Image file not found!");


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreGraphique frame = new FenetreGraphique();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public FenetreGraphique(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 228, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel plateau = new JPanel(new GridLayout(8, 8));
        plateau.setBounds(8, 11, 477, 477);
        plateau.setBackground(new Color(0, 0, 0, 0));
        plateau.setBorder(new EmptyBorder(5, 5, 5, 5));
        plateau.setOpaque(false);

        for (int i = 0; i < Case.length; i++) {
            for (int j = 0; j < Case[i].length; j++) {
                JButton bouton = new JButton();
                bouton.setOpaque(false);
                bouton.setContentAreaFilled(false);
                bouton.setBorderPainted(false);

                Case[j][i] = bouton;
            }
        }
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                //Case[j][i].setBackground(new Color(0,0,0,30));
                plateau.add(Case[i][j]);
                //Case[7][i].setIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/Wall2.png"));
                //Case[i][7].setIcon(Joueur2);
            }
        }

        plateau.setVisible(true);
        contentPane.add(plateau);


        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(new Color(245, 222, 179));
        lblNewLabel.setIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/plateau.jpg"));
        lblNewLabel.setBounds(6, 0, 485, 500);
        contentPane.add(lblNewLabel);


        JButton btnNewButton_1 = new JButton("Placer un Mur");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBounds(567, 278, 167, 29);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Compléter programme");
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2.setBounds(557, 237, 185, 29);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton = new JButton("Executer le Programme");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(557, 319, 185, 29);
        contentPane.add(btnNewButton);

        for(int i=0; i<5;i++) {
            JButton b = new JButton();
            b.setVisible(true);
            Carte[i] = b;
            Carte[i].setBounds(20+(90*i),520,82,108);
            this.contentPane.add(Carte[i]);
        }

        for(int i=0; i<5;i++) {
            JButton b = new JButton();
            b.setVisible(true);
            Mur[i] = b;
            Mur[i].setBounds(20+(90*i),650,82,82);
            this.contentPane.add(Mur[i]);
        }


        JButton Défausser = new JButton("Défausser des Cartes");
        Défausser.setBounds(557, 397, 185, 29);
        contentPane.add(Défausser);

        NbrCarteDefausser = new JTextField();
        NbrCarteDefausser.setBounds(586, 438, 130, 26);
        contentPane.add(NbrCarteDefausser);
        NbrCarteDefausser.setColumns(10);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(556, 522, 186, 100);
        contentPane.add(textArea);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("/Users/Felix/IdeaProjects/RobotTurtle2/imagesTurtle/background.jpeg"));
        lblNewLabel_1.setBounds(496, 0, 304, 772);
        contentPane.add(lblNewLabel_1);

    }

    public String getNombrejoueurs(){
        String[] choix = {"2", "3", "4"};
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nbrjoueurs = (String)jop.showInputDialog(null,
                "Veuillez indiquer le nombre de joueurs",
                "Nombres de joueurs",
                JOptionPane.QUESTION_MESSAGE, null, choix, choix[2]);
        JOptionPane.showMessageDialog(null, "La partie se jouera avec " + nbrjoueurs+" joueurs");
        return nbrjoueurs;
    }
    public void updatePlateau(char[][] plateau) {
        for(int i=0; i<8;i++) {
            for(int j=0;j<8; j++) {
                switch(plateau[i][j]) {
                    case 'J':
                        Case[i][j].setIcon(JoyauRouge);
                        break;
                    case '1':
                        Case[i][j].setIcon(Joueur1);
                        break;
                    case '2':
                        Case[i][j].setIcon(Joueur2);
                        break;
                    case '3':
                        Case[i][j].setIcon(Joueur3);
                        break;
                    case '4':
                        Case[i][j].setIcon(Joueur4);
                        break;
                    case 'G':
                        Case[i][j].setIcon(Glace);
                        break;
                    case 'P':
                        Case[i][j].setIcon(Pierre);
                        break;
                    case ' ':
                        Case[i][j].setIcon(null);
                        break;
                }
            }
        }
        contentPane.repaint();
    }

    public void updateCarte(MainJoueur mainJoueur){
        for (int i=0;i<mainJoueur.Length();i++){
            switch (mainJoueur.get(i)) {
                case "Bleue":
                    Carte[i].setIcon(CarteBleue);
                    break;
                case "Violette":
                    Carte[i].setIcon(CarteViolette);
                    break;
                case "Jaune":
                    Carte[i].setIcon(CarteJaune);
                    break;
                case "Laser":
                    Carte[i].setIcon(CarteLaser);
                    break;
                default:
                    Carte[i].setIcon(null);
            }
        }
        for (int n=mainJoueur.Length();n<5;n++){
            Carte[n].setIcon(null);
        }

        contentPane.repaint();
    }
    public void updateMur(JeuxMur MurduJoueur){
        for (int i=0;i<MurduJoueur.Length();i++){
            switch (MurduJoueur.get(i)) {
                case "Glace":
                    Mur[i].setIcon(Glace);
                    break;
                case "Pierre":
                    Mur[i].setIcon(Pierre);
                    break;
                default:
                    Mur[i].setIcon(null);
            }
        }
        for (int n=MurduJoueur.Length();n<5;n++){
            Mur[n].setIcon(null);
        }
        contentPane.repaint();
    }


}