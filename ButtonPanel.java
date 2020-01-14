package com.company;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;

public class ButtonPanel extends JFrame implements ActionListener{
    //private JPanel pan = new JPanel();
    //private JButton bouton = new JButton("Cliquez pour continuer !");

    public ButtonPanel(){
        JPanel pan = new JPanel();
        //pan.setLayout(null);
        JButton bouton = new JButton("Cliquez pour continuer !");
        this.setTitle("Robot Turtles");
        this.setSize(640, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan.setBackground(Color.WHITE);
        //pan.add(bouton);
        bouton.addActionListener((ActionListener) this);
        pan.add(bouton, BorderLayout.SOUTH);
        //pan.setBounds(400,600,200,100);
        //this.setContentPane(pan);
        this.setContentPane(new Panneau("C:\\Users\\apara\\RobotTurtles\\Accueil.jpg"));
        add(pan);
        setSize(700,700);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        //System.out.println("Ici !");
        //Menu menu = new Menu();
        JPanel mp = new JPanel();
        String menuBackground = "C:\\Users\\apara\\RobotTurtles\\menu.png";
        JLabel menuPic = new JLabel(menuBackground);
        JButton bouton1 = new JButton("player 1");
        JButton bouton2 = new JButton("player 2");
        JButton bouton3 = new JButton("player 3");
        JButton bouton4 = new JButton("player 4");
        this.setContentPane(new Panneau(menuBackground));
        add(mp);
        this.setVisible(true);
    }
}
