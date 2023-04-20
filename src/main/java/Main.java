import java.util.concurrent.TimeUnit;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        slowPrint("Starting a new game of Farming Simulator 2024!\n");


//        while(true){
//            slowPrint("Farming Simulator 2024!");
//        }


        ///////TESTING/////
        CurrencyManager.getInstance();
        // create a new AnimalFarm
        Farm animalFarm = FarmFactory.createFarm("animal");

        // create some farmers and add them to the animalFarm
        Farmer farmer1 = new Farmer();
        //Farmer farmer2 = new Farmer();
            //animalFarm.getFarmers().add(farmer1);
        //animalFarm.getFarmers().add(farmer2);

        // create a supplier and add them to the animalFarm
            //Supplier supplier = new Supplier();
            //animalFarm.getAnimals().addObserver(supplier);

        // simulate the farm for 10 cycles
        for (int i = 0; i < 10; i++) {
            slowPrint("Cycle " + (i+1) + " begins.");

            // run a cycle on the animalFarm
            slowPrint("Feeding and herding animals...\n");
            slowPrint("Operating farm equipment...\n");
            slowPrint("Collecting animal products...\n");
            animalFarm.runCycle();

            // notify the farmers of any animal deaths
//            for (Farmer farmer : animalFarm.getFarmers()) {
//                for (Animal animal : animalFarm.getAnimals().getDeadAnimals()) {
//                    farmer.update(animal);
//                }
//            }

            // notify the supplier of any new animal stock needed
//            animalFarm.getAnimals().notifyObservers();

            // add passive currency to the animalFarm
            int passiveCurrency = animalFarm.getPassiveCurrency();
            slowPrint("Today the farm earned " + passiveCurrency + " Farm Coins!\n");
            CurrencyManager.getInstance().addCurrency(passiveCurrency);

            // print out the current currency
            slowPrint("Current currency: " + CurrencyManager.getInstance().getCurrency() + "\n");

            // upgrade the animalFarm if possible
            animalFarm.upgrade();

            slowPrint("Cycle " + (i+1) + " ends.\n");
            slowPrint(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        }


    }

    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch (Exception e) {
            }
        }
    }

    public enum RandomEventType {
        DISEASE_OUTBREAK,
        WEATHER_STORM,
        MARKET_CRASH
    }

    public RandomEventType getRandomEventType() {
        Random random = new Random();
        int eventIndex = random.nextInt(RandomEventType.values().length);
        System.out.println("There is a chance of" + RandomEventType.values()[eventIndex]);
        return RandomEventType.values()[eventIndex];
    }

//    public void generateRandomEvent(RandomEventType eventType) {
//        //RandomEventType eventType = getRandomEventType();
//        switch (eventType) {
//            case DISEASE_OUTBREAK:
//                int numAffectedAnimals = getRandomNumber(1, 10);
//                int numDeadAnimals = Math.min(numAffectedAnimals, animals.size());
//                for (int i = 0; i < numDeadAnimals; i++) {
//                    animals.remove(getRandomNumber(0, animals.size() - 1));
//                }
//                System.out.println(numDeadAnimals + " animals died due to a disease outbreak.");
//                break;
//            case WEATHER_STORM:
//                double cropDamage = getRandomNumber(0.1, 0.5);
//                for (Crop crop : crops) {
//                    crop.reduceGrowth(cropDamage);
//                }
//                System.out.println("A storm caused " + (cropDamage * 100) + "% crop damage.");
//                break;
//            case MARKET_CRASH:
//                double currencyLoss = getRandomNumber(0.1, 0.5) * currency;
//                currency -= currencyLoss;
//                System.out.println("A market crash caused a currency loss of " + currencyLoss + ".");
//                break;
//        }
//    }

    //testing test method
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be non-negative");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}