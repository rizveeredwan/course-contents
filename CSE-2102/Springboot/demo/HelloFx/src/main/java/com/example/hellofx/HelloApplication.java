package com.example.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("scene5.fxml"));

        //Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        //Stage stage = new Stage();

        //String css = getClass().getResource("E:\\CSEDU\\Courses\\CSE 2102 OOP\\Springboot\\demo\\HelloFx\\src\\main\\resources\\application.css").toExternalForm();
       scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());

        Text text = new Text();
        text.setText("Hello drawing shape");
        text.setX(100);
        text.setY(50);
        text.setFont(Font.font("Cambria", 50));

        Line line = new Line();
        line.setStartX(300);
        line.setStartY(300);
        line.setEndX(450);
        line.setEndY(450);

        //root.getChildren().add(line);
        //root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();

        /*

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Image icon = new Image("resource/istockphoto-1363734940-612x612.jpg");
        Image icon = new Image("istockphoto-1363734940-612x612.jpg");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.LIGHTBLUE);
        stage.setTitle("Hello!");
        Text t = new Text();
        t.setText("Working fine");
        t.setX(50);
        t.setY(50);
        t.setFont(Font.font("Cambria", 50));
        t.setFill(Color.PURPLE);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);

        line.setEndX(200);
        line.setEndY(430);

        ImageView img = new ImageView(icon);
        img.setX(100);
        img.setY(150);
        img.setFitHeight(50);

        root.getChildren().add(t); // adding node *****
        root.getChildren().add(line);
        root.getChildren().add(img);
        stage.getIcons().add(icon);


        stage.setScene(scene);
        stage.show(); // to show things */
    }

    public static void main(String[] args) {
        launch(args);
    }
}