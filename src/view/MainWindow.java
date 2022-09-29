package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
    private Label nameLbl;
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

    Birb currentBirb = null;

    @FXML
    private void clickFeed(ActionEvent evt) {
        if (currentBirb != null) {
            currentBirb.feed();
        }
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
        }
    }

    @FXML
    private void clickInspectBirb(MouseEvent evt) {
        if (birbsLV.getSelectionModel().getSelectedItem() != null) {
            currentBirb = birbsLV.getSelectionModel().getSelectedItem();
            cleanBirb();
            bindBirb(currentBirb);
        }
    }

    private void bindBirb(Birb birb) {
        if (birb != null) {
            nameLbl.textProperty().bind(birb.nameProperty());
            dobLbl.textProperty().bind(birb.dobProperty().asString());
            ageLbl.textProperty().bind(birb.ageProperty().asString());
            colorDot.fillProperty().bind(birb.colorProperty());
            hungerDot.fillProperty().bind(birb.hungerProperty());
        }
    }

    private void cleanBirb() {
        nameLbl.textProperty().unbind();
        dobLbl.textProperty().unbind();
        ageLbl.textProperty().unbind();
        colorDot.fillProperty().unbind();
        hungerDot.fillProperty().unbind();
    }

    private final BirbBox birbBox = new BirbBox();

    public void initialize() {
        birbsLV.itemsProperty().bind(birbBox.birbsProperty());
        dateTodayLbl.textProperty().bind(birbBox.birbBoxTimeProperty().asString());
    }
}
