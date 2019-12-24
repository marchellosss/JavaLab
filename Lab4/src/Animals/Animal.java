package Animals;

public class Animal {
     private int id;
     private int age;
     private int animalType;//1 - Lion, 2- Zebra, 3 - Giraffe, 4 - Eagle

    public Animal(int id, int age, int animalType) {
        this.id = id;
        this.age = age;
        this.animalType = animalType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnimalType() {
        return animalType;
    }
}
