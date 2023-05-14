package scenes;

import com.isep.hpah.core.Enemy;
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

public class Scene9 extends Scene {
    public Scene9(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("NIVEAU 1 - THE PHILOSOPHER'S STONE");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.RED);
        Label label2 = new Label("Vous devez affronter le méchant Troll qui se trouve dans les toilettes à côté du Donjon. Pour le \n " +
                "vaincre, vous devez soulever des objets et les relâcher lorsqu’ils se trouvent au-dessus de sa tête.");

        Enemy troll;
        troll = new Enemy("Troll", 100, 40, 200);

        Button nextButton = new Button("Combattre le troll");

        nextButton.setOnAction(event -> {
            Scene10 scene10 = new Scene10(stage, wizard, troll);
            stage.setScene(scene10);
        });


        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");
    }
}
