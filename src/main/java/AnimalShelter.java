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


    public void sortAnimals() {
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

    public Optional<Animal> findAnimal(int animalID) {


            return (animals.stream().filter(animal -> animal.getAnimalNumber()==animalID).findFirst());//ToDo: convert into optional

    }

    public Optional<Animal> findAnimal(String name) {

        return (animals.stream().filter(a -> Objects.equals(a.getName(), name)).findFirst());

    }

    public void treatAnimal(int animalNumber){

        animals.stream().filter(animal -> animal.getAnimalNumber()==animalNumber).forEach(Animal::treatAnimal);

    }

    public void treatAnimal(String name){

        animals.stream().filter(animal -> animal.getName().equals(name)).forEach(Animal::treatAnimal);

    }

    public void treatAllAnimals(){
        animals.forEach(Animal::treatAnimal);
    }

    public Optional <Animal> findOldestAnimal() {

     return animals.stream().max(Comparator.comparing(Animal::getAge));

    }

    public int countAnimals() {
        return animals.size();
    }



    public void addAnimal(Animal animal) {

        System.out.println(animal.getClass());

        String newAnimalType = animal.getClass().toString();

        //Add error trapping here!
        //Todo: remove redundant animalID from Cat/Dog/Monkey class
        switch (newAnimalType) {
            case "class Cat":
                animals.add(animalID,new Cat(animal.getAge(), animal.getName(), animalID,true));
                break;
            case "class Dog":
                animals.add(animalID,new Dog(animal.getAge(), animal.getName(), animalID,true));
                break;
            case "class Monkey":
                animals.add(animalID,new Monkey(animal.getAge(), animal.getName(), animalID,true));
                break;

        }

        animalID++;
    }
}
