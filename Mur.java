package com.company;

public class Mur {

    boolean destructible;
    char Type;

    public Mur(boolean destructible,char Type){
        this.destructible=destructible;
        this.Type=Type;
    }
    public boolean isDestructible(){
        return this.destructible;
    }

    public char getType() {
        return this.Type;
    }
}
