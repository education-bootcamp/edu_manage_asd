package com.developersstack.edumanage.controller;

import com.developersstack.edumanage.db.DatabaseAccessCode;
import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.util.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void forgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPasswordForm");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();

        try{
            User selectedUser = new DatabaseAccessCode().loginUser(email);
            if (null!=selectedUser){
                if (new PasswordManager().checkPassword(password,selectedUser.getPassword())){
                    setUi("DashboardForm");
                }else{
                    new Alert(Alert.AlertType.ERROR,
                            "Wrong Password!").show();
                }
            }else{
                new Alert(Alert.AlertType.WARNING,
                        String.format("user not found (%s)",email)).show();
            }
        }catch (SQLException | ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
