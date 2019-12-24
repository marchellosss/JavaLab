package Enclosures;

public class MammalEnclosure extends Enclosure {
    private  boolean isHerbivorous;

    public MammalEnclosure(int numberOfFreePlaces, boolean isHerbivorous) {
        super(numberOfFreePlaces);
        this.isHerbivorous = isHerbivorous;
    }

    public boolean isHerbivorous() {
        return isHerbivorous;
    }
}
