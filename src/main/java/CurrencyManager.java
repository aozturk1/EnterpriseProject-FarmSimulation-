/**
 * a simple money manager.
 * a singleton implementation that manages.
 * all things related to Farm Coins/ money for the farms.
 */
public class CurrencyManager {
    private static CurrencyManager instance;
    private int currency;

    /**
     * default constructor.
     */
    private CurrencyManager() {
        currency = 0;
    }

    /**
     * synchronized instantiation of CurrencyManager.
     * @return CurrencyManager() instance
     */
    public static synchronized CurrencyManager getInstance() {
        if (instance == null) {
            instance = new CurrencyManager();
        }
        return instance;
    }

    /**
     * adds Farm Coins to the balance.
     * @param amount the amount to be added to the balance
     */
    public void addCurrency(int amount) {
        currency += amount;
    }

    /**
     * subtracts Farm Coins from the balance.
     * @param amount the amount to be subtracted from the balance
     */
    public void spendCurrency(int amount) {
        currency -= amount;
    }

    /**
     * returns balance.
     * @return currency
     */
    public int getCurrency() {
        return currency;
    }
}
