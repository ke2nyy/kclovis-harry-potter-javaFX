package scenes;

import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene27 extends Scene {
    public Scene27(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("TON SORCIER");

        Label label2 = new Label("Nom : "+wizard.getName()+"\nMaison : "+wizard.getHouse().getName()+"\nBaguette: "+wizard.getWand().getCore()+
                " de "+wizard.getWand().getSize()+" cm \nAnimal : "+wizard.getPet()+"\nHP : "+wizard.getMaxhp()+"\nAttaque : "+wizard.getAtk()+"\nDéfense : "+wizard.getDef());

        Button nextButton = new Button("Continuer");

        nextButton.setOnAction(event -> {
            Scene26 scene26 = new Scene26(stage, wizard);
            stage.setScene(scene26);
        });

        root.getChildren().addAll(label1, label2, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");


    }
}
