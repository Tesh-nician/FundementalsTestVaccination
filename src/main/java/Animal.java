import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public abstract class Animal implements Vaccinateable,Treatable {

    private Map<Disease,Boolean> isVaccinated = new HashMap<>();




    //of(Disease.CHICKENPOX,false,Disease.FLUE,false,Disease.POLIO,false,Disease.HEPATITISA,false);
        //new TreeMap<Disease,Boolean>();





    private boolean isClean=false; //has this animal been cleaned up?

    Disease disease;  //disease for which this animal (not) has been vaccinated
    private int age; //age of the animal
    String name; //name of the animal
    private int animalNumber; //identification number of this animal





    public Animal() {                       //default constructor
    }

    public Animal( int age, String name) {

        this.age = age;
        this.name = name;
        //this.animalNumber = animalNumber;
        isVaccinated.put(Disease.CHICKENPOX,false);
        isVaccinated.put(Disease.FLUE,false);
        isVaccinated.put(Disease.POLIO,false);
        isVaccinated.put(Disease.HEPATITISA,false);

    }


    public Map<Disease, Boolean> getIsVaccinated() {  //provides overview of all vaccinations of the animal

        return isVaccinated;
    }
    public boolean getIsVaccinated(Disease disease) {  //checks if animal has been vaccinated for one specific disease

        return isVaccinated.get(disease);
    }






    public boolean isClean() {
        return isClean;
    }



    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public void setClean() {
        this.isClean = true;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    @Override
    public void vaccinateAnimal(Disease disease) {

        this.isVaccinated.replace(disease,true);
    }

      //  ;

    //}

    @Override
    public String toString() {
        return name+" ,"+age+" years old, ID: "+animalNumber;
    }



}




