import java.util.Map;
import java.util.TreeMap;

public class Cat extends Animal {

    private boolean hasLongNails=true;


    public Cat() {
    }
  


    public Cat( int age, String name) {
        //Deze constructor is alleen voor data input in de main app.
        super(age, name);
    }

    public Cat( int age, String name, int animalNumber) {
        //Deze constructor is om objecten te maken die in de animals linkedlist worden toegevoegd.
        super(age, name);
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
        System.out.println(getName()+" has been treated: cleaned, declawed and full set of vaccinations was given.");
    }


    @Override
    public String toString() {
        return "Cat{" + " name= " + name + " ID= "+getAnimalNumber()+" age= "+getAge()+
                " hasLongNails= " + hasLongNails +
                ", isclean= "+isClean()+
                ", isVaccinated for: " + getIsVaccinated() +
                "}\n";
    }
}
