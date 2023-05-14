package scenes;

import com.isep.hpah.core.Pet;
import com.isep.hpah.core.wand.Core;
import com.isep.hpah.core.wand.Wand;
import com.isep.hpah.core.Wizard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;

public class Scene4 extends Scene {
    public Scene4(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Tu es maintenant prêt à aller à Poudlard !");
        Label label2 = new Label("Bienvenue à Poudelard! Professeur McGonagall va placer le Choixpeau sur ta tête pour déterminer ta maison...." +
                "\nhmmmm... "+wizard.getHouse().getName()+". Félictations!! C'est une très bonne maison.");
        if (Objects.equals(wizard.getHouse().getName(), "Slytherin")){
            label2.setTextFill(Color.GREEN);
        } else if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
            label2.setTextFill(Color.RED);
        } else if (Objects.equals(wizard.getHouse().getName(), "Hufflepuff")){
            label2.setTextFill(Color.ORANGE);
        } else if (Objects.equals(wizard.getHouse().getName(), "Ravenclaw")){
            label2.setTextFill(Color.BLUE);
        }


        int size = 20 + (int) (Math.random() * ((35 - 20) + 1));

        Wand wand = new Wand(size, Core.assignCore());
        wizard.setWand(wand);
        Label label4 = new Label(" La baguette magique venue de chez Ollivander vous a choisie !\n" +
                " Vous avez reçu une baguette à base de "+wizard.getWand().getCore()+" de " +wizard.getWand().getSize()+" cm.");

        Font fontScene4 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20);
        label2.setFont(fontScene4);

        Label label3 = new Label("Il est temps de choisir ton animal de compagnie :");
        RadioButton option1 = new RadioButton("Owl");
        RadioButton option2 = new RadioButton("Cat");
        RadioButton option3 = new RadioButton("Rat");
        RadioButton option4 = new RadioButton("Toad");

        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        Button submitButtons = new Button("Confirmer");
        submitButtons.setOnAction(event -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                wizard.setPet(Pet.Owl);
            } else if (selectedOption == option2) {
                wizard.setPet(Pet.Cat);
            } else if (selectedOption == option3) {
                wizard.setPet(Pet.Rat);
            } else if (selectedOption == option4) {
                wizard.setPet(Pet.Toad);
            }
            if (selectedOption != null) {
                Scene5 scene5 = new Scene5(stage, wizard);
                stage.setScene(scene5);
            }
        });

        root.getChildren().addAll(label1, label2, label4, label3, option1, option3, option2, option4, submitButtons);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");
    }
}