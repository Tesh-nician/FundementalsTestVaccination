import java.util.Map;

public class Dog extends Animal {

    private boolean hasFoulBreath=true;

    public Dog() {
    }

    public Dog(int age, String name, int animalNumber, boolean hasFoulBreath) {
        super(age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }

    @Override
    public void treatAnimal() { //ToDo: implement method treatAnimal:Done
        setClean();
        this.hasFoulBreath=false;
        this.vaccinateAnimal(Disease.CHICKENPOX);
        this.vaccinateAnimal(Disease.FLUE);
        this.vaccinateAnimal(Disease.POLIO);
        this.vaccinateAnimal(Disease.HEPATITISA);

    }



    @Override
    public String toString() {
        return "Dog{" +" name='" + name + "ID: "+getAnimalNumber()+" age:"+getAge()+
                " hasFoulBreath=" + hasFoulBreath +
                " is vaccinated for: "+getIsVaccinated()+
                ", disease=" + disease +
                '}';
    }






}
