package view;

import data.Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Birb;
import model.BirbBox;

public class MainWindow {
    @FXML
    private TextField nameForm;
    @FXML
    private ColorPicker colorForm;
    @FXML
    private DatePicker dobForm;

    @FXML
    private TextField nameTF;
    @FXML
    private Label dobLbl;
    @FXML
    private Label ageLbl;
    @FXML
    private Circle colorDot;
    @FXML
    private Circle hungerDot;

    @FXML
    private Label dateTodayLbl;

    @FXML
    private ListView<Birb> birbsLV;

    @FXML
    private void clickFeed(ActionEvent evt) {
        birbsLV.getSelectionModel().getSelectedItem().feed();
    }

    @FXML
    private void clickTomorrow(ActionEvent evt) {
        birbBox.skipDays(1);
    }

    @FXML
    private void clickCreate(ActionEvent evt) {
        if (!nameForm.getText().isBlank() && dobForm.getValue() != null) {
            Birb birb = new Birb(nameForm.getText(), colorForm.getValue(), dobForm.getValue());
            birbBox.addBirb(birb);
            cleanForm();
        }
    }

    private void cleanForm() {
        nameForm.setText("");
        dobForm.setValue(null);
        colorForm.setValue(Color.WHITE);
    }

    private final BirbBox birbBox = new Stub().loadBirbs();

    @FXML
    private void initialize() {

        birbsLV.itemsProperty().bind(birbBox.birbsProperty());

        birbsLV.getSelectionModel().selectedItemProperty().addListener((__, oldBirb, newBirb) -> {
            if (oldBirb != null) {
                nameTF.textProperty().unbindBidirectional(oldBirb.nameProperty());
                dobLbl.textProperty().unbind();
                ageLbl.textProperty().unbind();
                colorDot.fillProperty().unbind();
                hungerDot.fillProperty().unbind();
            }
            if (newBirb != null) {
                nameTF.textProperty().bindBidirectional(newBirb.nameProperty());
                dobLbl.textProperty().bind(newBirb.dobProperty().asString());
                ageLbl.textProperty().bind(newBirb.ageProperty().asString());
                colorDot.fillProperty().bind(newBirb.colorProperty());
                hungerDot.fillProperty().bind(newBirb.hungerProperty());
            }
        });

        birbsLV.setCellFactory(__ -> new BirbListCell());
        dateTodayLbl.textProperty().bind(birbBox.birbBoxTimeProperty().asString());
    }

    public void clickQuit(ActionEvent evt) {
        birbsLV.getScene().getWindow().hide();
    }
}
