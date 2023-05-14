package scenes;

import com.isep.hpah.spells.Spell;
import com.isep.hpah.core.Game;
import com.isep.hpah.core.Potion;
import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Scene5 extends Scene {
    public Scene5(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("TON SORCIER");

        Label label2 = new Label("Nom : "+wizard.getName()+"\nMaison : "+wizard.getHouse().getName()+"\nBaguette: "+wizard.getWand().getCore()+
                " de "+wizard.getWand().getSize()+" cm \nAnimal : "+wizard.getPet()+"\nHP : "+wizard.getMaxhp()+"\nAttaque : "+wizard.getAtk()+"\nDéfense : "+wizard.getDef());
        Game game = new Game();

        game.setupSpells();
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(game.setupSpells().get(0));
        knownSpells.add(game.setupSpells().get(1));
        wizard.setSpellsKnown(knownSpells);

        game.setupPotions();
        List<Potion> ownedPotions = new ArrayList<>();
        ownedPotions.add(game.setupPotions().get(0));
        ownedPotions.add(game.setupPotions().get(0));
        wizard.setPotionsOwned(ownedPotions);

        Button nextButton = new Button("Continuer");

        nextButton.setOnAction(event -> {
            Scene7 scene7 = new Scene7(stage, wizard);
            stage.setScene(scene7);
        });

        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");


    }
}
