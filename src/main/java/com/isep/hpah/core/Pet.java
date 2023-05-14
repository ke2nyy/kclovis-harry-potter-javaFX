package com.isep.hpah.core;

import java.util.Scanner;

public enum Pet {
    Owl, Rat, Cat, Toad;

    public static Pet assignPet() {
        Game game= new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisis ton animal de compagnie :");
        System.out.println("1 = Cat");
        System.out.println("2 = Owl");
        System.out.println("3 = Toad");
        System.out.println("4 = Rat");
        int choose = game.readInt("-> ", 4);
        if (choose == 1){
            return Pet.Cat;
        }
        if (choose == 2){
            return Pet.Owl;
        }
        if (choose == 3){
            return Pet.Toad;
        }
        else {
            return Pet.Rat;
        }
    }
}