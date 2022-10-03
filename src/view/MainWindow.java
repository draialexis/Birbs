package view;

import binding.DateToStringBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import viewmodel.BirbBoxVM;
import viewmodel.BirbVM;
import viewmodel.DateManagerVM;

public class MainWindow {

    @FXML
    private TextField nameTF;
    @FXML
    private ColorPicker colorPckr;
    @FXML
    private Label dateTodayLbl;
    @FXML
    private ListView<BirbVM> birbsLV;

    private final DateManagerVM dateManagerVM = new DateManagerVM();

    //    private final BirbBoxVM birbBox = new Stub().loadBirbs();
    private BirbBoxVM birbBoxVM;


    @FXML
    private void initialize() {

        dateTodayLbl.textProperty().bind(new DateToStringBinding(dateManagerVM.currentDateProperty()));

        birbsLV.itemsProperty().bind(birbBoxVM.birbsVMProperty());

        birbsLV.getSelectionModel().selectedItemProperty().addListener((__, oldBirbVM, newBirbVM) -> {
            if (oldBirbVM != null) {
                nameTF.textProperty().unbindBidirectional(oldBirbVM.nameProperty());
            }
            if (newBirbVM != null) {
                nameTF.textProperty().bindBidirectional(newBirbVM.nameProperty());
            }
        });
        birbsLV.setCellFactory(__ -> new BirbListCell());
    }

    @FXML
    private void clickSkipTwoDays() {
        dateManagerVM.addDays(2);
        birbBoxVM.changeDay(dateManagerVM.getCurrentDate());
    }

    @FXML
    private void clickFeed() {
        birbsLV.getSelectionModel().getSelectedItem().feed(dateManagerVM.getCurrentDate());
    }

    public void clickQuit() {
        birbsLV.getScene().getWindow().hide();
    }
}
