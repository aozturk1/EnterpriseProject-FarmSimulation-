import java.util.concurrent.TimeUnit;

/**
 * a class that is used to enhance the simulation experience for the player.
 */
public class Output {

    /**
     * a method that slows down printing to console to make it more
     *  game like simulation experience.
     * @param output the string to be outputted
     */
    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                System.out.println("Error with slowPrint method");
            }
        }
        System.out.println();
    }

}
