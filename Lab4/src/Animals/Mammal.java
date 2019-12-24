package Animals;

public class Mammal extends Animal {
    private String mammalType;///дика тварина/свійська

    public Mammal(int id, int age, String mammalType, int animalType) {
        super(id, age, animalType);
        this.mammalType = mammalType;
    }

    public String getMammalType() {
        return mammalType;
    }

}
