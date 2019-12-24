package Animals;

public class Ungulates extends Mammal {
    private boolean isEquiformes;//парнокопитний?

    public Ungulates(int id, int age, String mammalType,int animalType, boolean isEquiformes ) {
        super(id, age, mammalType, animalType);
        this.isEquiformes = isEquiformes;
    }

    public boolean isEquiformes() {
        return isEquiformes;
    }


}
