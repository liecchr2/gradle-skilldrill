package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        IOManager manager = new IOManager();
        String file = "C:\\Users\\chris\\OneDrive\\Desktop\\Spring 2021\\CS2263\\gradle-skilldrill\\students.json";

        //Pull data from file
        ArrayList<Student> display = manager.readFile(file);

        //sets title on 'scene' or window
        stage.setTitle("Course View");

        //ListView for student
        ListView<String> studentList = new ListView<>();

        ObservableList<String> names = FXCollections.observableArrayList(display.get(0).toString(),
                                                                        display.get(1).toString(),
                                                                        display.get(2).toString());
        studentList.setItems(names);

        //ListView for courses
        ListView<String> courseList = new ListView<>();

        //Student VBox
        VBox studentBox = new VBox(10, studentList);
        Label studentLabel = new Label("Students");
        //Make label bold
        studentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        studentBox.getChildren().add(studentLabel);

        //Course Box
        VBox courseBox = new VBox(10, courseList);
        Label courseLabel = new Label("Courses");
        //Make label bold
        courseLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        courseBox.getChildren().add(courseLabel);

        //Text
        Text text = new Text();
        text.setText("Is Taking");

        //HBox
        HBox contentBox = new HBox(10,studentBox,text,courseBox);

        //Button
        Button loadData = new Button("Load Data");
        loadData.setAlignment(Pos.BOTTOM_LEFT);

        //Button Actions
        loadData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int index = studentList.getSelectionModel().getSelectedIndex();
                ObservableList<String> courses = FXCollections.observableArrayList(display.get(index).getCourseList().get(0).toString(),
                        display.get(index).getCourseList().get(1).toString(),
                        display.get(index).getCourseList().get(2).toString());
                courseList.setItems(courses);

            }
        });

        //Final VBox
        VBox mainBox = new VBox(contentBox, loadData);

        //Create Scene
        Scene scene = new Scene(mainBox, 400, 200);
        stage.setScene(scene);

        //shows the window
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        //Create Student objects and add courses
        Student john = new Student("John", "Doe");
                john.add(new Course(1181, "CS", "Intro to Programming"));
                john.add(new Course(2263, "CS", "Advanced OO Programming"));
                john.add(new Course(4423, "CS", "Software Evolution"));

        Student albert = new Student("Albert", "Camus");
                albert.add(new Course(2263, "CS", "Advanced Object Programming"));
                albert.add(new Course(3350, "MATH", "Statistical Methods"));
                albert.add(new Course(1187, "CS", "Applied Discrete Structures"));

        Student marcus = new Student("Marcus", "Aurelius");
                marcus.add(new Course(1337, "CS", "System Programming and Assembly"));
                marcus.add(new Course(2235, "CS", "Data Structures and Algorithms"));
                marcus.add(new Course(3305, "CS", "Introduction to Computational Theory"));

        //Initialize IO Manager
        IOManager manager = new IOManager();

        //Fill array with student data
        Student[] students = new Student[]{john, albert, marcus};

        //Path of file
        String file = "C:\\Users\\chris\\OneDrive\\Desktop\\Spring 2021\\CS2263\\gradle-skilldrill\\students.json";

        manager.writeFile(file, students);

        Application.launch(args);
    }
}
