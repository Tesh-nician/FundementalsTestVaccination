import java.util.*;
import java.util.stream.Collectors;

public class AnimalShelter {

    private List<Animal> animals = new LinkedList<>(); //holds the list of all animals in the animal shelter.
    private int animalID = 0; //used to increment the animalNumber in the addAnimal method

    public AnimalShelter() {   //no parameter constructor: animals are added using addAnimal method.
    }


    public void printAnimals() { //used a ternary to check if the list is empty
        System.out.println(animals.isEmpty() ? "No animals in this list" : Optional.of(animals).orElse(null));
    }


    public void sortAnimals() {  //Trivial :-), also used a ternary to check if the list is empty
        System.out.println(animals.isEmpty() ? "No animals in this list" : Optional.of(animals.stream().sorted(Comparator.comparing(Animal::getAnimalNumber)).collect(Collectors.toList())));
    }


    public void sortAnimalsbyName() {//used a ternary to check if the list is empty
        try {
            System.out.println(animals.isEmpty() ? "No animals in this list" : animals.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void sortAnimalsbyAge() {//used a ternary to check if the list is empty
        try {
            System.out.println(animals.isEmpty() ? "No animals in this list" : animals.stream().sorted(Comparator.comparing(Animal::getAge)).collect(Collectors.toList()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void printAnimalsNotVaccinated(Disease disease) { //used a ternary to check if the list is empty
        try {
            System.out.println(animals.isEmpty() ? "No animals in this list" : animals.stream().filter(a -> !a.getIsVaccinated(disease)).collect(Collectors.toList()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public Optional<Animal> findAnimal(int animalID) {
        //findFirst return type is always Optional!

        return (animals.stream().filter(animal -> animal.getAnimalNumber() == animalID).findFirst());
    }


    public List<Animal> findAnimal(String name) {
        //Possibility of multiple animals with the same name!
        return  animals.stream().filter(a -> Objects.equals(a.getName(), name)).collect(Collectors.toList());

    }


    public void treatAnimal(int animalNumber) {
        //check if animal is present

        if (findAnimal(animalNumber).isPresent()) {
            animals.stream().filter(animal -> animal.getAnimalNumber() == animalNumber).forEach(Animal::treatAnimal);
        } else {
            System.out.println("No animal with this ID number in the list.");
        }
    }


    public void treatAnimal(String name) {
        //check if animal is present.
        // Attention: there might be multiple animals with the same name!!! = Test is OK

        try {
            if (!findAnimal(name).isEmpty()) {
                animals.stream().filter(animal -> animal.getName().equals(name)).forEach(Animal::treatAnimal);
            } else {
                System.out.println("No animal with this name in the list.");
            }
        } catch (NullPointerException e) {e.printStackTrace();}


    }

    public void treatAllAnimals() {
        //Test with null = OK, geen exception
        animals.forEach(Animal::treatAnimal);

    }


    public Animal findOldestAnimal() {
        //Test with multiple equal ages = OK
        //Test with null = geen exception
        return animals.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int countAnimals() {
        //Test with null=OK, geen exception
        return animals.size();
    }


    public void addAnimal(Animal animal) {
        /* I used two different constructors (one WITH and one WITHOUT animalNumber).
        The constructor without animalNumber is used only for data input.
        The constructor with animalNumber is used for input in the linkedlist */

        //System.out.println(animal.getClass());//for debugging

        String newAnimalType = animal.getClass().toString(); //extract animal class for use in switch.

        try {
            switch (newAnimalType) {
                case "class Cat":
                    animals.add(new Cat(animal.getAge(), animal.getName(), animalID));
                    break;
                case "class Dog":
                    animals.add(new Dog(animal.getAge(), animal.getName(), animalID));
                    break;
                case "class Monkey":
                    animals.add(new Monkey(animal.getAge(), animal.getName(), animalID));
                    break;
                default: {
                    System.out.println("Class " + newAnimalType + " does NOT exist!!!\nPlease check your animal type.");
                }
            }
            animalID++; //this increments the animal ID for the following animal being added.

        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            System.out.println("There is a problem with the animals being added to the list,\n please check that they have the correct attributes. \n");
            e.printStackTrace();
        }
    }
}
