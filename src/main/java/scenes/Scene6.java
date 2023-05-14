package scenes;

import com.isep.hpah.spells.Spell;
import com.isep.hpah.core.Wizard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene6 extends Scene {
    public Scene6(Stage stage, Wizard wizard) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);



        ObservableList<Spell> spells = FXCollections.observableList(wizard.getSpellsKnown());

        ListView<Spell> listView = new ListView<>(spells);
        listView.setCellFactory(param -> new ListCell<Spell>() {
            @Override
            protected void updateItem(Spell spell, boolean empty) {
                super.updateItem(spell, empty);

                if (empty || spell == null) {
                    setText(null);
                } else {
                    setText(spell.getName() + " - " + spell.getEffect() + " - Dégats : " + spell.getDamage());
                }
            }
        });

        Button nextButton = new Button("Retour");

        nextButton.setOnAction(event -> {
            Scene7 scene7 = new Scene7(stage, wizard);
            stage.setScene(scene7);
        });

        root.getChildren().addAll(listView, nextButton);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        stage.setTitle("Harry Potter At Home");

    }
}
