import java.util.ArrayList;
import java.util.List;

/**
 * an implementation of the abstract farm class which is a crop farm
 * a farm that makes money from selling crops and bees.
 */
class CropFarm extends Farm {
    private List<Observer> contacts = new ArrayList<Observer>();
    public int capacity;
    public int crops;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    /**
     * default constructor for the CropFarm class.
     */
    public CropFarm() {
        this.capacity = 3;
        this.crops = 1;
        this.passiveCurrency = 2;
        this.upgradeCost = 5;
        this.farmLevel = 1;
    }

    @Override
    public List<Observer> getContacts() {
        return contacts;
    }

    @Override
    public int getNumber() {
        return crops;
    }

    @Override
    public int getCapacityAmount() {
        return capacity;
    }

    @Override
    public int getPassiveCurrency() {
        return passiveCurrency;
    }

    /**
     * a method that returns the daily passive income.
     *
     * @param i the day number
     * @return number of Farm Coins
     */
    @Override
    public int getPassiveCurrency(int i) {
        if (i % 3 == 0) {
            Output.slowPrint("Crops are being harvested...");
            return this.passiveCurrency * this.crops;
        }
        Output.slowPrint("Crops not ready to harvest!");
        return 1;
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
            this.capacity++;
            Output.slowPrint("FARM LEVEL UP >>> This farm is now level: " + this.farmLevel);
        } else {
            Output.slowPrint((2 * (this.upgradeCost) - CurrencyManager.getInstance().getCurrency())
                    + " Farm Coins away from leveling up.");
            if (this.crops <= this.capacity / 3) {
                tellObservers();
            }
        }
    }

    /**
     * a method that checks if the capacity is reached.
     *
     * @return whether the capacity is reached or not
     */
    @Override
    public boolean getCapacity() {
        if (this.crops >= this.capacity) {
            Output.slowPrint("Farm reached its maximum crop capacity!");
            return true;
        }
        return false;
    }

    /**
     * a method that represents a day.
     *
     * @param i the day number
     */
    @Override
    public void runCycle(int i) {
        Output.slowPrint("Operating farm equipment...");
        if (i >= 0) {
            Output.slowPrint("Crops are being watered...");
        }
    }

    /**
     * a method that adds the observer to the list of observers.
     *
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
        for (Observer o : contacts) {
            o.observableNotify();
        }
    }

    /**
     * a method that return a bad event if the odds are against you.
     *
     * @param eventType an eventType from the list of enums
     */
    @Override
    public void generateRandomEvent(Main.RandomEventType eventType) {
        switch (eventType) {
            case DISEASE_OUTBREAK:
                System.out.println("Some crops died due to a disease outbreak!");
                break;
            case WEATHER_STORM:
                Output.slowPrint("A storm caused crop damage.");
                break;
            case MARKET_CRASH:
                Output.slowPrint("Oh no, a market crash caused a currency loss !");
                break;
            case EQUIPMENT_EXPENSES:
                Output.slowPrint("Bummer, equipment expenses were paid!");
                break;
            default:
                Output.slowPrint("No random event occurred.");
                break;
        }
    }
}