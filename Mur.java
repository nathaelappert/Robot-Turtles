package com.company;

public class Mur {

    boolean destructible; // Le mur de Glace est destructible contrairement au mur de Pierre
    String Type; // Pierre ou Glace

    public Mur(boolean destructible,String Type){
        this.destructible=destructible;
        this.Type=Type;
    }
    public boolean isDestructible(){
        return this.destructible;
    }

    public String getType() {
        return this.Type;
    }
}
