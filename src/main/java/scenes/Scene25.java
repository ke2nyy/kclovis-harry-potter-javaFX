package scenes;

import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene25 extends Scene {
    public Scene25(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Choisis une amélioration :");
        RadioButton option1 = new RadioButton("Améliorer l'attaque \uD83D\uDDE1");
        RadioButton option2 = new RadioButton("Améliorer la défense \uD83D\uDEE1");

        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);

        Button submitButton = new Button("Continuer");
        submitButton.setOnAction(event -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                wizard.setAtk(wizard.getAtk()+10);
            } else if (selectedOption == option2) {
                wizard.setDef(wizard.getDef()+10);
            }
            Scene16 scene16 = new Scene16(stage,wizard);
            stage.setScene(scene16);
        });

        root.getChildren().addAll(label1, option1, option2, submitButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
