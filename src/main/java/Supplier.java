/**
 * a use of the observer pattern and implementation of the Observer
 *  interface designed to notify the farm manager of supplier messages.
 */
class Supplier implements Observer {
    // fields and methods for Supplier
    String name;

    /**
     * default constructor.
     * @param name name of the supplier
     */
    public Supplier(String name) {
        this.name = name;
    }

    /**
     * a method that notifies the farm manager about supplier messages.
     */
    @Override
    public void observableNotify() {
        // code to handle notification of new stock needed
        Output.slowPrint("Hey this is " + name + ", heard you need some more stock");
    }
}