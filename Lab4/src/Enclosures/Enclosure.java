package Enclosures;

import Animals.Animal;

public class Enclosure {
    private int numberOfFreePlaces;
    private int numberOfBusyPlaces;
    private int[] cages;
    private int cagesCount;

    public Enclosure(int numberOfFreePlaces) {
        this.numberOfFreePlaces = numberOfFreePlaces;
        this.numberOfBusyPlaces = 0;
        cages = new int[this.numberOfFreePlaces];
        this.cagesCount=0;
    }

    public int getNumberOfFreePlaces() {
        return numberOfFreePlaces;
    }

    public int getNumberOfBusyPlaces() {
        return numberOfBusyPlaces;
    }

    public void setNumberOfFreePlaces(int numberOfFreePlaces) {
        this.numberOfFreePlaces = numberOfFreePlaces;
    }

    public boolean addAnimalToEnclosure(Animal animal) {

        boolean result = false;

        if( this.numberOfFreePlaces!= 0) {

            this.numberOfFreePlaces--;
            this.numberOfBusyPlaces++;

            cages[cagesCount] = animal.getId();
            cagesCount++;

            result = true;
        }

        return result;
    }

    public boolean removeAnimalFromEnclosure(Animal animal) {

        boolean result = false;

        for ( int i =0; i< cagesCount; i++)
        {
            if(cages[i]== animal.getId())
            {
                result = true;

                this.numberOfFreePlaces++;
                this.numberOfBusyPlaces--;

                for ( int j = i; j< cagesCount-1; j++) {
                    cages[j]=cages[j+1];
                }

                break;
            }
        }

        return result;
    }
}
