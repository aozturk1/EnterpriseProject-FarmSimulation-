import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * the main class of the farming simulator.
 * a simulation game where a random farm type is generated as well
 *  as the rest of your days managing that farm all automatically.
 */
public class Main {

    private static Random random1 = new SecureRandom();

    /**
     * the main method that runs the game loop.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        Output.slowPrint("Starting a new game of Farm Management Simulator!");

        CurrencyManager.getInstance();

        // create a new Farm
        double random = Math.random();
        Farm farm = FarmFactory.createFarm(random);

        // add supplier to contacts
        Supplier supplier = new Supplier("Rick");
        farm.addObservers(supplier);

        // simulate the farm for infinite cycles
        int i = 0;
        boolean crashNBurn = false;
        RandomEventType type = null;
        while (true) {
            //DAY CYCLE STARTS

            Output.slowPrint("Day " + (i + 1) + " begins.");

            Output.slowPrint("Reading the newspaper...");
            random = Math.random();
            if (random < 0.33) {
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
                crashNBurn = false;
            }

            //NIGHT CYCLE ENDS

            Output.slowPrint("Day " + (i + 1) + " ends.");
            Output.slowPrint(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            i++;

            //for testing purposes
            if (args.length == 1) {
                System.out.println("Successful Test");
                break;
            }
        }
    }

    /**
     * an enum representing the possible random events that can occur in the game.
     */
    public enum RandomEventType {
        DISEASE_OUTBREAK,
        WEATHER_STORM,
        MARKET_CRASH,
        EQUIPMENT_EXPENSES,
    }

    /**
     * returns a random event type.
     * @return a random event type
     */
    public static RandomEventType getRandomEventType() {
        int eventIndex = random1.nextInt(RandomEventType.values().length);
        Output.slowPrint("There is a chance of " + RandomEventType.values()[eventIndex]);
        return RandomEventType.values()[eventIndex];
    }

}