import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        Output.slowPrint("Starting a new game of Farm Management Simulator!");

        CurrencyManager.getInstance();

        // create a new Farm
        double random = Math.random();
        Farm farm = FarmFactory.createFarm(random);

        // add supplier to contacts
        // add news to contacts
        News news = new News("Local Whether 33");
        Supplier supplier = new Supplier("Sarah");
        farm.addObservers(news);
        farm.addObservers(supplier);

        // simulate the farm for infinite cycles
        int i = 0;
        boolean crashNBurn = false;
        RandomEventType type = null;
        while ( true ) {
            //DAY CYCLE STARTS

            Output.slowPrint("Day " + (i+1) + " begins.");

            Output.slowPrint("Reading the newspaper...");
            if (random < 0.5) {
                type = getRandomEventType();
                crashNBurn = true;
            }
            // run a cycle on the Farm
            farm.runCycle(i);

            // add passive currency to the Farm
            int passiveCurrency = farm.getPassiveCurrency(i);
            Output.slowPrint("Today the farm earned " + passiveCurrency + " Farm Coins!");
            CurrencyManager.getInstance().addCurrency(passiveCurrency);

            // print out the current currency
            Output.slowPrint("Current currency: " + CurrencyManager.getInstance().getCurrency());

            // upgrade the Farm if possible
            farm.upgrade();

            //DAY CYCLE ENDS -> NIGHT CYCLE STARTS
            Output.slowPrint("The sun sets...");

            if (crashNBurn) {
                farm.generateRandomEvent(type);
            }

            //NIGHT CYCLE ENDS

            Output.slowPrint("Day " + (i+1) + " ends.");
            Output.slowPrint(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
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