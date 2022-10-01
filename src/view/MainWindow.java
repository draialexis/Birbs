package view;

import binding.DateToStringBinding;
import data.Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Birb;
import model.BirbBox;
import model.DateManager;

public class MainWindow {

    @FXML
    private TextField nameTF;
    @FXML
    private ColorPicker colorDot;
    @FXML
    private Label dateTodayLbl;
    @FXML
    private ListView<Birb> birbsLV;

    private final DateManager dateManager = new DateManager();
    private final BirbBox birbBox = new Stub().loadBirbs();

    @FXML
    private void initialize() {

        dateTodayLbl.textProperty().bind(new DateToStringBinding(dateManager.currentDateProperty()));
        birbsLV.itemsProperty().bind(birbBox.birbsProperty());
        birbsLV.getSelectionModel().selectedItemProperty().addListener((__, oldBirb, newBirb) -> {
            if (oldBirb != null) {
                nameTF.textProperty().unbindBidirectional(oldBirb.nameProperty());
                colorDot.valueProperty().unbindBidirectional(oldBirb.getFeatherClr().colorProperty());
            }
            if (newBirb != null) {
                nameTF.textProperty().bindBidirectional(newBirb.nameProperty());
                colorDot.valueProperty().bindBidirectional(newBirb.getFeatherClr().colorProperty());
            }
        });
        birbsLV.setCellFactory(__ -> new BirbListCell());
    }

    @FXML
    private void clickSkipTwoDays(ActionEvent evt) {
        dateManager.addDays(2);
        birbBox.changeDay(dateManager.getCurrentDate());
    }

    @FXML
    private void clickFeed(ActionEvent evt) {
        birbsLV.getSelectionModel().getSelectedItem().feed(dateManager.getCurrentDate());
    }

    public void clickQuit(ActionEvent evt) {
        birbsLV.getScene().getWindow().hide();
    }
}
