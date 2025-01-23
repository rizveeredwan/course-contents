package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Scene5Controller {
    @FXML
    protected TextField full_name_text;
    @FXML
    protected TextField email_text;
    @FXML
    protected TextField password_text;

    @FXML
    public void submitButton(ActionEvent e) throws SQLException{
        String full_name = full_name_text.getText();
        String password = password_text.getText();
        String email = email_text.getText();

        JDBCon jdbc = new JDBCon();
        jdbc.insertRecord(full_name, email, password);

    }

}
