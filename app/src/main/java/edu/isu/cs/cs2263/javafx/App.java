package edu.isu.cs.cs2263.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //sets title on 'scene' or window
        stage.setTitle("First JavaFX Application!");

        Label label = new Label("Hello World, JavaFX");
        Scene scene = new Scene(label, 400, 200);

        stage.setScene(scene);

        //shows the window
        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
