package scenes;

import com.isep.hpah.core.Game;
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

public class Scene3 extends Scene {
    public Scene3(Stage stage, Wizard wizard){
        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Choisis à présent un trait de caractère qui te définira :");
        RadioButton option1 = new RadioButton("Détermination");
        RadioButton option2 = new RadioButton("Bravoure");
        RadioButton option3 = new RadioButton("Loyauté");
        RadioButton option4 = new RadioButton("Sagesse");

        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        Game game= new Game();
        game.setupHouse();

        Button submitButton = new Button("Confirmer");
        submitButton.setOnAction(event -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
                if (selectedOption == option1) {
                    wizard.setHouse(game.setupHouse().get(0));
                    wizard.setAtk(120);
                } else if (selectedOption == option2) {
                    wizard.setHouse(game.setupHouse().get(1));
                    wizard.setDef(120);
                } else if (selectedOption == option3) {
                    wizard.setHouse(game.setupHouse().get(2));
                } else if (selectedOption == option4) {
                    wizard.setHouse(game.setupHouse().get(3));
                }
            if (selectedOption != null) {
                Scene4 scene4 = new Scene4(stage, wizard);
                stage.setScene(scene4);
            }
        });

        root.getChildren().addAll(label1, option1, option2, option4, option3, submitButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }


}
