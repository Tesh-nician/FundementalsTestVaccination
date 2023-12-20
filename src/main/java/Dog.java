import java.util.Map;

public class Dog extends Animal {

    private boolean hasFoulBreath=true;

    public Dog() {
    }

    public Dog(int age, String name) {
       //Deze constructor is alleen voor data input in de main app.
       super(age, name);
    }

    public Dog(int age, String name, int animalNumber) {
        //Deze constructor is om objecten te maken die in de animals linkedlist worden toegevoegd.
        super(age, name);
        setAnimalNumber(animalNumber);
    }



    @Override
    public void treatAnimal() { //ToDo: implement method treatAnimal:Done
        setClean();
        this.hasFoulBreath=false;
        this.vaccinateAnimal(Disease.CHICKENPOX);
        this.vaccinateAnimal(Disease.FLUE);
        this.vaccinateAnimal(Disease.POLIO);
        this.vaccinateAnimal(Disease.HEPATITISA);
        System.out.println(getName()+" has been treated: cleaned, teeth cleaned (= cause of bad breath) and full set of vaccinations was given.");
    }



    @Override
    public String toString() {
        return "Dog{" +" name='" + name + " ID= "+getAnimalNumber()+" age= "+getAge()+
                " hasFoulBreath= " + hasFoulBreath +
                ", isclean= "+isClean()+
                " is vaccinated for: "+getIsVaccinated()+
                "}\n";
    }
}
