import Animals.Lion;

public class Main {
    public static void main(String[] args) {

        Lion lion = new Lion(1,5,"Wild");
        Lion lion1 = new Lion(2,5,"Wild");
        Zoo zoo = new Zoo();

        System.out.println(zoo.addAnimalToEnclosure(lion));

        System.out.println(zoo.getCountOfAnimals());

        System.out.println(zoo.removeAnimalFromEnclosure(lion1));

        System.out.println( zoo.addCage(1));

    }
}
