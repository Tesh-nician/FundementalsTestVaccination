public class AnimalShelterApp {
    public static void main(String[] args) {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.addAnimal(new Cat(0,"Fluffy"));
        myAnimalShelter.addAnimal(new Dog(1,"Fluffy"));
        myAnimalShelter.addAnimal(new Monkey(3,"Kong"));
        myAnimalShelter.addAnimal(new Cat(5,"Sheba"));
        myAnimalShelter.addAnimal(new Dog(6,"Bella"));
        myAnimalShelter.addAnimal(new Monkey(3,"Jane"));
        myAnimalShelter.addAnimal(new Cat(4,"Tiger"));
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));
        myAnimalShelter.addAnimal(new Monkey(1,"Rudi"));
        myAnimalShelter.addAnimal(new Monkey(11,"Donald"));





        System.out.println("\n============================================================================================\n" +
                "printAnimals: \n");
        myAnimalShelter.printAnimals();

        System.out.println("\n============================================================================================\n" +
                "sortAnimals (by animalNumber):\n ");
        myAnimalShelter.sortAnimals();

        System.out.println("\n============================================================================================\n" +
                "sortAnimalsByName:\n ");
        myAnimalShelter.sortAnimalsbyName();

        System.out.println("\n============================================================================================\n" +
                "sortAnimalsByAge:\n ");
        myAnimalShelter.sortAnimalsbyAge();

        System.out.println("\n============================================================================================\n" +
                "Not vaccinated for ChickenPox:\n ");
        myAnimalShelter.printAnimalsNotVaccinated(Disease.CHICKENPOX);

        System.out.println("\n============================================================================================\n" +
                "Find animal with ID number 2:\n "); //add error trapping=done
        System.out.println(myAnimalShelter.findAnimal(2).isPresent()?myAnimalShelter.findAnimal(2):"No animal with this ID in the list");

        System.out.println("\n============================================================================================\n" +
                "Find animal(s) with name Fluffy: \n"); //add error trapping for null, if necessary
        System.out.println(myAnimalShelter.findAnimal("Fluffy"));

        System.out.println("\n============================================================================================\n" +
                "Treating Animal with name Fluffy:\n \n");
        myAnimalShelter.treatAnimal("Fluffy");

        System.out.println("\n============================================================================================\n" +
                "Treating Animal with ID number 5 \n");
        myAnimalShelter.treatAnimal(5);

        System.out.println("\nCheck for treatment:\n");
        myAnimalShelter.printAnimals();

        System.out.println("\n============================================================================================\n" +
                "Treating ALL Animals \n");
        myAnimalShelter.treatAllAnimals();

        System.out.println("\nCheck for treatment:\n");
        myAnimalShelter.printAnimals();


        System.out.println("\n============================================================================================\n" +
                "Find oldest animal:\n"); //add error trapping for null, if necessary
        System.out.println(myAnimalShelter.findOldestAnimal());//add orElse exception NoSuchAnimal

        System.out.println("\n============================================================================================\n" +
                "Counting the number of animals in the shelter:\n"); //add error trapping for null, if necessary
        System.out.println(myAnimalShelter.countAnimals());//add orElse exception NoSuchAnimal



    }
}
