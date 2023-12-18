import java.util.Map;
import java.util.TreeMap;

public class Cat extends Animal{

    private boolean hasLongNails=true;

    public Cat() {
    }
    Map<Disease,Boolean> isVaccinated = new TreeMap<>();


    public Cat( int age, String name, int animalNumber, boolean hasLongNails) {

        super(age, name, animalNumber);
        this.hasLongNails = hasLongNails;
    }

    @Override
    public void treatAnimal() {  //ToDo: implement methods treatAnimal

    }

    @Override
    public void vaccinateAnimal(Disease disease) {  //ToDo: implement method vaccinateAnimal

    }

    @Override
    public String toString() {
        return "Cat{" +
                "hasLongNails=" + hasLongNails +
                ", isVaccinated=" + isVaccinated +
                ", disease=" + disease +
                ", name='" + name + '\'' +
                '}';
    }
}
