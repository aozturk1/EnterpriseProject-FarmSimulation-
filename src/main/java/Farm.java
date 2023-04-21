import java.util.ArrayList;
import java.util.List;

abstract public class Farm {
    // constructor, getters and setters for currency, farmers, animals and crops

    public abstract void upgrade();
    public abstract int getPassiveCurrency(int i);
    public abstract boolean getCapacity();

    public abstract void runCycle(int i);
    public abstract void addObservers(Observer observer);
    public abstract void tellObservers();
    public abstract void generateRandomEvent(Main.RandomEventType eventType);
}

class AnimalFarm extends Farm {
    private List<Observer> contacts = new ArrayList<Observer>();
    public int animals;
    public int capacity;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    public AnimalFarm() {
        this.animals = 2;
        this.capacity = 5;
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
            Output.slowPrint((2*(this.upgradeCost) - CurrencyManager.getInstance().getCurrency()) + " Farm Coins away from leveling up.");
            if (this.animals <= this.capacity/3) {
                tellObservers();
            }
        }
    }

    @Override
    public int getPassiveCurrency(int i) {
        return this.animals * this.passiveCurrency;
    }

    @Override
    public boolean getCapacity() {
        if(this.animals >= this.capacity){
            Output.slowPrint("Farm reached animal its maximum animal capacity!");
            return true;
        } return false;
    }

    @Override
    public void runCycle(int i) {
        Output.slowPrint("Feeding and herding animals...");
        Output.slowPrint("Operating farm equipment...");
        Output.slowPrint("Collecting animal products...");
        if (this.animals >= 2 && ( i % 4 == 0 )) {
            this.animals++;
        }
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
            case ALIEN_ABDUCTION:
                Output.slowPrint("YOU GOT ABDUCTED BY ALIENS. BETTER LUCK NEX TIME!");
                Output.slowPrint("!!!!!!!!GAME OVER!!!!!!!!");
                System.exit(0);
        }
    }
}

class CropFarm extends Farm {
    private List<Observer> contacts = new ArrayList<Observer>();
    public int capacity;
    public int crops;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    public CropFarm() {
        this.capacity = 3;
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
            this.capacity++;
            Output.slowPrint("FARM LEVEL UP >>> This farm is now level: " + this.farmLevel);
        } else {
            Output.slowPrint((2*(this.upgradeCost) - CurrencyManager.getInstance().getCurrency()) + " Farm Coins away from leveling up.");
            if (this.crops <= this.capacity/3) {
                tellObservers();
            }
        }
    }

    @Override
    public int getPassiveCurrency(int i) {
        if ( i % 3 == 0){
            Output.slowPrint("Crops are being harvested...");
            return this.passiveCurrency * this.crops;
        }
        Output.slowPrint("Crops not ready to harvest!");
        return 1;
    }

    @Override
    public boolean getCapacity() {
        if(this.crops >= this.capacity){
            Output.slowPrint("Farm reached its maximum crop capacity!");
            return true;
        } return false;
    }

    @Override
    public void runCycle(int i) {
        Output.slowPrint("Operating farm equipment...");
        if (i >= 0){
            Output.slowPrint("Crops are being watered...");
        }
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
                Output.slowPrint("A market crash caused a currency loss of.");
                break;
            case EQUIPMENT_EXPENSES:
                Output.slowPrint("Bummer, equipment expenses were paid!");
                break;
            case ALIEN_ABDUCTION:
                Output.slowPrint("YOU GOT ABDUCTED BY ALIENS. BETTER LUCK NEX TIME!");
                Output.slowPrint("!!!!!!!!GAME OVER!!!!!!!!");
                System.exit(0);
        }
    }
}

class FarmFactory {
    public static Farm createFarm(double farmType) {
        if (farmType < 0.5) {
            Output.slowPrint("Great choice, an animal farm!");
            return new AnimalFarm();
        } else {
            Output.slowPrint("Great choice, a crop farm!");
            return new CropFarm();
        }
    }
}