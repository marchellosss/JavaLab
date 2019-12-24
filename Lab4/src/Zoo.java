import Animals.Animal;
import Enclosures.BirdsEnclosure;
import Enclosures.Enclosure;
import Enclosures.LionEnclosure;
import Enclosures.UngulatesEnclosure;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Enclosure> enclosures = new ArrayList<Enclosure>();//створюємо ліст у якому будуть всі вольєри

    public Zoo(){
        this.addEnclosures();
    }
    public int getCountOfAnimals () {
        int lionsCount; int ungulatesCount; int birdsCount;
        int generalCount;
        lionsCount= enclosures.get(0).getNumberOfBusyPlaces();
        ungulatesCount = enclosures.get(1).getNumberOfBusyPlaces();
        birdsCount = enclosures.get(2).getNumberOfBusyPlaces();
        generalCount = lionsCount + ungulatesCount + birdsCount;
        return generalCount;
    }//порахувати кількість вивести кількість зайнятих кліток у створених вольєрах

    private  void addEnclosures(){
        LionEnclosure lionEnclosure = new LionEnclosure(20);
        UngulatesEnclosure ungulatesEnclosure = new UngulatesEnclosure(40);
        BirdsEnclosure birdsEnclosure = new BirdsEnclosure(20, true);
        enclosures.add(lionEnclosure);
        enclosures.add(ungulatesEnclosure);
        enclosures.add(birdsEnclosure);

    }//додаємо створений вольєр в list

    public boolean addCage(int animalType){
        boolean result = false;
        if( animalType >= 0 && animalType <=2) {
            enclosures.get(animalType).setNumberOfFreePlaces(enclosures.get(animalType).getNumberOfFreePlaces() + 1);
            result= true;
        }
        return result;
    }//додаємо клітку у вольєр

    public boolean addAnimalToEnclosure(Animal animal){
        boolean result = false;
        result = enclosures.get(animal.getAnimalType()).addAnimalToEnclosure(animal);
        return result;
    }///садимо тварину у вольєр

    public boolean removeAnimalFromEnclosure(Animal animal){
        boolean result = false;
        result = enclosures.get(animal.getAnimalType()).removeAnimalFromEnclosure(animal);
        return result;
    }///виганяємо тварину

}
