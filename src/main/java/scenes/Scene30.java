package scenes;

import com.isep.hpah.spells.Spell;
import com.isep.hpah.core.Enemy;
import com.isep.hpah.core.Game;
import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class Scene30 extends Scene {
    public Scene30(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("NIVEAU 3 - The Prisonner of Azkaban");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        Label label2 = new Label("Les Détraqueurs sont en liberté. Ils errent dans les rues, les campagnes. Heureusement, vous avez");
        Label label3 = new Label("entendu parler d’un sort pour les mettre en fuite... Expect... Expecta... Ah oui, Expectro Patronum. " +
                "\n Votre objecif est d’apprendre le sort, puis de l’utiliser pour vaincre les Détraqueurs.");

        Game game = new Game();

        Enemy dementors;
        dementors = new Enemy("Détraqueurs", 100, 40,50);
        List<Spell> knownSpells = wizard.getSpellsKnown();
        knownSpells.add(game.setupSpells().get(4));
        wizard.setSpellsKnown(knownSpells);
        Label label5 = new Label("Vous venez d'apprendre le spell Expecto Patronum");
        wizard.setHp(wizard.getMaxhp());

        Button nextButton = new Button("Combattre les Détraqueurs");


        nextButton.setOnAction(event -> {
            Scene31 scene31 = new Scene31(stage, wizard, dementors);
            stage.setScene(scene31);
        });


        root.getChildren().addAll(label1, label2, label3, label5, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
