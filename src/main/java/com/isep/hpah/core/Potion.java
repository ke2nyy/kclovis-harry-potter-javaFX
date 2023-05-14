package com.isep.hpah.core;

import com.isep.hpah.support.ConsoleColors;

import java.util.Objects;

public class Potion {
    private String name;
    private int hp;

    public Potion(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public static void drinkPotion(Wizard wizard, Potion potion){
        if(Objects.equals(wizard.getHouse().getName(), "Hufflepuff")) {
            wizard.setHp(wizard.getHp() + potion.getHp() + 10);
            System.out.println("Tu as gagné "+ ConsoleColors.GREEN + (potion.getHp())+" + 10 PV comme tu es chez Hufflepuff");
        }else{
            wizard.setHp(wizard.getHp() + potion.getHp());
            System.out.println("Tu as gagné "+ ConsoleColors.GREEN + potion.getHp());
        }
        if (wizard.getHp() >= 100){
            wizard.setHp(100);
        }
    }

}

