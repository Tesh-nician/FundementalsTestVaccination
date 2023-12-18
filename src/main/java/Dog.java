import java.util.Map;

public class Dog extends Animal{

    private boolean hasFoulBreath=true;

    public Dog() {
    }

    public Dog(int age, String name, int animalNumber, boolean hasFoulBreath) {
        super(age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }

    @Override
    public void treatAnimal() { //ToDo: implement method treatAnimal

    }

    @Override
    public void vaccinateAnimal(Disease disease) { //Todo: implement method vaccinateAnimal

    }

    @Override
    public String toString() {
        return "Dog{" +
                "hasFoulBreath=" + hasFoulBreath +
                ", disease=" + disease +
                ", name='" + name + '\'' +
                '}';
    }
}
