package com.developersstack.edumanage.controller;

import com.developersstack.edumanage.db.DatabaseAccessCode;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.view.tm.TeacherTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class TeacherFormController {
    public AnchorPane teacherContext;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSearch;
    public Button btn;
    public TableView<TeacherTm> tblTeachers;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colOption;
    public TextField txtContact;

    String searchText="";

    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory<>("code"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        setTeacherId();
        setTableData(searchText);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText=newValue;
            setTableData(searchText);
        });

        tblTeachers.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (null!=newValue){
                        setData(newValue);
                    }
                });
    }

    private void setData(TeacherTm tm) {
        txtId.setText(tm.getCode());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        btn.setText("Update Teacher");
    }

    private void setTableData(String searchText) {
        ObservableList<TeacherTm> obList = FXCollections.observableArrayList();
        try {
            for (Teacher t : new DatabaseAccessCode().findAllTeachers(searchText)
            ) {
                    Button btn = new Button("Delete");
                    TeacherTm tm = new TeacherTm(
                            t.getCode(),
                            t.getName(),
                            t.getAddress(),
                            t.getContact(),
                            btn
                    );

                    btn.setOnAction(e -> {
                        Alert alert = new Alert(
                                Alert.AlertType.CONFIRMATION,
                                "Are you sure?",
                                ButtonType.YES, ButtonType.NO
                        );
                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if (buttonType.get().equals(ButtonType.YES)) {

                            try{
                                boolean isDeleted = new DatabaseAccessCode().deleteTeacher(t.getCode());
                                if (isDeleted) {
                                    new Alert(Alert.AlertType.INFORMATION, "Deleted!").show();
                                    setTableData(searchText);
                                    setTeacherId();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Try Again").show();
                                }
                            }catch (SQLException | ClassNotFoundException exception) {
                                exception.printStackTrace();
                            }
                        }
                    });
                    obList.add(tm);

            }
            tblTeachers.setItems(obList);
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        Teacher teacher = new Teacher(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtContact.getText()
        );
        if (btn.getText().equalsIgnoreCase("Save Teacher")){
            try {
                boolean isSaved = new DatabaseAccessCode().saveTeacher(teacher);
                if (isSaved) {
                    setTeacherId();
                    clear();
                    setTableData(searchText);
                    new Alert(Alert.AlertType.INFORMATION, "Teacher saved!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.toString()).show();
            }

        }else {

            try {
                Teacher selectedTeacher = new DatabaseAccessCode().findTeacher(txtId.getText());
                if (null != selectedTeacher) {
                    boolean isUpdated = new DatabaseAccessCode().updateTeacher(teacher);
                    if (isUpdated) {
                        new Alert(Alert.AlertType.INFORMATION, "Updated!").show();
                        setTeacherId();
                        clear();
                        setTableData(searchText);
                        btn.setText("Update Teacher");
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again").show();
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.toString()).show();
            }
        }
    }

    private void clear(){
        txtContact.clear();
        //txtName.setText("");
        txtName.clear();
        txtAddress.clear();
    }

    private void setTeacherId() {

        try {
            String selectedId = new DatabaseAccessCode().findTeacherLastId();
            if (null != selectedId) {
                String splitData[] = selectedId.split("-");
                String lastIdIntegerNumberAsAString = splitData[1];
                int lastIntegerIdAsInt = Integer.parseInt(lastIdIntegerNumberAsAString);
                lastIntegerIdAsInt++;
                String generatedStudentId = "T-" + lastIntegerIdAsInt;
                txtId.setText(generatedStudentId);
            } else {
                txtId.setText("T-1");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void newTeacherOnAction(ActionEvent actionEvent) {
        btn.setText("Save Teacher");
        setTeacherId();
        clear();
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashboardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) teacherContext.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
