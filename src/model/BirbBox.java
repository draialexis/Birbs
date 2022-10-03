package model;

import java.time.LocalDate;
import java.util.*;

public class BirbBox {

    private final List<Birb> birbs = new ArrayList<>();

    public void addBirb(Birb toAdd) {
        birbs.add(toAdd);
    }

    public Collection<Birb> getBirbs() {
        return Collections.unmodifiableList(birbs);
    }

    public void removeBirb(Birb toRemove) {
        birbs.remove(toRemove);
    }

    public void changeDay(LocalDate newDate) {
        Iterator<Birb> it = birbs.iterator();
        while (it.hasNext()) {
            Birb currentBirb = it.next();
            currentBirb.changeDay(newDate);
            if (currentBirb.isDead()) {
                it.remove();
            }
        }
    }
}
