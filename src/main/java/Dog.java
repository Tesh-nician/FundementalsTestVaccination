import java.util.Map;

public class Dog extends Animal{

    private boolean hasFoulBreath=true;

    public Dog() {
    }

    public Dog(Map<Disease, Boolean> isVaccinated, boolean isClean, Disease disease, int age, String name, int animalNumber, boolean hasFoulBreath) {
        super(isVaccinated, isClean, disease, age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }

    @Override
    public void treatAnimal() { //ToDo: implement method treatAnimal

    }

    @Override
    public void vaccinateAnimal(Disease disease) { //Todo: implement method vaccinateAnimal

    }
}
