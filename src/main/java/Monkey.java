import java.util.Map;

public class Monkey extends Animal{
    boolean isHyperActive=true;


    public Monkey() {
    }

    public Monkey(Map<Disease, Boolean> isVaccinated, boolean isClean, Disease disease, int age, String name, int animalNumber, boolean isHyperActive) {
        super(isVaccinated, isClean, disease, age, name, animalNumber);
        this.isHyperActive = isHyperActive;
    }

    @Override
    public void treatAnimal() {         //ToDo: implement this method

    }

    @Override
    public void vaccinateAnimal(Disease disease) {  //ToDo: implement this method

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
