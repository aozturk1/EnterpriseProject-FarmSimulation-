public class CurrencyManager {
    private static CurrencyManager instance;
    private int currency;

    private CurrencyManager() {
        currency = 0;
    }

    public static synchronized CurrencyManager getInstance() {
        if (instance == null) {
            instance = new CurrencyManager();
        }
        return instance;
    }

    public void addCurrency(int amount) {
        currency += amount;
    }

    public void spendCurrency(int amount) {
        currency -= amount;
    }

    public int getCurrency() {
        return currency;
    }
}
