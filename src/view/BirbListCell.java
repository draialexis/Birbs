package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import viewmodel.BirbVM;

public class BirbListCell extends ListCell<BirbVM> {

    private final BorderPane pane = new BorderPane();
    private final Label cellNameLbl = new Label();

    @Override
    protected void updateItem(BirbVM item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            cellNameLbl.textProperty().bind(item.nameProperty());
            cellNameLbl.textFillProperty()
                       .bind(Bindings.when(item.isHungryProperty())
                                     .then(Paint.valueOf("red"))
                                     .otherwise(Paint.valueOf("black")));

            pane.setLeft(cellNameLbl);

            setGraphic(pane);
        }
        else {
            setGraphic(null);
        }
    }
}
