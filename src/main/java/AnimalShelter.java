import java.util.LinkedList;
import java.util.List;

public class AnimalShelter {

    private List<Animal> animals = new LinkedList<>(); //ToDo instantiate list of animals.
    private int animalID=0;

    public AnimalShelter() {   //animals are added using addAnimal method!!
    }

    public void addAnimal(Animal animal) {

        animals.add(animalID,animal);
        animalID++;
    }
}
