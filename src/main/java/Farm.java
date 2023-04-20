import java.util.ArrayList;
import java.util.List;

abstract public class Farm {
    // constructor, getters and setters for currency, farmers, animals and crops

    public abstract void upgrade();
    public abstract int getPassiveCurrency();
    public abstract boolean getCapacity();

    public abstract void runCycle();
    public abstract void addObservers(Observer observer);
    public abstract void tellObservers();
}

class AnimalFarm extends Farm {
    private List<Observer> contacts = new ArrayList<Observer>();
    public int animals;
    public int cpacity;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    public AnimalFarm() {
        this.animals = 2;
        this.cpacity = 5;
        this.passiveCurrency = 1;
        this.upgradeCost = 10;
        this.farmLevel = 1;
    }

    @Override
    public void upgrade() {
        if (CurrencyManager.getInstance().getCurrency() >= (2*(this.upgradeCost))) {
            CurrencyManager.getInstance().spendCurrency(this.upgradeCost);
            this.upgradeCost *= 2;
            this.farmLevel++;
            Output.slowPrint("FARM LEVEL UP >>> This farm is now level: " + this.farmLevel);
        } else {
            Output.slowPrint("The farm is " + (2*(this.upgradeCost) - CurrencyManager.getInstance().getCurrency()) + " Farm Coins away from leveling up.");
            if (this.animals < 10) {
                tellObservers();
            }
        }
    }

    @Override
    public int getPassiveCurrency() {
        return this.animals * this.passiveCurrency;
    }

    @Override
    public boolean getCapacity() {
        if(this.animals >= this.cpacity){
            Output.slowPrint("Farm reached animal its maximum animal capacity!");
            return true;
        } return false;
    }

    @Override
    public void runCycle() {
        this.animals++;
    }

    @Override
    public void addObservers(Observer observer) {
        contacts.add(observer);
    }

    @Override
    public void tellObservers() {
        for (Observer o: contacts) {
            o.observableNotify();
        }
    }
}

class CropFarm extends Farm {
    private int crops;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    public CropFarm() {
        //this.funds = 10;
        this.crops = 1;
        this.passiveCurrency = 2;
        this.upgradeCost = 5;
        this.farmLevel = 1;
    }

    @Override
    public void upgrade() {
        if (CurrencyManager.getInstance().getCurrency() >= (2*(this.upgradeCost))) {
            CurrencyManager.getInstance().spendCurrency(this.upgradeCost);
            this.upgradeCost *= 2;
            this.farmLevel++;
            Output.slowPrint("FARM LEVEL UP >>> This farm is now level: " + this.farmLevel);
        } else {
            Output.slowPrint("The farm is " + (2*(this.upgradeCost) - CurrencyManager.getInstance().getCurrency()) + " Farm Coins away from leveling up.");
        }
    }

    @Override
    public int getPassiveCurrency() {
        return this.crops * this.passiveCurrency;
    }

    @Override
    public boolean getCapacity() {
        return false;
    }

    @Override
    public void runCycle() {

    }

    @Override
    public void addObservers(Observer observer) {

    }

    @Override
    public void tellObservers() {

    }
    // implementation of CropFarm
}

class FarmFactory {
    public static Farm createFarm(String farmType) {
        if (farmType.equals("animal")) {
            return new AnimalFarm();
        } else if (farmType.equals("crop")) {
            return new CropFarm();
        }
        return null;
    }
}