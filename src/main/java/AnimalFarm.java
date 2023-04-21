import java.util.ArrayList;
import java.util.List;

/**
 * an implementation of the abstract farm class which is an animal farm.
 * a farm that makes money from animal products and selling animals
 */
class AnimalFarm extends Farm {
    private List<Observer> contacts = new ArrayList<Observer>();
    public int animals;
    public int capacity;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    /**
     * default constructor for AnimalFarm.
     */
    public AnimalFarm() {
        this.animals = 2;
        this.capacity = 5;
        this.passiveCurrency = 1;
        this.upgradeCost = 10;
        this.farmLevel = 1;
    }

    @Override
    public List<Observer> getContacts() {
        return contacts;
    }

    @Override
    public int getNumber() {
        return animals;
    }

    @Override
    public int getCapacityAmount() {
        return capacity;
    }

    /**
     * a method that checks if the capacity is reached.
     * @return whether the capacity is reached or not
     */
    @Override
    public boolean getCapacity() {
        if (this.animals >= this.capacity) {
            Output.slowPrint("Farm reached animal its maximum animal capacity!");
            return true;
        }
        return false;
    }

    @Override
    public int getPassiveCurrency() {
        return passiveCurrency;
    }

    /**
     * a method that returns the daily passive income.
     * @param i the day number
     * @return number of Farm Coins
     */
    @Override
    public int getPassiveCurrency(int i) {
        return this.animals * this.passiveCurrency;
    }

    @Override
    public int getUpgradeCost() {
        return upgradeCost;
    }

    @Override
    public int getFarmLevel() {
        return farmLevel;
    }

    /**
     * a method that checks to see if you can upgrade your farm
     * and upgrade costs money but increases farm capacity.
     */
    @Override
    public void upgrade() {
        if (CurrencyManager.getInstance().getCurrency() >= (2 * (this.upgradeCost))) {
            CurrencyManager.getInstance().spendCurrency(this.upgradeCost);
            this.upgradeCost *= 2;
            this.farmLevel++;
            Output.slowPrint("FARM LEVEL UP >>> This farm is now level: " + this.farmLevel);
        } else {
            Output.slowPrint((2 * (this.upgradeCost) - CurrencyManager.getInstance().getCurrency())
                    + " Farm Coins away from leveling up.");
            if (this.animals <= this.capacity / 3) {
                tellObservers();
            }
        }
    }

    /**
     * a method that represents a day.
     * @param i the day number
     */
    @Override
    public void runCycle(int i) {
        Output.slowPrint("Feeding and herding animals...");
        Output.slowPrint("Operating farm equipment...");
        Output.slowPrint("Collecting animal products...");
        if (this.animals >= 2 && (i % 4 == 0)) {
            this.animals++;
        }
    }

    /**
     * a method that adds the observer to the list of observers.
     * @param observer the observer object
     */
    @Override
    public void addObservers(Observer observer) {
        contacts.add(observer);
    }

    /**
     * a method that notifies all observers.
     */
    @Override
    public void tellObservers() {
        for (Observer o: contacts) {
            o.observableNotify();
        }
    }

    /**
     * a method that return a bad event if the odds are against you.
     * @param eventType an eventType from the list of enums
     */
    @Override
    public void generateRandomEvent(Main.RandomEventType eventType) {
        switch (eventType) {
            case DISEASE_OUTBREAK:
                System.out.println("Animals died due to a disease outbreak!");
                break;
            case WEATHER_STORM:
                Output.slowPrint("A storm caused killed animals!");
                break;
            case MARKET_CRASH:
                Output.slowPrint("Oh no, a market crash caused a currency loss!");
                break;
            case EQUIPMENT_EXPENSES:
                Output.slowPrint("Bummer, equipment expenses were paid!");
                break;
            default:
                System.out.println("Unexpected event type: " + eventType);
                break;
        }

    }
}