package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Iterator;

public class BirbBox {

    private final ObservableList<Birb> birbsObs = FXCollections.observableArrayList();
    private final ListProperty<Birb> birbs = new SimpleListProperty<>(birbsObs);
    public ListProperty<Birb> birbsProperty() {return birbs;}
    public ObservableList<Birb> getBirbs() {return birbs.get();}

    public void addBirb(Birb toAdd) {
        birbs.add(toAdd);
    }

    public void removeBirb(Birb toRemove) {
        birbs.remove(toRemove);
    }

    public void changeDay(LocalDate newDate) {
        Iterator<Birb> it = birbs.iterator();
        while(it.hasNext()) {
            Birb currentBirb = it.next();
            currentBirb.changeDay(newDate);
            if(currentBirb.isDead()){
                it.remove();
            }
        }
    }
}
