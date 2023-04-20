import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        Output.slowPrint("Starting a new game of Farm Management Simulator!");

        CurrencyManager.getInstance();

        // create a new AnimalFarm
        Farm animalFarm = FarmFactory.createFarm("animal");

        // add supplier to contacts
        // add news to contacts
        News news = new News("Local Whether 33");
        Supplier supplier = new Supplier("Sarah");
        animalFarm.addObservers(news);
        animalFarm.addObservers(supplier);

        // simulate the farm for infinite cycles
        int i = 0;
        while ( true ) {
            //DAY CYCLE STARTS

            Output.slowPrint("Day " + (i+1) + " begins.");

            Output.slowPrint("Reading the newspaper...");
            RandomEventType type = getRandomEventType();
            // run a cycle on the animalFarm
            Output.slowPrint("Feeding and herding animals...");
            Output.slowPrint("Operating farm equipment...");
            Output.slowPrint("Collecting animal products...");
            animalFarm.runCycle();

            // add passive currency to the animalFarm
            int passiveCurrency = animalFarm.getPassiveCurrency();
            Output.slowPrint("Today the farm earned " + passiveCurrency + " Farm Coins!");
            CurrencyManager.getInstance().addCurrency(passiveCurrency);

            // print out the current currency
            Output.slowPrint("Current currency: " + CurrencyManager.getInstance().getCurrency());

            // upgrade the animalFarm if possible
            animalFarm.upgrade();

            //DAY CYCLE ENDS -> NIGHT CYCLE STARTS
            Output.slowPrint("The sun sets...");


            //NIGHT CYCLE ENDS

            Output.slowPrint("Day " + (i+1) + " ends.");
            Output.slowPrint(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            i++;
        }


    }

    public enum RandomEventType {
        DISEASE_OUTBREAK,
        WEATHER_STORM,
        MARKET_CRASH,
        EQUIPMENT_EXPENSES,
        ALIEN_ABDUCTION
    }

    public static RandomEventType getRandomEventType() {
        Random random = new Random();
        int eventIndex = random.nextInt(RandomEventType.values().length);
        Output.slowPrint("There is a chance of " + RandomEventType.values()[eventIndex]);
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