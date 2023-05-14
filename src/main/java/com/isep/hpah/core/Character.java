package com.isep.hpah.core;

import com.isep.hpah.spells.ForbiddenSpell;
import com.isep.hpah.spells.Spell;

public abstract class Character {

    public String name;
    public int maxHp;
    public int hp;
    public int atk;
    public int def;

    public Character(String name, int maxHp, int atk, int def) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
    }

    public int attack(Spell spell, Character character){
        return 0;
    }

    public abstract int attack1(Character character);

    public abstract int attack2(ForbiddenSpell forbiddenSpell, Character character);

    public void takeDamage(int damage){

    }

    public String getName() {return name;}

    public int getHp() {
        return hp;
    }

    public void setHp(int i) {
        this.hp = i;
    }

    public int getMaxhp(){
        return maxHp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int i) {
        this.atk = i;
    }

    public int getDef() {return def;}

    public void setDef(int i) {this.def = i;}

}