import java.util.Map;

public class Cat extends Animal{

    private boolean hasLongNails=true;

    public Cat() {
    }

    public Cat(Map<Disease, Boolean> isVaccinated, boolean isClean, Disease disease, int age, String name, int animalNumber, boolean hasLongNails) {
        super(isVaccinated, isClean, disease, age, name, animalNumber);
        this.hasLongNails = hasLongNails;
    }

    @Override
    public void treatAnimal() {  //ToDo: implement methods treatAnimal

    }

    @Override
    public void vaccinateAnimal(Disease disease) {  //ToDo: implement method vaccinateAnimal

    }
}
