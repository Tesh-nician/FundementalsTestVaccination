import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Animal implements Vaccinateable,Treatable{

    private Map<Disease,Boolean> isVaccinated = new TreeMap<>();
    private boolean isClean; //has this animal been treated for its specific issues?

    Disease disease;  //disease for which this animal (not) has been vaccinated
    private int age; //age of the animal
    String name; //name of the animal
    private int animalNumber; //identification number of this animal

    public Animal() {                       //default constructor
    }

    public Animal(Map<Disease, Boolean> isVaccinated, boolean isClean, Disease disease, int age, String name, int animalNumber) {
        this.isVaccinated = isVaccinated;
        this.isClean = isClean;
        this.disease = disease;
        this.age = age;
        this.name = name;
        this.animalNumber = animalNumber;
    }
}
