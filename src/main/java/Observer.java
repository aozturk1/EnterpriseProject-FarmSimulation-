public interface Observer {
    void observableNotify();
}

class News implements Observer {
    //fields and methods for News
    String name;

    public News(String name) {
        this.name = name;
    }

    @Override
    public void observableNotify() {
        // code to handle notification of bad whether
        //Output.slowPrint(name + ": HIGH CHANCE OF TORNADO");
    }
}

class Supplier implements Observer {
    // fields and methods for Supplier
    String name;

    public Supplier(String name) {
        this.name = name;
    }

    @Override
    public void observableNotify() {
        // code to handle notification of new stock needed
        Output.slowPrint("This is " + name + ", heard you need some more stock");
    }
}
