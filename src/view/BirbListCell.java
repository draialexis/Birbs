package view;

import javafx.scene.control.ListCell;
import model.Birb;
import view.uc.UCBirbCell;

import java.io.IOException;

public class BirbListCell extends ListCell<Birb> {

    @Override
    protected void updateItem(Birb item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            try {
                UCBirbCell cell = new UCBirbCell(item);
                setGraphic(cell);
            } catch (IOException e) {
                System.err.println("couldn't load that birb cell");
                textProperty().bind(item.nameProperty());
            }
        } else {
            textProperty().unbind();
            this.setText("");
        }
    }
}
