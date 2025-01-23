package com.example.hellofx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.CheckBox;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene4Controller implements Initializable {
        @FXML
        private CheckBox on_box;
        @FXML
        private CheckBox off_box;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // during initialize it will be invoked
        // 1: Method invoke
        // Attach event handler to the CheckBox
        // Attach listener to the selected property of CheckBox
        //on.
        on_box.setOnAction(event -> check_on(event));
        //on.setOnAction(this::check_on); // Both are same definition
        on_box.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                System.out.println("On's value is changed " + on_box.isSelected());
            }
        });

        //off.setOnAction(event -> check_off(event));
        off_box.setOnAction(actionEvent -> check_off(actionEvent)); //Both are same definition
        off_box.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                System.out.println("Off's value is changed " + off_box.isSelected());
            }
        });
    }

    public void check_on(ActionEvent e){
        System.out.println("I have pressed the check_on");
    }
    public void check_off(ActionEvent e){
        System.out.println("I have pressed the check_off");
    }
}
