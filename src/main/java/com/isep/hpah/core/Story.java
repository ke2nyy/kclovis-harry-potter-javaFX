package com.isep.hpah.core;

public class Story {

    Game game = new Game();

    public void level1Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 1 - The Philosopher’s Stone");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Vous devez affronter le méchant Troll qui se trouve dans les toilettes à côté du Donjon. Pour le\n" +
                "vaincre, vous devez soulever des objets et les relâcher lorsqu’ils se trouvent au-dessus de sa tête.");
    }

    public void level1Outro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("Bravo ! L'ennemi est mort.");
        game.anythingToContinue();
    }

    public void level2Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 2 - The Chamber of Secrets");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Vous êtes face au terrible basilic. Si vous êtes de Griffondor, vous pouvez faire appel à l’épée\n" +
                "légendaire de Godric Gryffindor pour le terrasser. Sinon, il faudra lui arracher un de ses crocs et\n" +
                "l’utiliser pour détruire le journal de Tom Jedusor.");
        game.anythingToContinue();
    }

    public void level2Outro(){
        game.printSeperator(30);
        System.out.println("Bravo ! L'ennemi est mort.");
    }

    public void level3Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 3 - The Prisonner of Azkaban");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Les Détraqueurs sont en liberté. Ils errent dans les rues, les campagnes. Heureusement, vous avez\n" +
                "entendu parler d’un sort pour les mettre en fuite... Expect... Expecta... Ah oui, Expectro Patronum.\n" +
                "Votre objecif est d’apprendre le sort, puis de l’utiliser pour vaincre les Détraqueurs.");
        game.anythingToContinue();
    }

    public void level3Outro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("Bravo ! L'ennemi est mort. ");
    }

    public void level4Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 4 - The Goblet of Fire");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Par malheur, vous avez remporté le Tournoi des Trois Sorciers... et le droit de mourir. Vous êtes\n" +
                "dans un cimetière, où se trouvent aussi Voldemort et Peter Pettigrew. Votre seule chance de fuite est\n" +
                "de vous rapprocher du Portkey pour l’attirer à vous. Ne vous inquiétez pas, vous reverrez\n" +
                "Voldemort.");
        game.anythingToContinue();
    }

    public void level4Outro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("You have succeeded to push back Voldemort and are back at Hogwarts");
        System.out.println("However, you seem destined to fight him again...");
    }

    public void level5Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 5 - The Order of the Phenix");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("C’est l’heure du BUSE (Brevet Universel de Sorcellerie Élémentaire) ! Dolores Ombrage veille sur\n" +
                "le grain. Votre objectif est de la distraire le temps que les feux d’artifice soient prêts à être utilisés.");
        game.anythingToContinue();
    }

    public void level5Outro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("Cela a fonctionné, bravo ! Ta cinquième année d'achève.");
    }

    public void level6Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 6 - The Half-Blood Prince");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Les Mangemorts attaquent Poudlard. Êtes-vous prêts à vous défendre ? Vous devez les attaquer de face.");
        game.anythingToContinue();
    }

    public void level6Outro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("Tu as défendu Poudlard!");
        System.out.println("Plus qu'un an avant le diplôme.");
    }

    public void level7Intro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 7 - The Deathly Hallows");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Trêve de tergiversations, il faut attaquer le problème à la source. Vous êtes face à Voldemort et a\n" +
                "Bellatrix Lestrange. Faites attention, ils peuvent vous tuer d’un coup avec Avada Kedavra si vous\n" +
                "n’êtes pas prêts.");
        game.anythingToContinue();
    }

    public void level7Outro(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("Tu as vaincu Voldemort !!!");
        System.out.println("Tu vas être diplômé dans très peu de temps");
        game.anythingToContinue();
    }

    public void level7Introbis(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("NIVEAU 7 - The Deathly Hallows");
        game.anythingToContinue();
        game.printSeperator(30);
        System.out.println("Tu as rejoint les Mangemorts, tu vas trahir tout tes amis et détruire Poudlard. \n Tu vas combattre Harry Potter et Albus Dumbledore");
        game.anythingToContinue();
    }

    public void level7Outrobis(){
        game.clearConsole();
        game.printSeperator(30);
        System.out.println("OH ! Tu as détruit Poudlard.");
        game.anythingToContinue();
    }

}
