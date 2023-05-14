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

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Scene22 extends Scene {
    public Scene22(Stage stage, Wizard wizard, Enemy basilisk) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Quel spell veut-tu utiliser ? : ");

        RadioButton option1 = new RadioButton("Expelliarmus");
        RadioButton option2 = new RadioButton("Wingardium Leviosa");
        RadioButton option3 = new RadioButton("Accio");

        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);

        Label label2 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = new Label();

        AtomicInteger i = new AtomicInteger();

        Button submitButton = new Button("Valider");
        Button backButton = new Button("Retour");
        Button nextButton = new Button("Continuer");
        Button endButton = new Button("Continuer");
        nextButton.setVisible(false);
        endButton.setVisible(false);
        submitButton.setOnAction(event -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption == option1) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(0), basilisk);
                basilisk.takeDamage(damage);
                label4.setText("Tu as fais "+ damage+" dégâts");
                if (damage == 0){
                    label4.setTextFill(Color.RED);
                } else {
                    label4.setTextFill(Color.GREEN);
                }
                submitButton.setVisible(false);
                backButton.setVisible(false);
                nextButton.setVisible(true);
            } else if (selectedOption == option2) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(1), basilisk);
                basilisk.takeDamage(damage);
                basilisk.setDef(10);
                label4.setText("Tu as fait "+damage+" dégâts");
                label4.setTextFill(Color.RED);
                submitButton.setVisible(false);
                backButton.setVisible(false);
                nextButton.setVisible(true);
            } else if (selectedOption == option3) {
                int damage = wizard.attack(wizard.getSpellsKnown().get(2), basilisk);
                basilisk.takeDamage(damage);
                if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
                    basilisk.setHp(0);
                    label7.setText("Tu viens de te munir de la légandaire épée Godric de Gryffindor ! Tu peux maintenant tuer Basilic facilement et détruire le journal.");
                    label7.setTextFill(Color.ORANGE);
                    basilisk.setHp(0);
                    submitButton.setVisible(false);
                    backButton.setVisible(false);
                    nextButton.setVisible(true);
                } else {
                    label4.setText("Tu as fait " + damage + " dégâts");
                    label4.setTextFill(Color.RED);
                    label8.setText("Survis jusqu'à ce que tu puisses détruire le journal !");
                    submitButton.setVisible(false);
                    backButton.setVisible(false);
                    endButton.setVisible(true);
                }

            }





            int damage1 = basilisk.attack1(wizard);
            wizard.takeDamage(damage1);

            label6.setText("Basilic a fait "+damage1+" dégâts");
            label6.setTextFill(Color.RED);
        });





        Label labelend = new Label();
        Label labelend2 = new Label();
        Button endButton2 = new Button("S'approcher");
        Button endButton3 = new Button("Détruire le journal");
        endButton2.setVisible(false);
        endButton3.setVisible(false);

        endButton.setOnAction(event -> {
            labelend.setText("Tu t'approches de plus en plus du journal.");
            int damage1 = basilisk.attack1(wizard);
            wizard.takeDamage(damage1);

            label6.setText("Basilic a fait "+damage1+" dégâts");
            label6.setTextFill(Color.RED);
            endButton.setVisible(false);
            endButton2.setVisible(true);
        });

        endButton2.setOnAction(event -> {
            labelend2.setText("Tu y es presque !");
            int damage1 = basilisk.attack1(wizard);
            wizard.takeDamage(damage1);

            label6.setText("Basilic a fait "+damage1+" dégâts");
            label6.setTextFill(Color.RED);
            endButton3.setVisible(true);
        });

        endButton2.setOnAction(event -> {
            labelend2.setText("Tu as tué Basilic et détruis le journal. Tu l'as fait !");
            basilisk.setHp(0);
            endButton2.setVisible(false);
            nextButton.setVisible(true);
        });

        backButton.setOnAction(event -> {
            Scene21 scene21 = new Scene21(stage,wizard,basilisk);
            stage.setScene(scene21);
        });

        nextButton.setOnAction(event -> {
            if (basilisk.getHp() == 0){
                Scene24 scene24 = new Scene24(stage,wizard);
                stage.setScene(scene24);
            } else if (wizard.getHp() == 0) {
                Scene100 scene100 = new Scene100(stage,wizard);
                stage.setScene(scene100);
            }
            else {
                Scene21 scene21 = new Scene21(stage, wizard, basilisk);
                stage.setScene(scene21);
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
            if (option3.isSelected()) {
                label2.setText(wizard.getSpellsKnown().get(2).getEffect() + " : "+wizard.getSpellsKnown().get(2).getDamage()+" dégâts");
            }
        });

        root.getChildren().addAll(label1, option1, option2, option3, submitButton, backButton, label2, label5, label4, label6, label7, label8, labelend, labelend2, nextButton, endButton, endButton2, endButton3);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
