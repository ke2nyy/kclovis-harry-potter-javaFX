package scenes;

import com.isep.hpah.core.Wizard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene1 extends Scene {
    public Scene1(Stage stage) {

        super(new VBox(), 1100, 600);
        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);

        Label label1 = new Label("Bonjour jeune sorcier! Comment t'appelles-tu ?");
        TextField textField = new TextField();
        textField.setMaxWidth(350);
        textField.setMinHeight(40);
        textField.setPromptText("");
        Button validateName = new Button("Confirmer");

        EventHandler<ActionEvent> buttonHandler = event -> {
            if(textField.getText().length() > 0){
                String playerName = textField.getText();
                Wizard wizard = new Wizard(playerName,100,100,100,null,null,null,null,null);
                Scene2 scene2 = new Scene2(stage, wizard);
                stage.setScene(scene2);
            }
        };
        validateName.setOnAction(buttonHandler);
        EventHandler<KeyEvent> enterHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if(textField.getText().length() > 0){
                    buttonHandler.handle(new ActionEvent());
                }
            }
        };
        textField.setOnKeyPressed(enterHandler);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        Region leftSpacer = new Region();
        Region rightSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        hbox.getChildren().addAll(leftSpacer, validateName, rightSpacer);

        root.getChildren().addAll(label1, textField, hbox);
        root.setStyle("-fx-background-color: #CCCCCC; -fx-font-family: Arial;");

    }
}