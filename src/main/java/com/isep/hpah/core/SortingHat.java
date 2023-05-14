package com.isep.hpah.core;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class SortingHat {

    Game game = new Game();

    public House assignHouse() {
        game.setupHouse();

        RadioButton option1 = new RadioButton("Option 1");
        RadioButton option2 = new RadioButton("Option 2");
        RadioButton option3 = new RadioButton("Option 3");
        RadioButton option4 = new RadioButton("Option 4");

        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        Button submitButton = new Button("Soumettre");
        submitButton.setOnAction(event -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption != null) {
                System.out.println("Option sélectionnée : " + selectedOption.getText());
            } else {
                System.out.println("Aucune option sélectionnée");
            }
        });

        VBox vbox = new VBox(10, option1, option2, option3, option4, submitButton);
        vbox.setPadding(new Insets(10));
        return null;
    }

}
