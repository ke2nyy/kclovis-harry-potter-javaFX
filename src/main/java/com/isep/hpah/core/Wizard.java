package com.isep.hpah.core;

import com.isep.hpah.spells.ForbiddenSpell;
import com.isep.hpah.spells.Spell;
import com.isep.hpah.core.wand.Wand;
import com.isep.hpah.support.ConsoleColors;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Wizard extends Character {
    private House house;
    private Pet pet;
    private Wand wand;
    private static List spellsKnown;
    private static List potionsOwned;
    private boolean deathEater;


    public Wizard(String name, int maxHp, int atk, int def, House house, Pet pet, Wand wand, List spellsKnown, List potionsOwned) {
        super(name, maxHp, atk, def);
        this.house = house;
        this.pet = pet;
        this.wand = wand;
        this.spellsKnown = spellsKnown;
        this.potionsOwned = potionsOwned;
        this.deathEater = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public List<Spell> getSpellsKnown() {
        return spellsKnown;
    }

    public void setSpellsKnown(List<Spell> knownSpells) {
        this.spellsKnown = knownSpells;
    }

    public List<Potion> getPotionsOwned(){
        return potionsOwned;
    }

    public void setPotionsOwned(List<Potion> potionsOwned) {
        this.potionsOwned = potionsOwned;
    }

    public boolean getDeathEater(){
        return deathEater;
    }

    public void setDeathEater(boolean deathEater){
        this.deathEater = deathEater;
    }

    @Override
    public int attack(Spell spell, Character character) {
        int miss = 1 + (int) (Math.random() * ((100 - 1) + 1));
        if (Objects.equals(getHouse().getName(), "Ravenclaw")){
            miss = miss-10;
        }
        if (miss <= spell.getAccuracy()) {
            int damage = spell.getDamage() * ((getAtk() / 5 - character.getDef() / 10) * 1 / 10);
            if (damage <= 0){
                damage = 0;
            }
            System.out.println("Tu as jeté " + spell.getName() + " sur " + character.getName() + ". Tu as fait " + ConsoleColors.RED + damage);
            return damage;
        }
        else{
            int damage = 0;
            System.out.println("Tu as manqué ton spell.");
            return damage;
        }

    }

    @Override
    public int attack1(Character character) {
        return 0;
    }

    @Override
    public int attack2(ForbiddenSpell forbiddenSpell, Character character) {
        return 0;
    }


    public void takeDamage(int damage){
        if (damage<=0){
            damage = 0;
        }
        if (damage>=100){
            damage = 100;
        }
        setHp(getHp()-damage);
    }

    public Potion getPotionByName(String name) {
        for (Potion potion : getPotionsOwned()) {
            if (potion.getName().equals(name)) {
                return potion;
            }
        }
        return null;
    }

    public static boolean defend(){

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Ecris 'défense' en moins de 4 secondes : ");
        long startTime = System.currentTimeMillis();
        String word = scanner.next();
        long endTime = System.currentTimeMillis();
        if (endTime - startTime <= 4000){
            if (word.equalsIgnoreCase("défense")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void addSpell(Spell spell){
        spellsKnown.add(spell);
    }

}

