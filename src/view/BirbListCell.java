package view;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import model.Birb;

public class BirbListCell extends ListCell<Birb> {

    private final BorderPane pane = new BorderPane();
    private final Label cellNameLbl = new Label();

    @Override
    protected void updateItem(Birb item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            cellNameLbl.textProperty().bind(item.nameProperty());
            pane.setLeft(cellNameLbl);
            setGraphic(pane);
        }
        else {
            setGraphic(null);
        }
    }
}
