package view;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Birb;

public class BirbListCell extends ListCell<Birb> {

    private final BorderPane pane = new BorderPane();
    private final Rectangle rectFeatherClr = new Rectangle();
    private final Label cellNameLbl = new Label();

    @Override
    protected void updateItem(Birb item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            cellNameLbl.textProperty().bind(item.nameProperty());
            cellNameLbl.textFillProperty()
                       .bind(Bindings.when(item.isHungryProperty())
                                     .then(Paint.valueOf("red"))
                                     .otherwise(Paint.valueOf("black")));

            rectFeatherClr.fillProperty().bind(item.getFeatherClr().colorProperty());
            rectFeatherClr.setHeight(10);
            rectFeatherClr.setWidth(10);

            pane.setRight(rectFeatherClr);
            pane.setLeft(cellNameLbl);

            setGraphic(pane);
        }
        else {
            setGraphic(null);
        }
    }
}
