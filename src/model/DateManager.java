package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class DateManager {
    private LocalDate currentDate = LocalDate.now();

    public void addDays(long toAdd) {
        currentDate = currentDate.plusDays(toAdd);
    }
}
