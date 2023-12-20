import java.util.Map;
import java.util.TreeMap;

public class Cat extends Animal {

    private boolean hasLongNails=true;


    public Cat() {
    }
   // Map<Disease,Boolean> isVaccinated = new TreeMap<>();


    public Cat( int age, String name) {

        super(age, name);
       // this.hasLongNails = hasLongNails;
    }

    public Cat( int age, String name, int animalNumber) {

        super(age, name);
        // this.hasLongNails = hasLongNails;
        setAnimalNumber(animalNumber);
    }



    @Override
    public void treatAnimal() {  //ToDo: implement methods treatAnimal :Done
        setClean();
        this.hasLongNails=false;
        this.vaccinateAnimal(Disease.CHICKENPOX);
        this.vaccinateAnimal(Disease.FLUE);
        this.vaccinateAnimal(Disease.POLIO);
        this.vaccinateAnimal(Disease.HEPATITISA);
    }


    @Override
    public String toString() {
        return "Cat{" + " name= " + name + "ID= "+getAnimalNumber()+" age= "+getAge()+
                " hasLongNails= " + hasLongNails +
                ", isVaccinated for: " + getIsVaccinated() +
                ", disease=" + disease +
                "}\n";
    }





}
