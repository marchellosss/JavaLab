package Animals;

public class Bird extends Animal {
    private boolean isPredator;


    public Bird(int id, int age, boolean isPredator, int animalType) {
        super(id, age, animalType);
        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
    }

}
