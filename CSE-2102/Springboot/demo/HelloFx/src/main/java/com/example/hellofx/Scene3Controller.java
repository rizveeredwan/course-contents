package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scene3Controller {
    @FXML
    private Button press_button;
    @FXML
    private ImageView image_view;

    @FXML
    public void onPressButton(ActionEvent e){
        Image img = new Image(getClass().getResourceAsStream("/jerry_image.jpg"));
        image_view.setImage(img);
    }
}
