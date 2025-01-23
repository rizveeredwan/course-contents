package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller {
    @FXML
    protected Label name_label;
    @FXML
    public void displayName(String name){
        name_label.setText(name);
    }
    @FXML
    public void  onButtonPress2(ActionEvent e) throws IOException {
        // Initiating the loader from the scene2.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        // loading all the hierarchies
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
