package com.isep.hpah.core;

import com.isep.hpah.spells.Spell;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEnemy extends Character {
    public AbstractEnemy(String name, int maxHp, int atk, int def) {
        super(name, maxHp, atk, def);
    }

    public abstract int attack1(Character character);

    public abstract int attack(Character character, Spell spell);
}

