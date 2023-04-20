import java.util.Collection;

abstract public class Farm {
    private int funds;
    private int currency;
    private int farmers;
    private int animals;
    private int crops;

    // constructor, getters and setters for currency, farmers, animals and crops

    public abstract void upgrade();
    public abstract int getPassiveCurrency();

    public abstract void runCycle();
    public abstract Observable getAnimals();
    public abstract Collection<Farmer> getFarmers();
}

class AnimalFarm extends Farm {
    private int funds;
    private int animals;
    private int passiveCurrency;
    private int upgradeCost;
    private int farmLevel;

    public AnimalFarm() {
        this.funds = 10;
        this.animals = 2;
        this.passiveCurrency = 1;
        this.upgradeCost = 50;
        this.farmLevel = 1;
    }

    @Override
    public void upgrade() {
        if (this.funds >= this.upgradeCost) {
            this.funds -= this.upgradeCost;
            this.upgradeCost *= 2;
            this.farmLevel++;
            System.out.println("FARM LEVEL UP >>> This farm is now level: " + farmLevel);
        } else {
            System.out.println("The farm is " + (this.upgradeCost - this.funds) + " Farm Coins away from leveling up.");
        }
    }

    @Override
    public int getPassiveCurrency() {
        return this.animals * this.passiveCurrency;
    }

    @Override
    public void runCycle() {
        this.animals += 1;
    }

    @Override
    public Observable getAnimals() {
        System.out.println("10 animals died to a disease");
        return null;
    }

    @Override
    public Collection<Farmer> getFarmers() {
        System.out.println("Farmer Joe");
        return null;
    }
    // implementation of AnimalFarm
}

class CropFarm extends Farm {
    @Override
    public void upgrade() {

    }

    @Override
    public int getPassiveCurrency() {
        return 0;
    }

    @Override
    public void runCycle() {

    }

    @Override
    public Observable getAnimals() {
        System.out.println("10 crops got eaten");
        return null;
    }

    @Override
    public Collection<Farmer> getFarmers() {
        System.out.println("Farmer Bob");
        return null;
    }
    // implementation of CropFarm
}

class HybridFarm extends Farm {
    @Override
    public void upgrade() {

    }

    @Override
    public int getPassiveCurrency() {
        return 0;
    }

    @Override
    public void runCycle() {

    }

    @Override
    public Observable getAnimals() {
        System.out.println("5 animals and 5 crops died");
        return null;
    }

    @Override
    public Collection<Farmer> getFarmers() {
        System.out.println("Farmer Jhon");
        return null;
    }
    // implementation of HybridFarm
}

class FarmFactory {
    public static Farm createFarm(String farmType) {
        if (farmType.equals("animal")) {
            return new AnimalFarm();
        } else if (farmType.equals("crop")) {
            return new CropFarm();
        } else if (farmType.equals("hybrid")) {
            return new HybridFarm();
        }
        return null;
    }
}