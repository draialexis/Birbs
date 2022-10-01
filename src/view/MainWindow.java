package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Birb;
import model.BirbBox;

import java.time.LocalDate;

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

    Birb currentBirb = null;

    @FXML
    private void clickFeed(ActionEvent evt) {
        if (currentBirb != null) {
            System.out.println("feeding " + currentBirb.getName());
            currentBirb.feed();
        }
    }

    @FXML
    private void clickTomorrow(ActionEvent evt) {
        System.out.println("tomorrow...");
        birbBox.skipDays(1);
    }

    @FXML
    private void clickCreate(ActionEvent evt) {
        if (!nameForm.getText().isBlank() && dobForm.getValue() != null) {
            System.out.println("creating " + nameForm.getText());
            Birb birb = new Birb(nameForm.getText(), colorForm.getValue(), dobForm.getValue());
            birbBox.addBirb(birb);
            cleanForm();
        }
    }

    private void cleanForm() {
        System.out.println("cleaning the form");
        nameForm.setText("");
        dobForm.setValue(null);
        colorForm.setValue(Color.WHITE);
    }

    @FXML
    private void clickInspectBirb(MouseEvent evt) {
        System.out.println("inspecting...");
        currentBirb = birbsLV.getSelectionModel().getSelectedItem();
        if (currentBirb != null) {
            cleanBirbView();
            System.out.println("new birb: " + currentBirb.getName());
            bindBirbView(currentBirb);
        }
    }

    private void bindBirbView(Birb birb) {
        if (birb != null) {
            System.out.println("binding a birb");
            nameTF.textProperty().bindBidirectional(birb.nameProperty());
            dobLbl.textProperty().bind(birb.dobProperty().asString());
            ageLbl.textProperty().bind(birb.ageProperty().asString());
            colorDot.fillProperty().bind(birb.colorProperty());
            hungerDot.fillProperty().bind(birb.hungerProperty());
        }
    }

    private void cleanBirbView() {
        System.out.println("cleaning the bindings");
        for (Birb birb : birbBox.getBirbs()) {
            nameTF.textProperty().unbindBidirectional(birb.nameProperty());
        }
        dobLbl.textProperty().unbind();
        ageLbl.textProperty().unbind();
        colorDot.fillProperty().unbind();
        hungerDot.fillProperty().unbind();
    }

    private final BirbBox birbBox = new BirbBox();

    @FXML
    private void initialize() {

        System.out.println("adding birbs");
        birbBox.addBirb(new Birb("Alice", Color.AQUAMARINE, LocalDate.of(1995, 8, 14)));
        birbBox.addBirb(new Birb("Bob", Color.BISQUE, LocalDate.of(2001, 3, 19)));
        birbBox.addBirb(new Birb("Clyde", Color.CORNFLOWERBLUE, LocalDate.of(1992, 2, 29)));
        System.out.println("customizing cell factory for listview");
        birbsLV.setCellFactory(__ -> new BirbListCell());
        System.out.println("binding listview to bird list");
        birbsLV.itemsProperty().bind(birbBox.birbsProperty());
        System.out.println("binding today to birbbox time");
        dateTodayLbl.textProperty().bind(birbBox.birbBoxTimeProperty().asString());
    }
}
