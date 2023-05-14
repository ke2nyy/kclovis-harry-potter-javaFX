package scenes;

import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene16 extends Scene {
    public Scene16(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Button charButton = new Button("Ton sorcier");

        charButton.setOnAction(event -> {
            Scene17 scene17 = new Scene17(stage, wizard);
            stage.setScene(scene17);
        });

        Button spellButton = new Button("Spells appris");

        spellButton.setOnAction(event -> {
            Scene18 scene18 = new Scene18(stage, wizard);
            stage.setScene(scene18);
        });

        Button continueButton = new Button("CONTINUER");

        continueButton.setOnAction(event -> {
            Scene20 scene20 = new Scene20(stage, wizard);
            stage.setScene(scene20);
        });

        root.getChildren().addAll(charButton, spellButton, continueButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
