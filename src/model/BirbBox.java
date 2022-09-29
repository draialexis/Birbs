package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class BirbBox {

    private final ObservableList<Birb> birbsObs = FXCollections.observableArrayList();
    private final ListProperty<Birb> birbs = new SimpleListProperty<>(birbsObs);
    public ListProperty<Birb> birbsProperty() {return birbs;}
    public ObservableList<Birb> getBirbs() {return birbs.get();}

    private final ObjectProperty<LocalDate> birbBoxTime = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> birbBoxTimeProperty() {return birbBoxTime;}
    public LocalDate getBirbBoxTime() {return birbBoxTime.get();}
    public void setBirbBoxTime(LocalDate date) {birbBoxTime.set(date);}

    public void addBirb(Birb toAdd) {
        birbs.add(toAdd);
    }

    public void skipDays(int days) {
        setBirbBoxTime(getBirbBoxTime().plusDays(days));
        for (Birb birb : birbs) {
            birb.ageDays(days);
        }
    }

    public BirbBox() {
        setBirbBoxTime(LocalDate.now());
    }
}
