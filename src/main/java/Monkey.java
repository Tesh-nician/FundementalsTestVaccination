

public class Monkey extends Animal {
    boolean isHyperActive=true;


    public Monkey() {  }


    public Monkey(int age, String name) {
        //Deze constructor is alleen voor data input in de main app.
        super(age, name); //NullpointerException indien deze instructie wordt weggecommenteerd. Trap deze exception = done
    }


    public Monkey(int age, String name, int animalNumber) {
        //Deze constructor is om objecten te maken die in de animals linkedlist worden toegevoegd.
        super(age, name);
        setAnimalNumber(animalNumber);
    }


    @Override
    public void treatAnimal() {
        setClean();
        this.isHyperActive=false;
        this.vaccinateAnimal(Disease.CHICKENPOX);
        this.vaccinateAnimal(Disease.FLUE);
        this.vaccinateAnimal(Disease.POLIO);
        this.vaccinateAnimal(Disease.HEPATITISA);
        System.out.println(getName()+" has been treated: cleaned, behavioural therapy for hyperactivity and full set of vaccinations was given.");
    }


    @Override
    public String toString() {
        return "Monkey{" +" name= " + name + ", ID= "+getAnimalNumber()+", age= "+getAge()+
                ", isHyperActive= " + isHyperActive +
                ", isclean= "+isClean()+
                ", is vaccinated for: "+getIsVaccinated()+
                "}\n";
    }
}
