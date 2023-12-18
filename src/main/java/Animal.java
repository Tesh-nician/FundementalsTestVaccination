import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Animal implements Vaccinateable,Treatable{

    private Map<Disease,Boolean> isVaccinated = Map.of(Disease.CHICKENPOX,false,Disease.FLUE,false,Disease.POLIO,false,Disease.HEPATITISA,false);
        //new TreeMap<Disease,Boolean>();





    private boolean isClean=false; //has this animal been treated for its specific issues?

    Disease disease;  //disease for which this animal (not) has been vaccinated
    private int age; //age of the animal
    String name; //name of the animal
    private int animalNumber; //identification number of this animal



    public Animal() {                       //default constructor
    }

    public Animal( int age, String name, int animalNumber) {

        this.age = age;
        this.name = name;
        this.animalNumber = animalNumber;
    }

    @Override
    public String toString() {
        return name+" ,"+age+" years old, ID: "+animalNumber;
    }
}
