package model;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class Birb {

    /**
     * a birb's feeding frequency
     */
    private int feedHz = 2;
    /**
     * the date of a birb's latest previous meal
     */
    private LocalDate prvMealDate = LocalDate.now();
    private boolean isDead = false;
    private String name;
    private boolean isHungry = false;

    public boolean isDead() {
        return isDead;
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isHungry() {
        return isHungry;
    }
    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public Birb(String name, int feedHz) {
        this.name = name;
        this.feedHz = feedHz;
    }

    public void feed(LocalDate newPrvMealDate) {
        prvMealDate = newPrvMealDate;
        setHungry(false);
    }

    public void changeDay(LocalDate newDate) {
        if (Period.between(prvMealDate, newDate).getDays() >= feedHz) {
            setHungry(true);
        }
        if (Period.between(prvMealDate, newDate).getDays() >= feedHz * 2) {
            setDead(true);
        }
    }
}

