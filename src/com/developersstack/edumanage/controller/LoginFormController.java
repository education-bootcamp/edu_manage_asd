package com.developersstack.edumanage.controller;

import com.developersstack.edumanage.bo.BoFactory;
import com.developersstack.edumanage.bo.custom.UserBo;
import com.developersstack.edumanage.dto.UserDto;
import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.repo.custom.UserRepo;
import com.developersstack.edumanage.repo.custom.impl.UserRepoImpl;
import com.developersstack.edumanage.util.enums.BoType;
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
    private final UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);

    public void forgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPasswordForm");
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();

        try{
            UserDto selectedUser = userBo.findUser(email);
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
