package com.isep.hpah.core;

import com.isep.hpah.spells.ForbiddenSpell;
import com.isep.hpah.spells.Spell;
import com.isep.hpah.support.ConsoleColors;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Enemy extends AbstractEnemy {

    public Enemy(String name, int maxHp, int atk, int def) {
        super(name, maxHp, atk, def);

    }



    @Override
    public int attack(Spell spell, Character character) {
        return 0;
    }

    @Override
    public int attack1(Character character) {
        int damage = getAtk() - character.getDef()/5;
        if (damage <= 0){
            damage = 0;
        }
        System.out.println("L'ennemi a fait "+ ConsoleColors.RED + damage+" dégats");
        return damage;
    }

    @Override
    public int attack(Character character, Spell spell) {
        return 0;
    }

    @Override
    public int attack2(ForbiddenSpell forbiddenSpell, Character character) {
        return 0;
    }

    @Override
    public void takeDamage(int damage){

        setHp(getHp()-damage);
        if (getHp() <= 0){
            setHp(0);
        }
    }

}
