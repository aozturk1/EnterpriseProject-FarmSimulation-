import java.util.ArrayList;
import java.util.List;

/**
 * an abstract class that is the layout of a specific type of farm.
 */
public abstract class Farm {
    // constructor, getters and setters for currency, farmers, animals and crops
    public abstract List<Observer> getContacts();

    public abstract int getNumber();

    public abstract int getCapacityAmount();

    public abstract boolean getCapacity();

    public abstract int getPassiveCurrency();

    public abstract int getPassiveCurrency(int i);

    public abstract int getUpgradeCost();

    public abstract int getFarmLevel();

    public abstract void upgrade();

    public abstract void runCycle(int i);

    public abstract void addObservers(Observer observer);

    public abstract void tellObservers();

    public abstract void generateRandomEvent(Main.RandomEventType eventType);
}