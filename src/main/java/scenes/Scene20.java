package scenes;

import com.isep.hpah.spells.Spell;
import com.isep.hpah.core.Enemy;
import com.isep.hpah.core.Game;
import com.isep.hpah.core.Potion;
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

public class Scene20 extends Scene {
    public Scene20(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("NIVEAU 2 - The Chamber of Secrets");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        Label label2 = new Label("Vous êtes face au terrible basilic. Si vous êtes de Griffondor, vous pouvez faire appel à l’épée");
        Label label3 = new Label("légendaire de Godric Gryffindor pour le terrasser. Sinon, il faudra lui arracher un de ses ");
        Label label4 = new Label("crocs et l’utiliser pour détruire le journal de Tom Jedusor.");

        Game game= new Game();

        Enemy basilisk;
        basilisk = new Enemy("Basilic",100,30,300);


        List<Spell> knownSpells = wizard.getSpellsKnown();
        knownSpells.add(game.setupSpells().get(3));
        wizard.setSpellsKnown(knownSpells);

        List<Potion> potionsowned = wizard.getPotionsOwned();
        potionsowned.add(game.setupPotions().get(1));
        wizard.setPotionsOwned(potionsowned);

        Label label5 = new Label("Vous avez appris à utiliser Accio, un nouveau spell !");
        wizard.setHp(wizard.getMaxhp());

        Button nextButton = new Button("Combattre basilic");


        nextButton.setOnAction(event -> {
            Scene21 scene21 = new Scene21(stage, wizard, basilisk);
            stage.setScene(scene21);
        });


        root.getChildren().addAll(label1, label2, label3, label4, label5, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
