package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import  javax.swing.JPanel;

public class Panneau extends JPanel {
    Image img;
    public Panneau(String image){
        try{
            this.img = ImageIO.read(new File(image));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}



