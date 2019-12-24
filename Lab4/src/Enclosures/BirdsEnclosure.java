package Enclosures;

public class BirdsEnclosure extends Enclosure {
    private boolean isPredator;

    public BirdsEnclosure(int numberOfFreePlaces, boolean isPredator) {
        super(numberOfFreePlaces);
        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
    }
}
