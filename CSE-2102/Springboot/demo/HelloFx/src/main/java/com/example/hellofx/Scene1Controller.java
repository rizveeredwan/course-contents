package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {
    @FXML
    private Label label1;
    @FXML
    private Button button1;
    @FXML
    private TextField textField1;
    @FXML
    public void onButtonPress1(ActionEvent e) throws IOException {
        // getting the name
        String nameVal = textField1.getText();
        // Initiating the loader from the scene2.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        // loading all the hierarchies
        Parent root = loader.load();
        // scene 2 controller invoking
        Scene2Controller sc2 = loader.getController();
        sc2.displayName(nameVal);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
