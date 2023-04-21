import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * A test class to test the methods in Main class.
 */
public class SimulationTest {
    /**
     * A method that runs before each test to set up necessary resources.
     * @throws Exception if an exception occurs during setup
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * A method that runs after each test to clean up any resources created during testing.
     * @throws Exception if an exception occurs during teardown
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSlowPrint() {
        // Test printing an empty string
        new Output();
        Output.slowPrint("");

        // Test printing a string with newlines
        Output.slowPrint("This string\ncontains a newline.");

    }

    @Test
    public void testSupplier() {
        Supplier supplier = new Supplier("John Smith");
        assertNotNull(supplier);
        assertEquals("John Smith", supplier.name);
    }

    @Test
    public void testSupplierNotifyAnimal() throws Exception {
        AnimalFarm farm = new AnimalFarm();
        Supplier supplier = new Supplier("Rick");
        farm.addObservers(supplier);
        supplier.observableNotify();

        farm.tellObservers();

        assertNotNull(farm.getContacts());
    }

    @Test
    public void testSupplierNotifyCrop() throws Exception {
        CropFarm farm = new CropFarm();
        Supplier supplier = new Supplier("Rick");
        farm.addObservers(supplier);
        supplier.observableNotify();

        farm.tellObservers();

        assertNotNull(farm.getContacts());
    }

    @Test
    public void testGettersAnimalFarm() {
        AnimalFarm farm = new AnimalFarm();

        assertEquals(2, farm.getNumber());
        assertEquals(5, farm.getCapacityAmount());
        assertEquals(1, farm.getPassiveCurrency());
        assertEquals(10, farm.getUpgradeCost());
        assertEquals(1, farm.getFarmLevel());
    }

    @Test
    public void testGettersCropFarm() {
        CropFarm farm = new CropFarm();

        assertEquals(1, farm.getNumber());
        assertEquals(3, farm.getCapacityAmount());
        assertEquals(2, farm.getPassiveCurrency());
        assertEquals(5, farm.getUpgradeCost());
        assertEquals(1, farm.getFarmLevel());
    }

    @Test
    public void testGetRandomEventType() {
        Main.RandomEventType test = Main.getRandomEventType();

        assertNotNull(test);

        assertNotNull(Main.RandomEventType.values());
    }

    @Test
    public void testMain() {
        new Main();
        String[] test = new String[1];
        test[0] = "Test";
        Main.main(test);
    }

    @Test
    public void testCropGetPassiveCurrency() {
        CropFarm farm = new CropFarm();
        assertEquals(2, farm.getPassiveCurrency(3));
        assertEquals(1, farm.getPassiveCurrency(2));
    }

    @Test
    public void testCropUpgrade() {
        CropFarm farm = new CropFarm();
        farm.upgrade();
        CurrencyManager.getInstance().addCurrency(100);
        farm.upgrade();
    }

    @Test
    public void testAnimalGetPassiveCurrency() {
        AnimalFarm farm = new AnimalFarm();
        assertEquals(2, farm.getPassiveCurrency(1));
    }

    @Test
    public void testAnimalRunCycle() {
        AnimalFarm farm = new AnimalFarm();
        farm.runCycle(1);
    }

    @Test
    public void testAnimalUpgrade() {
        AnimalFarm farm = new AnimalFarm();
        farm.upgrade();
        CurrencyManager.getInstance().addCurrency(100);
        farm.upgrade();
    }

    @Test
    public void testCropGetCapacity() {
        CropFarm farm = new CropFarm();
        farm.generateRandomEvent(Main.RandomEventType.EQUIPMENT_EXPENSES);
        farm.generateRandomEvent(Main.RandomEventType.WEATHER_STORM);
        farm.generateRandomEvent(Main.RandomEventType.MARKET_CRASH);
        farm.generateRandomEvent(Main.RandomEventType.DISEASE_OUTBREAK);
        assertFalse(farm.getCapacity());
    }

}