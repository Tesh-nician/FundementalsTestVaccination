public class AnimalShelterApp {
    public static void main(String[] args) {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.addAnimal(new Cat(0,"Fluffy"));
        myAnimalShelter.addAnimal(new Dog(1,"Rex"));
        myAnimalShelter.addAnimal(new Monkey(3,"Kong"));
        myAnimalShelter.addAnimal(new Cat(5,"Sheba"));
        myAnimalShelter.addAnimal(new Dog(6,"Bella"));
        myAnimalShelter.addAnimal(new Monkey(3,"Jane"));
        myAnimalShelter.addAnimal(new Cat(4,"Tiger"));
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));
        myAnimalShelter.addAnimal(new Monkey(1,"Rudi"));
        myAnimalShelter.addAnimal(new Monkey(11,"Donald"));

        System.out.println("\nprintAnimals: \n");
        myAnimalShelter.printAnimals();

        System.out.println("\nsortAnimals (by animalNumber): ");
        myAnimalShelter.sortAnimals();

        System.out.println("\nsortAnimalsByName: ");
        myAnimalShelter.sortAnimalsbyName();

        System.out.println("\nsortAnimalsByAge: ");
        myAnimalShelter.sortAnimalsbyAge();

        System.out.println("\nNot vaccinated for ChickenPox: ");
        myAnimalShelter.printAnimalsNotVaccinated(Disease.CHICKENPOX);

        System.out.println("\nFind animal with ID number 2: "); //add error trapping=done
        System.out.println(myAnimalShelter.findAnimal(2));

        System.out.println("\nFind animal with name Fluffy"); //add error trapping for null, if necessary
        System.out.println(myAnimalShelter.findAnimal("Fluffy"));//add orElse exception NoSuchAnimal

        System.out.println("\nTreating Animal with name Fluffy \n (cleaning, dealing with typical issues for the animal and full set of vaccinations)");
       myAnimalShelter.treatAnimal("Fluffy");

        System.out.println("\nTreating Animal with ID number 5 \n (cleaning, dealing with typical issues for the animal and full set of vaccinations)");
        myAnimalShelter.treatAnimal(5);
        myAnimalShelter.printAnimals();

        System.out.println("\nTreating ALL Animals \n (cleaning, dealing with typical issues for the animal and full set of vaccinations)");
        myAnimalShelter.treatAllAnimals();
        myAnimalShelter.printAnimals();


        System.out.println("\nFind oldest animal"); //add error trapping for null, if necessary
        System.out.println(myAnimalShelter.findOldestAnimal());//add orElse exception NoSuchAnimal

        System.out.println("\nCounting the number of animals in the shelter:"); //add error trapping for null, if necessary
        System.out.println(myAnimalShelter.countAnimals());//add orElse exception NoSuchAnimal



    }
}
