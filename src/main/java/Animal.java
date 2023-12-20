import java.util.*;

public abstract class Animal implements Vaccinateable,Treatable {

    private Map<Disease,Boolean> isVaccinated = new HashMap<>();



    private boolean isClean=false; //has this animal been cleaned up?

    Disease disease;  //disease for which this animal (not) has been vaccinated
    private int age; //age of the animal
    String name; //name of the animal
    private int animalNumber; //identification number of this animal





    public Animal() {}

    public Animal( int age, String name) {
        this.age = age;
        this.name = name;

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





    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public boolean isClean() {
        return isClean;
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


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Animal animal = (Animal) object;
        return getAge() == animal.getAge() && getAnimalNumber() == animal.getAnimalNumber() && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getAnimalNumber());
    }
}




