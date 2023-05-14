package scenes;

import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene26 extends Scene {
    public Scene26(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Button charButton = new Button("Ton sorcier");

        charButton.setOnAction(event -> {
            Scene27 scene27 = new Scene27(stage, wizard);
            stage.setScene(scene27);
        });

        Button spellButton = new Button("Spells appris");

        spellButton.setOnAction(event -> {
            Scene28 scene28 = new Scene28(stage, wizard);
            stage.setScene(scene28);
        });

        Button continueButton = new Button("CONTINUER");

        continueButton.setOnAction(event -> {
            Scene30 scene30 = new Scene30(stage, wizard);
            stage.setScene(scene30);
        });

        root.getChildren().addAll(charButton, spellButton, continueButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
