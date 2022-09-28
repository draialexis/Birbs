package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Birb;
import model.BirbBox;


public class MainWindow {
    @FXML
    private Label nameLbl;
    @FXML
    private ListView<Birb> birbsLV;
    @FXML
    private Label dobLbl;
    @FXML
    private Label ageLbl;
    @FXML
    private Label colorLbl;
    @FXML
    private Label hungerLbl;
    @FXML
    private Label dateLbl;
    @FXML
    private void clickFeed(ActionEvent evt) {

    }
    @FXML
    private void clickTomorrow(ActionEvent evt) {

    }

    private final BirbBox birbBox = new BirbBox();
    public void initialize() {
        birbsLV.itemsProperty().bind(birbBox.birbsProperty());
    }
}
