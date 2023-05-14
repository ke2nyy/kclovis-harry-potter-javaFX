package com.isep.hpah.core;

import com.isep.hpah.spells.ForbiddenSpell;
import com.isep.hpah.spells.Spell;
import com.isep.hpah.core.wand.Core;
import com.isep.hpah.core.wand.Wand;
import com.isep.hpah.support.ConsoleColors;

import java.util.*;

public class Game {

    Scanner scanner = new Scanner(System.in);

    static public Wizard wizard;

    public int map = 0;
    public String[] maps = {"Toilettes du donjon", "Chambre des secrets", "Lac dans la Forêt Interdite", "Cimetière de Little Hangleton", "Salle d’examen de Poudlard", "Tour d’astronomie", "Poudlard"};

    public boolean isRunning;

    public int readInt(String prompt, int userChoices){
        Scanner scanner = new Scanner(System.in);
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Entre un entier");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    public void printSeperator(int n){
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public void clearConsole(){
        for(int i = 0; i<100; i++){
            System.out.println();
        }
    }

    public void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
    }

    public void anythingToContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPrêt à continuer l'aventure. Si oui, entre une touche de ton clavier");
        scanner.next();
    }

    public List<Potion> setupPotions(){
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Potion commune", 20));
        potions.add(new Potion("Potion rare", 40));
        potions.add(new Potion("Potion Légendaire", 60));

        return potions;
    }

    public List<Spell> setupSpells(){
        List<Spell> spells = new ArrayList<>();
        spells.add(new Spell("Expelliarmus",90, "Provoque peu de dégats mais de manière quasiment garantie", 20));
        spells.add(new Spell("Wingardium Leviosa", 100, "Permet de jeter des objets en les faisant léviter", 0));
        spells.add(new Spell("Incendio", 70, "Lance une boule de feu", 50));
        spells.add(new Spell("Accio", 100, "Attire un objet vers vous", 0));
        spells.add(new Spell("Expecto Patronum", 100, "Ce spell est très performant contre les Détraqueurs", 0));
        spells.add(new Spell("Stupefix", 80, "Provoque des dégats avec une de manière pas toujours précise", 40));
        spells.add(new Spell("Sectusempra", 70, "Spell très puissant !", 70));

        return spells;
    }

    public List<ForbiddenSpell> setupForbiddenSpells(){
        List<ForbiddenSpell> forbiddenSpells = new ArrayList<>();
        forbiddenSpells.add(new ForbiddenSpell("Avada Kedavra",80, "Tue directement l'ennemi si le spell est réussit", 10000));
        forbiddenSpells.add(new ForbiddenSpell("Endoloris", 80, "Fait souffrir l'ennemi et lui provoque des dégats", 50));

        return forbiddenSpells;
    }

    public void spellsKnown(){
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(setupSpells().get(0));
        knownSpells.add(setupSpells().get(1));
        wizard.setSpellsKnown(knownSpells);
    }

    public void learnSpell(Spell spell){
        List<Spell> knownSpells = wizard.getSpellsKnown();
        knownSpells.add(spell);
        wizard.setSpellsKnown(knownSpells);
        System.out.println("Tu viens d'apprendre "+spell.getName());
        anythingToContinue();
    }

    public List<Spell> level5spellsKnown(){
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(setupSpells().get(0));
        knownSpells.add(setupSpells().get(2));
        knownSpells.add(setupSpells().get(5));

        return knownSpells;
    }

    public void potionsOwned(){
        List<Potion> ownedPotions = new ArrayList<>();
        ownedPotions.add(setupPotions().get(0));
        ownedPotions.add(setupPotions().get(0));
        wizard.setPotionsOwned(ownedPotions);
    }

    public void addPotion(Potion potion){
        List<Potion> ownedPotions = wizard.getPotionsOwned();
        ownedPotions.add(potion);
        wizard.setPotionsOwned(ownedPotions);
        System.out.println("Vous avez pris une "+potion.getName());
        anythingToContinue();
    }

    public List<House> setupHouse(){
        List<House> houses = new ArrayList<>();
        houses.add(new House("Slytherin"));
        houses.add(new House("Gryffindor"));
        houses.add(new House("Hufflepuff"));
        houses.add(new House("Ravenclaw"));

        return houses;
    }


    public void setupGame(){

        SortingHat mysortingHat = new SortingHat();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour jeune sorcier ! Quel est ton nom ");
        String name = scanner.nextLine();

        System.out.println("YCommençons par t'équiper!\n" +
                "\n" +
                "Voici le chemin de Traverse. Ici tu peux prendre tout ce dont il te faut pour tes aventures!\n" +
                "Commençons par te chercher une baguette magique chez Ollivander\n" +
                "La baguette vous a Choisis! Vous avez reçu une baguette de 22cm à base de phoenix feather");
        anythingToContinue();


        int size = 20 + (int) (Math.random() * ((35 - 20) + 1));

        Wand wand = new Wand(size, Core.assignCore());
        House house = mysortingHat.assignHouse();


        setupSpells();
        wizard = new Wizard(name, 100, 0, 0, house, Pet.assignPet(), wand, null, null);
        if (Objects.equals(wizard.getHouse().getName(), "Slytherin")) {
            wizard.setAtk(120);
        } else {
            wizard.setAtk(100);
        }
        if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
            wizard.setDef(120);
        }else{
            wizard.setDef(100);
        }
        anythingToContinue();
        spellsKnown();
        setupPotions();
        potionsOwned();

        System.out.println("Apprenti sorcier " + wizard.name + ": \n Maison : " + wizard.getHouse().getName() + "\n Animal de compagnie : "
                + wizard.getPet() + "\n Baguette : faite à base de " + wand.getCore() + " de " + wand.getSize() + "cm");
        anythingToContinue();
        chooseUpgrade(wizard);
    }

    public void main(String[] args) {
        StartGame();
    }

    public void StartGame(){

        Level myLevel= new Level();

        setupGame();

        myLevel.level1();
        myLevel.level2();
        myLevel.level3();
        myLevel.level4();
        myLevel.level5();
        myLevel.level6();
        myLevel.level7();
    }

    public static void continueJourney(){
    }

    public void characterInfo(){
        printHeading("TON SORCIER");
        System.out.println(wizard.name);
        System.out.println("HP: "+wizard.maxHp+" Attaque: " + wizard.atk + " Défense: "+wizard.def);
        System.out.println("Maison : "+wizard.getHouse().getName());
        System.out.println("Animal : "+wizard.getPet());
        anythingToContinue();
    }

    public void printMenu(){
        clearConsole();
        printHeading(maps[map]);
        System.out.println("Choisiss une option : ");
        printSeperator(20);
        System.out.println("1: Continuer l'aventure");
        System.out.println("2: Voir spells connus");
        System.out.println("3: Ton sorcier");
        System.out.println("4: Quitter");
    }

    public void gameLoop(){
        isRunning = true;
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 4);
            if (input == 1) {
                isRunning = false;
            }else if(input == 2) {
                printSpells(wizard.getSpellsKnown());
            } else if (input == 3) {
                characterInfo();
            }else {
                System.exit(1);
            }
        }
    }

    public void printSpells(List<Spell> spells) {
        for (Spell spell : spells) {
            System.out.println(spell.getName().toString());
            System.out.println("Effet: "+spell.getEffect().toString());
            System.out.println("Précision: "+spell.getAccuracy());
            System.out.println("Dégat: "+spell.getDamage());
            printSeperator(20);
        }
        anythingToContinue();
    }

    public void printPotions(List<Potion> potions) {
        int i = 0;
        for (Potion potion : potions) {
            i+=1;
            System.out.println("("+i+") " + potion.getName()+ " vous a fait récupérer "+ ConsoleColors.CYAN + potion.getHp()+" HP");
        }
    }

    public void removePotionList(int i) {
        List<Potion> ownedPotions = wizard.getPotionsOwned();
        ownedPotions.remove(i);
        wizard.setPotionsOwned(ownedPotions);
    }

    public void battle1(Enemy enemy){
        boolean fight=true;
        while(fight) {
            printHeading(enemy.name + "\nHP: " + enemy.getHp() + "/" + enemy.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa");
                int input1 = readInt("-> ", 2);
                if (input1 == 1) {
                    int damage;
                    damage = wizard.attack(wizard.getSpellsKnown().get(0), enemy);
                    enemy.takeDamage(damage);
                    anythingToContinue();
                } else if (input1 == 2) {
                    int damage;
                    damage = wizard.attack(wizard.getSpellsKnown().get(1), enemy);
                    enemy.takeDamage(damage);
                    enemy.setDef(0);
                    System.out.println("Il est sans défense ! Utilise maintenant un spell");
                    anythingToContinue();
                }
            }else if (input == 2){
                /* faire la partie avec les potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion : ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
                /*wizard.setPotionsOwned(wizard.getPotionsOwned().remove(potionnum-1));*/

            }else if (input == 3){
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }

            if (enemy.getHp() <= 0) {
                fight = false;
            }

            if (fight) {
                int damage1;
                damage1 = enemy.attack1(wizard);
                wizard.takeDamage(damage1);
            }

            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
            }
        }
    }

    public void battle2(Enemy enemy){
        boolean fight=true;
        while(fight) {
            printHeading(enemy.name + "\nHP: " + enemy.getHp() + "/" + enemy.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio");
                int input1 = readInt("-> ", 3);
                if (input1 == 1) {
                    int damage;
                    damage = wizard.attack(wizard.getSpellsKnown().get(0), enemy);
                    enemy.takeDamage(damage);
                    anythingToContinue();
                } else if (input1 == 2) {
                    System.out.println("Tu n'as rien à faire léviter");
                    anythingToContinue();
                } else if (input1 == 3) {
                    if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
                        System.out.println("Tu viens de te munir de la légandaire épée Godric de Gryffindor !");
                        System.out.println("Tu peux maintenant tuer Basilic facilement et détruire le journal.");
                        anythingToContinue();
                        enemy.setHp(0);
                    }else {
                        System.out.println("You just have grabbed a Basilisk's fang but you will have to survive a few attacks before reaching the diary since you can't use accio on it beacause it is a legendary artefact");
                        for(int i = 1; i<=3; i++){

                            if (i==1){
                                int damage1;
                                damage1 = enemy.attack1(wizard);
                                wizard.takeDamage(damage1);
                                System.out.println("Tu n'es pas très proche");
                                System.out.println("Il te reste "+wizard.getHp()+" HP");
                                anythingToContinue();
                            }
                            if (i==2){
                                int damage1;
                                damage1 = enemy.attack1(wizard);
                                wizard.takeDamage(damage1);
                                System.out.println("Tu es de plus en plus proche");
                                System.out.println("Il te reste "+wizard.getHp()+" HP");
                                anythingToContinue();
                            }
                            if (i==3){
                                System.out.println("Tu l'as enfin atteint !");
                                anythingToContinue();
                            }

                            if (wizard.getHp() <= 0) {
                                System.out.println("Tu est mort...");
                                anythingToContinue();
                                System.exit(1);
                                fight = false;
                            }

                        }


                    }
                    System.out.println("Basilic est mort. Tu l'as battu !");
                    fight=false;
                }
            }else if (input == 2) {
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            }else if (input == 3){
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }

            if (enemy.getHp() <= 0) {
                fight = false;
            }

            if (fight) {
                int damage1;
                damage1 = enemy.attack1(wizard);
                wizard.takeDamage(damage1);
            }


            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }
        }
    }

    public void battle3(Enemy enemy){
        boolean fight=true;
        int i = 0;
        int j = 0;
        while(fight) {
            printHeading(enemy.name + "\nHP: " + enemy.getHp() + "/" + enemy.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("ATTENTION ! Les Détraqueurs arrivent. Trouves une solution avant qu'ils ne t'attrapent ! ");
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum");
                int input1 = readInt("-> ", 4);
                if (input1 == 4){
                    i += 1;
                    if (i == 1){
                        System.out.println("Concentre-toi et il marchera.");
                    } else if (i == 2){
                        System.out.println("Presque, réessaye !");
                    } else if (i == 3){
                        System.out.println("Tu as réussi ! Tu as réussis à repousser les Détraqueurs grâce à ton spell.");
                        enemy.setHp(0);
                        anythingToContinue();
                    }
                } else {
                    System.out.println("Le spell n'a pas fonctionné ! ");
                }

            }else if (input == 2){
                /* faire la partie avec les potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            }else if (input == 3){
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }

            if (enemy.getHp() <= 0) {
                fight = false;
            }

            j += 1;
            if (j == 1){
                System.out.println("Les Détraqueurs arrivent ! Prépare toi à les repousser");
            } else if (j == 2){
                System.out.println("Les Détraqueurs sont de plus en plus proche");
            } else if (j == 3){
                System.out.println("Les Détraqueurs sont très proche !");
            } else if (j == 4){
                System.out.println("Ils peuvent presque te toucher ! Cela devient très inquiétant.");
            } else if (j == 5){
                System.out.println("Tu n'as pas réussis à les repousser... Ils t'ont eu.");
                wizard.setHp(0);
            }

            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }
        }
    }


    public void battle4(Boss boss, Boss boss1) {
        Random rand = new Random();
        boolean fight=true;
        boolean dead=false;
        boolean dead1=false;
        int distance = 100;
        while(fight) {
            distance = distance - 10;
            if (distance <= 0){
                distance = 0;
            }
            printHeading(boss.name + "\nHP: " + boss.getHp() + "/" + boss.maxHp);
            printHeading(boss1.name + "\nHP: " + boss1.getHp() + "/" + boss1.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Tu es à "+distance+"m du trophée");
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio");
                int input1 = readInt("-> ", 5);
                if (input1==3){
                    if (distance <= 50){
                        System.out.println("Tu as attrapé le trophée !");
                        anythingToContinue();
                        fight=false;
                    } else if (distance >= 60){
                        System.out.println("Tu n'étais pas assez près du trophée");
                    }
                } else{
                    System.out.println("Qui veux-tu attaquer ?");
                    System.out.println("(1) Voldemort\n(2) Peter Pettigrew");
                    int input2 = readInt("->", 2);
                    if (input2==1) {
                        if (dead) {
                            System.out.println(boss.getName()+" est déjà mort");
                        }else {
                            int damage;
                            damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss);
                            if (damage <= 0) {
                                damage = 0;
                            }
                            boss.takeDamage(damage);
                            anythingToContinue();
                        }
                    } else if (input2==2) {
                        if (dead1) {
                            System.out.println(boss1.getName()+" est déjà mort");
                        }else {
                            int damage;
                            damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss1);
                            if (damage <= 0) {
                                damage = 0;
                            }
                            boss1.takeDamage(damage);
                            anythingToContinue();
                        }
                    }
                }
            } else if (input == 2){
                /* faire potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3){
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }

            if (boss.getHp() <= 0) {
                System.out.println("Voldemort est battu");
                dead = true;
            }

            if (boss1.getHp() <= 0) {
                System.out.println("Peter Pettigrew est mort");
                dead1 = true;
            }

            if (dead & dead1){
                fight = false;
            }

            int spell1 = rand.nextInt(2)+1;
            int spell2 = rand.nextInt(2)+1;

            if (fight) {
                if (!dead) {
                    int damage1;
                    damage1 = boss.attack2(boss.getSpellsKnown().get(spell1 - 1), wizard);
                    wizard.takeDamage(damage1);
                }
            }

            if (fight) {
                if (!dead1) {
                    int damage2;
                    damage2 = boss1.attack2(boss1.getSpellsKnown().get(spell2 - 1), wizard);
                    wizard.takeDamage(damage2);
                }
            }

            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

        }
    }

    public void battle5(Boss boss){
        Random rand = new Random();
        boolean fight=true;
        int i = 0;
        while(fight) {
            i += 1;
            printHeading(boss.name + "\nHP: " + boss.getHp() + "/" + boss.maxHp);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio\n(6) Stupefix");
                int input1 = readInt("-> ", 6);
                int damage;
                damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss);
                if (damage<=0){
                    damage = 0;
                }
                boss.takeDamage(damage);
                anythingToContinue();
            } else if (input == 2){
                /* faire potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3){
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }

            if (boss.getHp() <= 0) {
                System.out.println(boss.getName()+" est battu");
                fight = false;
            }

            int spell1 = rand.nextInt(3)+1;

            if (fight) {
                int damage1;
                damage1 = boss.attack(wizard, boss.getAuthorizedSpellsKnown().get(spell1 - 1));
                wizard.takeDamage(damage1);
            }

            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

            if (i==5){
                fight = false;
            }

        }
    }

    public void battle6(Boss boss1, Boss boss2, Boss boss3) {
        Random rand = new Random();
        boolean fight = true;
        boolean dead1 = false;
        boolean dead2 = false;
        boolean dead3 = false;
        while (fight) {
            printHeading(boss1.name + "\nHP: " + boss1.getHp() + "/" + boss1.maxHp);
            printHeading(boss2.name + "\nHP: " + boss2.getHp() + "/" + boss2.maxHp);
            printHeading(boss3.name + "\nHP: " + boss3.getHp() + "/" + boss3.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio\n(6) Stupefix\n(7) Sectusempra");
                int input1 = readInt("-> ", 7);
                System.out.println("Qui veux-tu attaquer ?");
                System.out.println("(1) Mangemort1\n(2) Mangemort2\n(3) Mangemort3");
                int input2 = readInt("->", 10);
                if (input2 == 1) {
                    if (dead1) {
                        System.out.println(boss1.getName()+" est déjà mort");
                    }else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss1);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss1.takeDamage(damage);
                        anythingToContinue();
                    }
                } else if (input2 == 2) {
                    if (dead2) {
                        System.out.println(boss2.getName()+" est déjà mort");
                    }else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss2);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss2.takeDamage(damage);
                        anythingToContinue();
                    }
                } else if (input2 == 3){
                    if (dead3) {
                        System.out.println(boss3.getName()+" est déjà mort");
                    } else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss3);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss3.takeDamage(damage);
                        anythingToContinue();
                    }
                }
            }else if (input == 2){
                /* faire potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3) {
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }


            if (boss1.getHp() <= 0) {
                System.out.println("Mangemort1 est mort");
                dead1 = true;
            }

            if (boss2.getHp() <= 0) {
                System.out.println("Mangemort2 est mort");
                dead2 = true;
            }

            if (boss3.getHp() <= 0) {
                System.out.println("Mangemort3 est mort");
                dead3 = true;
            }

            if (dead1 & dead2 & dead3){
                fight = false;
            }

            int spell1 = rand.nextInt(2)+1;
            int spell2 = rand.nextInt(2)+1;
            int spell3 = rand.nextInt(2)+1;

            if (fight) {
                if (!dead1) {
                    int damage1;
                    damage1 = boss1.attack2(boss1.getSpellsKnown().get(spell1 - 1), wizard);
                    wizard.takeDamage(damage1);
                }
            }

            if (fight) {
                if (!dead2) {
                    int damage2;
                    damage2 = boss2.attack2(boss2.getSpellsKnown().get(spell2 - 1), wizard);
                    wizard.takeDamage(damage2);
                }
            }

            if (fight) {
                if (!dead3) {
                    int damage3;
                    damage3 = boss3.attack2(boss3.getSpellsKnown().get(spell3-1), wizard);
                    wizard.takeDamage(damage3);
                }
            }

            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

        }
    }

    public void battle7(Boss boss1, Boss boss2){
        Random rand = new Random();
        boolean fight=true;
        boolean dead1=false;
        boolean dead2=false;
        while(fight) {
            printHeading(boss1.name + "\nHP: " + boss1.getHp() + "/" + boss1.maxHp);
            printHeading(boss2.name + "\nHP: " + boss2.getHp() + "/" + boss2.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Que veux-tu faire ? ");
            printSeperator(20);
            System.out.println("(1) Jeter un sort\n(2) Utiliser une potion\n(3) Abandonner");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Quel spell vas-tu choisir ?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio\n(6) Stupefix\n(7) Sectusempra");
                int input1 = readInt("-> ", 7);
                System.out.println("Qui veux-tu attaquer ?");
                System.out.println("(1) " + boss1.getName()+"\n(2) "+boss2.getName());
                int input2 = readInt("->", 2);
                if (input2==1) {
                    if (dead1){
                        System.out.println(boss1.getName()+" est déjà mort");
                    }else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss1);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss1.takeDamage(damage);
                        anythingToContinue();
                    }
                } else if (input2==2) {
                    if (dead2){
                        System.out.println(boss2.getName()+" est déjà mort");
                    } else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss2);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss2.takeDamage(damage);
                        anythingToContinue();
                    }
                }

            } else if (input == 2){
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choisis ta potion ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3){
                System.out.println("Tu t'es rendu.");
                System.exit(1);
            }

            if (boss1.getHp() <= 0) {
                System.out.println(boss1.getName()+" est mort");
                dead1 = true;
            }

            if (boss2.getHp() <= 0) {
                System.out.println(boss2.getName() + " est mort");
                dead2 = true;
            }

            if (dead1 & dead2){
                fight = false;
            }

            int spell1 = rand.nextInt(2)+1;
            int spell2 = rand.nextInt(2)+1;

            if (fight) {
                if (!dead1) {
                    int damage1;
                    damage1 = boss1.attack2(boss1.getSpellsKnown().get(spell1 - 1), wizard);
                    wizard.takeDamage(damage1);
                }
            }

            if (fight) {
                if (!dead2) {
                    int damage2;
                    damage2 = boss2.attack2(boss2.getSpellsKnown().get(spell2 - 1), wizard);
                    wizard.takeDamage(damage2);
                }
            }

            if (wizard.getHp() <= 0) {
                System.out.println("Tu est mort...");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

        }
    }

    public void chooseUpgrade(Wizard wizard){
        printHeading("Choisis une amélioration");
        System.out.println("1: Améliorer ton attaque");
        System.out.println("2: Améliorer ta défense");
        int input = readInt("-> ", 2);
        if(input ==1){
            printHeading("Tu as amélioré ton attaque !");
            wizard.setAtk(wizard.getAtk()+10);
        }else{
            printHeading("Tu as amélioré ta défense !");
            wizard.setDef(wizard.getDef()+10);
        }
        anythingToContinue();
    }

    public void healWizard(Wizard wizard){
        wizard.setHp(wizard.getMaxhp());
    }

    public void tutoDefend(){
        System.out.println("Tu vas maintenant apprendre le spell Protego.");
        System.out.println("Il te servira à te défendre contre les ennemies");
        System.out.println("Tu devras écrire 'défense' en moins de 4 secondes");
        System.out.println("Tiens-toi prêt !");
        anythingToContinue();
        boolean defend = Wizard.defend();
        if (defend){
            System.out.println("Tu as réussi");
        } else{
            System.out.println("Tu as échoué");
        }
        anythingToContinue();
    }

    public void deathEaterChoice(){
        boolean deatheater = false;
        if (Objects.equals(wizard.getHouse().getName(), "Slytherin")){
            System.out.println("Tu as tué 3 Mangemorts.");
            System.out.println("Voldemort te demande de le rejoindre.");
            System.out.println("Acceptes-tu ? ");
            System.out.println("(1) Yes\n(2) No");
            int choose = readInt("->", 2);
            if (choose == 1){
                deatheater = true;
                System.out.println("Tu es maintenant un Mangemort");
                anythingToContinue();
                wizard.setDeathEater(deatheater);
            }
        }
    }

}
