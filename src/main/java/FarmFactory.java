/**
 * a class that implements the factory pattern which creates a specific
 *  farm depending on the random input generated.
 */
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