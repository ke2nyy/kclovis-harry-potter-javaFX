package scenes;

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

public class Scene24 extends Scene {
    public Scene24(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("NIVEAU 2 TERMINÉ");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        Label label2 = new Label("Tu as gagné, bravo ! Tu mérites du repos.");

        Button nextButton = new Button("Continuer");

        nextButton.setOnAction(event -> {
            Scene25 scene25 = new Scene25(stage,wizard);
            stage.setScene(scene25);
        });

        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
