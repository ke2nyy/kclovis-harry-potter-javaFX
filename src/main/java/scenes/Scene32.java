package scenes;

import com.isep.hpah.core.Enemy;
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
import javafx.stage.Stage;
public class Scene32 extends Scene {
    public Scene32(Stage stage, Wizard wizard, Enemy dementors) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Quel spell veut-tu utiliser ? :");

        RadioButton option1 = new RadioButton("Expelliarmus");
        RadioButton option2 = new RadioButton("Wingardium Leviosa");
        RadioButton option3 = new RadioButton("Accio");
        RadioButton option4 = new RadioButton("Expecto Patronum");

        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);

        Label label2 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();

        Button submitButton = new Button("Valider");
        Button backButton = new Button("Retour");
        Button nextButton = new Button("Continuer");
        nextButton.setVisible(false);
        submitButton.setOnAction(event -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(0), dementors);
                dementors.takeDamage(damage);
                label4.setText("Tu as fais "+damage+" dégâts");
                if (damage == 0){
                    label4.setTextFill(Color.RED);
                } else {
                    label4.setTextFill(Color.GREEN);
                }
            } else if (selectedOption == option2) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(0), dementors);
                dementors.takeDamage(damage);
                dementors.setDef(10);
                label4.setText("Tu as fais "+damage+" dégâts");
                label5.setText("L'ennemi est sans défense, utilise maintenant un spell !");
            }


            if (selectedOption != null) {
                submitButton.setVisible(false);
                backButton.setVisible(false);
                nextButton.setVisible(true);
                int damage1 = dementors.attack1(wizard);
                wizard.takeDamage(damage1);

                label6.setText("Les Détraqueurs ont fait " + damage1 + " dégâts");
                label6.setTextFill(Color.RED);
            }
        });

        backButton.setOnAction(event -> {
            Scene31 scene31 = new Scene31(stage,wizard,dementors);
            stage.setScene(scene31);
        });

        nextButton.setOnAction(event -> {
            if (dementors.getHp() <= 0){
                Scene34 scene34 = new Scene34(stage,wizard);
                stage.setScene(scene34);
            } else if (wizard.getHp() <= 0) {
                Scene100 scene100 = new Scene100(stage,wizard);
                stage.setScene(scene100);
            }
            else {
                Scene31 scene31 = new Scene31(stage, wizard, dementors);
                stage.setScene(scene31);
            }
        });

        option1.setOnAction(e -> {
            if (option1.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(0).getEffect() + " : "+wizard.getSpellsKnown().get(0).getDamage()+" dégâts");
            }
        });


        option2.setOnAction(e -> {
            if (option2.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(1).getEffect() + " : "+wizard.getSpellsKnown().get(1).getDamage()+" dégâts");
            }
        });

        option3.setOnAction(e -> {
            if (option2.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(1).getEffect() + " : "+wizard.getSpellsKnown().get(1).getDamage()+" dégâts");
            }
        });

        option4.setOnAction(e -> {
            if (option2.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(1).getEffect() + " : "+wizard.getSpellsKnown().get(1).getDamage()+" dégâts");
            }
        });

        root.getChildren().addAll(label1, option1, option2, option3, option4, submitButton, backButton, label2, label5, label4, label6, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
