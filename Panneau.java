package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import  javax.swing.JPanel;

public class Panneau extends JPanel { // Classe permettant de lire le fichier et de dessiner l'image
    Image image;
    public Panneau(String image){
        try{
            this.image = ImageIO.read(new File(image));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

