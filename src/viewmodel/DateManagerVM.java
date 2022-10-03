package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class DateManagerVM {
    private final ObjectProperty<LocalDate> currentDate = new SimpleObjectProperty<>();
    public LocalDate getCurrentDate() {return currentDate.get();}
    public ObjectProperty<LocalDate> currentDateProperty() {return currentDate;}


    public void addDays(int days) {
        this.currentDate.set(getCurrentDate().plusDays(days));
    }
}
