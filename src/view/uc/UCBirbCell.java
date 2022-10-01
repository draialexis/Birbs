package view.uc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.Birb;

import java.io.IOException;

public class UCBirbCell extends BorderPane {

    @FXML
    private Label cellNameLbl;

    public UCBirbCell(Birb birb) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uc/UCBirbCell.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();

        System.out.println(birb.getName());
        cellNameLbl.textProperty().bind(birb.nameProperty());
    }

}
