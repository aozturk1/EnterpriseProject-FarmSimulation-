import java.util.ArrayList;
import java.util.List;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

    Animal[] getDeadAnimals();
}

interface Observer {
    void update(Observable observable);
}

class Animal implements Observable {
    // fields and methods for Animal

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public Animal[] getDeadAnimals() {
        return new Animal[0];
    }

    // methods for animal's life cycle
}

class Crop implements Observable {
    // fields and methods for Crop

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public Animal[] getDeadAnimals() {
        return new Animal[0];
    }

    // methods for crop's life cycle
}

class Farmer implements Observer {
    // fields and methods for Farmer

    public void update(Observable observable) {
        // code to handle notification of animal or crop death
    }
}

class Supplier implements Observer {
    // fields and methods for Supplier

    public void update(Observable observable) {
        // code to handle notification of new stock needed
    }
}
