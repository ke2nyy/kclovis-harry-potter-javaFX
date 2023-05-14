package com.isep.hpah.core;

import static com.isep.hpah.core.Game.wizard;

public class Level {

    Game game= new Game();

    Story story = new Story();

    public void level1(){
        /* Level 1 */

        game.gameLoop();
        story.level1Intro();
        Enemy troll;
        troll = new Enemy("Troll", 100, 40, 200);
        game.anythingToContinue();
        System.out.println("Un ennemi est apparu : "+troll.getName());
        game.anythingToContinue();
        game.battle1(troll);
        story.level1Outro();
        game.healWizard(wizard);
        game.chooseUpgrade(wizard);
    }

    public void level2(){
        /* Level 2 */

        game.addPotion(game.setupPotions().get(1));
        game.map = 1;
        game.gameLoop();
        game.learnSpell(game.setupSpells().get(3));
        game.anythingToContinue();
        story.level2Intro();
        Enemy basilisk;
        basilisk = new Enemy("Basilic",1000,30,300);
        System.out.println("Un ennemi est apparu : "+basilisk.getName());
        game.battle2(basilisk);
        story.level2Outro();
        game.anythingToContinue();
        game.healWizard(wizard);
        game.chooseUpgrade(wizard);
    }

    public void level3(){
        /* Level 3 */

        game.map = 2;
        game.gameLoop();
        game.learnSpell(game.setupSpells().get(4));
        game.anythingToContinue();
        story.level3Intro();
        Enemy dementors;
        dementors = new Enemy("Détraqueurs", 100, 40,50);
        System.out.println("Des ennemis sont apparus : "+dementors.getName());
        game.battle3(dementors);
        story.level3Outro();
        game.anythingToContinue();
        game.healWizard(wizard);
    }

    public void level4(){
        /* Level 4 */

        game.addPotion(game.setupPotions().get(1));
        game.map = 3;
        game.chooseUpgrade(wizard);
        game.learnSpell(game.setupSpells().get(2));
        game.gameLoop();
        story.level4Intro();
        Boss voldemort;
        voldemort = new Boss("Voldemort", 500, 170, 100, game.setupForbiddenSpells(), null);
        Boss peter_pettigrew;
        peter_pettigrew = new Boss("Peter Pettigrew", 100, 130, 30, game.setupForbiddenSpells(), null);
        game.tutoDefend();
        System.out.println("Tu t'apprêtes à combattre Voldemort et Peter Pettigrew. Garde en tête que ton spell Accio a une portée de 50m");
        System.out.println("Pas certain que tu fasses le poids... tu devrais t'enfuir");
        game.battle4(voldemort, peter_pettigrew);
        story.level4Outro();
        game.anythingToContinue();
        game.healWizard(wizard);
    }

    public void level5(){
        /* Level 5 */

        game.addPotion(game.setupPotions().get(2));
        game.map = 4;
        game.chooseUpgrade(wizard);
        game.learnSpell(game.setupSpells().get(5));
        game.gameLoop();
        story.level5Intro();
        game.level5spellsKnown();
        Boss ombrage;
        ombrage = new Boss("Dolores Ombrage", 600, 160, 60, null, game.level5spellsKnown());
        System.out.println("Tu t'apprêtes à combattre Dolores Ombrage.");
        game.anythingToContinue();
        System.out.println("C'est partit !");
        game.anythingToContinue();
        game.battle5(ombrage);
        story.level5Outro();
        game.anythingToContinue();
        game.healWizard(wizard);
    }

    public void level6(){
        /* Level 6 */

        game.addPotion(game.setupPotions().get(2));
        game.map = 5;
        game.chooseUpgrade(wizard);
        game.learnSpell(game.setupSpells().get(6));
        game.gameLoop();
        story.level6Intro();

        Boss deathEater1;
        Boss deathEater2;
        Boss deathEater3;
        deathEater1 = new Boss("Mangemort1", 200,140,60, game.setupForbiddenSpells(), null);
        deathEater2 = new Boss("Mangemort2", 200, 140, 60, game.setupForbiddenSpells(), null);
        deathEater3 = new Boss("Mangemort3", 200, 140, 60, game.setupForbiddenSpells(), null);
        System.out.println("Tu vas te battre contre 3 Mangemorts");
        game.anythingToContinue();
        game.battle6(deathEater1, deathEater2, deathEater3);
        story.level6Outro();
        game.anythingToContinue();
        game.healWizard(wizard);
        game.deathEaterChoice();

    }

    public void level7(){
        /* Level 7 */

        game.addPotion(game.setupPotions().get(2));
        game.map = 6;
        game.chooseUpgrade(wizard);
        game.gameLoop();

        if (!wizard.getDeathEater()) {
            story.level7Intro();
            Boss voldemort;
            voldemort = new Boss("Voldemort", 500, 180, 100, game.setupForbiddenSpells(), null);
            Boss belatrix;
            belatrix = new Boss("Belatrix Lestrange", 400, 160, 80, game.setupForbiddenSpells(), null);
            System.out.println("C'est l'heure du combat final ! Tu vas affronter Voldemort and Belatrix Lestrange");
            game.anythingToContinue();
            game.battle7(voldemort, belatrix);
            game.anythingToContinue();
            story.level7Outro();
        } else if (wizard.getDeathEater()){
            story.level7Introbis();
            Boss potter;
            potter = new Boss("Harry Potter", 500, 180, 100, game.setupForbiddenSpells(), null);
            Boss albus;
            albus = new Boss("Albus Dumbledore", 400, 160, 80, game.setupForbiddenSpells(), null);
            System.out.println("OH ! Tu doit affronter Harry Potter and Albus Dumbledore");
            game.anythingToContinue();
            game.battle7(potter, albus);
            game.anythingToContinue();
            story.level7Outrobis();
        }

    }



}
