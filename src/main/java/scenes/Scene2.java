package scenes;

import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Scene2 extends Scene {
    public Scene2(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Bienvenue " + wizard.getName()+" !");
        Button nextButton = new Button("Lancer l'aventure");

        nextButton.setOnAction(event -> {
            Scene3 scene3 = new Scene3(stage, wizard);
            stage.setScene(scene3);
        });


        root.getChildren().addAll(label1, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");

        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }

}