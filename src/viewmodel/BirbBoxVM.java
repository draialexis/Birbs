package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BirbBoxVM {
    private final ObservableList<BirbVM> birbsVMObs = FXCollections.observableArrayList();
    private final ListProperty<BirbVM> birbsVM = new SimpleListProperty<>(birbsVMObs);
    public ObservableList<BirbVM> getBirbsVM() { return birbsVM.get(); }
    public ListProperty<BirbVM> birbsVMProperty() { return birbsVM; }


}
