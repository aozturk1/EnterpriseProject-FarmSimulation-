import java.util.concurrent.TimeUnit;

public class Output {

    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch (Exception e) {
            }
        } System.out.println();
    }

}
