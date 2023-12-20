import java.util.Map;

public class Monkey extends Animal {
    boolean isHyperActive=true;


    public Monkey() {
    }

    public Monkey(int age, String name) {
        super(age, name);
        //this.isHyperActive = isHyperActive;

    }

    public Monkey(int age, String name, int animalNumber) {
        super(age, name);
        setAnimalNumber(animalNumber);

    }



    @Override
    public void treatAnimal() {         //ToDo: implement this method:Done

        setClean();
        this.isHyperActive=false;
        this.vaccinateAnimal(Disease.CHICKENPOX);
        this.vaccinateAnimal(Disease.FLUE);
        this.vaccinateAnimal(Disease.POLIO);
        this.vaccinateAnimal(Disease.HEPATITISA);
    }


    @Override
    public String toString() {
        return "Monkey{" +" name= " + name + ", ID= "+getAnimalNumber()+", age= "+getAge()+
                ", isHyperActive= " + isHyperActive +
                ", is vaccinated for: "+getIsVaccinated()+

                "}\n";
    }







}
