package edu.isu.cs.cs2263.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonActions extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Button Actions Experiment");

        Label label = new Label("Not Clicked");
        Button button = new Button("Click");

        button.setOnAction(value -> {
            label.setText("Clicked");
        });

        VBox vbox = new VBox(button, label);

        Scene scene = new Scene(vbox, 100, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
