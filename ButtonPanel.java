package com.company;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;

public class ButtonPanel extends JFrame {
    public ButtonPanel(){
        JPanel pan = new JPanel();
        JButton bouton = new JButton("Cliquez pour continuer");
        this.setTitle("Robot Turtles");
        this.setSize(640, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan.setBackground(Color.WHITE);
        pan.add(bouton, BorderLayout.SOUTH);
        this.setContentPane(new Panneau());
        add(pan);
        setSize(700,700);
        this.setVisible(true);
    }
}
