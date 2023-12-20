import java.util.*;
import java.util.stream.Collectors;

public class AnimalShelter {

    private List<Animal> animals = new LinkedList<>(); //ToDo instantiate list of animals: Done
    private int animalID=0;

    public AnimalShelter() {   //animals are added using addAnimal method!!
    }


    public void printAnimals() {
        System.out.println(animals);
    }


    public void sortAnimals() {  //use streams, is trivial
        System.out.println(animals.stream().sorted(Comparator.comparing(Animal::getAnimalNumber)).collect(Collectors.toList()));
    }

    public void sortAnimalsbyName() {
        System.out.println(animals.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList()));
    }

    public void sortAnimalsbyAge() {
        System.out.println(animals.stream().sorted(Comparator.comparing(Animal::getAge)).collect(Collectors.toList()));
    }

    public void printAnimalsNotVaccinated(Disease disease) {
        System.out.println(animals.stream().filter(a-> !a.getIsVaccinated(disease)).collect(Collectors.toList()));

    }

    public Optional<Animal> findAnimal(int animalID) {//findFirst return type is always Optional!


            return (animals.stream().filter(animal -> animal.getAnimalNumber()==animalID).findFirst());

    }

    public Optional<Animal> findAnimal(String name) { //findFirst return type is always Optional!

        return (animals.stream().filter(a -> Objects.equals(a.getName(), name)).findFirst());

    }

    public void treatAnimal(int animalNumber){

        animals.stream().filter(animal -> animal.getAnimalNumber()==animalNumber).forEach(Animal::treatAnimal);

    }

    public void treatAnimal(String name){ //Attention: there might be multiple animals with the same name!!!

        animals.stream().filter(animal -> animal.getName().equals(name)).forEach(Animal::treatAnimal);

    }

    public void treatAllAnimals(){
        animals.forEach(Animal::treatAnimal);
    }



    public Optional <Animal> findOldestAnimal() {  //Test with multiple equal ages

     return animals.stream().max(Comparator.comparing(Animal::getAge));

    }

    public int countAnimals() {
        return animals.size();
    } //Test with null?



    public void addAnimal(Animal animal) {  //ToDo: remove temporary/dummy animalID from method = Done, used two different constructors (one with and one without animalNumber)

        System.out.println(animal.getClass());

        String newAnimalType = animal.getClass().toString();

        //Add error trapping here!
        //animalID is used 2 times: one is for the List and one is for the constructor.
        switch (newAnimalType) {
            case "class Cat":
                animals.add(animalID,new Cat(animal.getAge(), animal.getName(),animalID));

                break;
            case "class Dog":
                animals.add(animalID,new Dog(animal.getAge(), animal.getName(),animalID));

                break;
            case "class Monkey":
                animals.add(animalID,new Monkey(animal.getAge(), animal.getName(),animalID));

                break;

        }

        animalID++;
    }
}
