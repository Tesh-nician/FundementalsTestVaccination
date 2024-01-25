import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;


/**
 * 1. Print method shouldn't return
 * 2. test if the added animal is in the collection, don't create a new animal to test it
 * 3. no need to test with 3M animals, we want to test our code, not the List
 * 4. check if the entire collection is sorted, not only the first element
 */

public class AnimalShelterTest {
    private AnimalShelter myAnimalShelter;

    @BeforeEach
    public void init() {
        this.myAnimalShelter = new AnimalShelter();
    }


    @Test
    void testPrintAnimals_AlsoWithEmptyList() {
        List<Animal> result = myAnimalShelter.printAnimals();

        Assertions.assertEquals(Collections.EMPTY_LIST, result);   //is het beter om null of empty list te returnen?


    }

    /**
     * object equals() : o1 == o2
     * impl   equals() : o1.a == o2.a && o1.b == o2.b ...
     * impl2  equals() : o1.id == o1.id
     */


    @Test
    void testAddAnimal() {
        Cat cat = new Cat(0, null);
        Dog dog = new Dog(2, "Worf");
        Monkey monkey = new Monkey(10, "Donald");

        myAnimalShelter.addAnimal(cat);
        myAnimalShelter.addAnimal(dog);
        myAnimalShelter.addAnimal(monkey);

//        List<Animal> result = myAnimalShelter.getAnimals();
//
//        Assertions.assertTrue(result.contains(cat));
//        Assertions.assertTrue(result.contains(dog));
//        Assertions.assertTrue(result.contains(monkey));
//
        List<Animal> catNull = myAnimalShelter.findAnimal(null);
        List<Animal> worf = myAnimalShelter.findAnimal("Worf");
        List<Animal> donald = myAnimalShelter.findAnimal("Donald");

        Assertions.assertTrue(catNull.contains(cat));
        Assertions.assertTrue(worf.contains(dog));
        Assertions.assertTrue(donald.contains(monkey));

    }

    void testIfCountAnimalsReturnZeroOnAnimalShelterInitialisation() {
        int sizeExpected = 0;
        int sizeActual = myAnimalShelter.countAnimals();

        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    void testCountAnimalsWithAnimalsInside() {
        myAnimalShelter.addAnimal(new Cat(0, "Fluffy"));
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));
        myAnimalShelter.addAnimal(new Monkey(10, "Donald"));

        int sizeExpected = 3;
        int sizeActual = myAnimalShelter.countAnimals();
        Assertions.assertEquals(sizeExpected, sizeActual); //3
    }

    @Test
    void testSortAnimalbyName() {
        Cat cat = new Cat(0, "Zelda");
        Dog dog = new Dog(2, "Worf");
        Monkey monkey = new Monkey(10, "Donald");

        myAnimalShelter.addAnimal(cat); //0
        myAnimalShelter.addAnimal(dog);//1
        myAnimalShelter.addAnimal(monkey);//2


        List<Animal> sorted = new LinkedList<>();
        sorted.add(0,cat);
        sorted.add(1,dog);
        sorted.add(2,monkey);

       // sorted.sort(Comparator.comparing(Animal::getName).reversed());  //niet nodig meer nodig nadat index is toegevoegd aan add()



        myAnimalShelter.sortAnimalsbyName();
        List<Animal> resultSortedByName = myAnimalShelter.getAnimals();

        Assertions.assertEquals(sorted, resultSortedByName);
    }

    @Test
    void testSortAnimal() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(0, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(10, "Donald"));//2

        List<Animal> resultSortedByName = myAnimalShelter.sortAnimalsbyName();

        List<Animal> resultSortedByIDnumber = myAnimalShelter.sortAnimals();

        Assertions.assertTrue(resultSortedByIDnumber.get(0).getAnimalNumber() == 0);
    }

    @Test
    void testSortAnimalbyAge() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(0, "Donald"));//2

        List<Animal> resultSortedByAge = myAnimalShelter.sortAnimalsbyAge();

        Assertions.assertEquals("Donald", resultSortedByAge.get(0).getName());
    }

    @Test
    void testTreatAllAnimals() {
        Cat cat = new Cat(0, "Zelda");
        Dog dog = new Dog(2, "Worf");
        Monkey monkey = new Monkey(10, "Donald");

        myAnimalShelter.addAnimal(cat); //0
        myAnimalShelter.addAnimal(dog);//1
        myAnimalShelter.addAnimal(monkey);//2

        myAnimalShelter.treatAllAnimals();

        Assertions.assertAll(() -> {
            for (Animal animal : List.of(cat, dog, monkey)) {
                Assertions.assertTrue(animal.getIsVaccinated(Disease.FLUE));
                Assertions.assertTrue(animal.getIsVaccinated(Disease.POLIO));
                Assertions.assertTrue(animal.getIsVaccinated(Disease.CHICKENPOX));
                Assertions.assertTrue(animal.getIsVaccinated(Disease.HEPATITISA));
            }
        });
    }

    @Test
    void testFindAnimal_byAnimalNumber() {
        myAnimalShelter.addAnimal(new Cat(10, null)); //0
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(0, "Donald"));//2

        String resultFindAnimalbyAnimalID2 = myAnimalShelter.findAnimal(0).get().getName(); //return type is Optional!!!
        String resultFindAnimalbyAnimalID3 = myAnimalShelter.findAnimal(1).get().getName();
        String resultFindAnimalbyAnimalID4 = myAnimalShelter.findAnimal(2).get().getName();

        Assertions.assertAll(() -> {
            Assertions.assertEquals(null, resultFindAnimalbyAnimalID2);
            Assertions.assertEquals("Worf", resultFindAnimalbyAnimalID3);
            Assertions.assertEquals("Donald", resultFindAnimalbyAnimalID4);
        });

    }


    @Test
    void testFindAnimal_byName() {
        Cat cat = new Cat(0, "Zelda");
        Dog dog = new Dog(2, "Worf");
        Monkey monkey = new Monkey(10, "Donald");
        Monkey monkey2 = new Monkey(20, "Donald");

        myAnimalShelter.addAnimal(cat); //0
        myAnimalShelter.addAnimal(dog);//1
        myAnimalShelter.addAnimal(monkey);//2
        myAnimalShelter.addAnimal(monkey2);//2

        List<Animal> expectedWorf = new ArrayList<>();
        expectedWorf.add(dog);

        List<Animal> expectedDonald = new ArrayList<>();
        expectedDonald.add(monkey);
        expectedDonald.add(monkey2);

        List<Animal> resultWorf = myAnimalShelter.findAnimal("Worf");
        List<Animal> resultDonald = myAnimalShelter.findAnimal("Donald");

        Assertions.assertAll(() -> {
            Assertions.assertEquals(expectedWorf, resultWorf);
            Assertions.assertEquals(expectedDonald, resultDonald);
        });
    }

    @Test
    void testFindOldestAnimal() {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        List<Animal> resultFindOldestAnimal1 = myAnimalShelter.findOldestAnimal();

        Assertions.assertEquals(Collections.EMPTY_LIST, resultFindOldestAnimal1); //empty?

        //all animals have the same age
        myAnimalShelter.addAnimal(new Cat(2, "Fluffy")); //0
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(2, "Donald"));//2

        List<Animal> resultFindOldestAnimal2 = myAnimalShelter.findOldestAnimal();
        //System.out.println(resultFindOldestAnimal2);//for debugging

        Assertions.assertEquals(3, resultFindOldestAnimal2.size());//number of oldest animals

    }


    @Test
    void testTreatAnimal_byAnimalNumber() {

        //Opgelet: elke subklasse van animal implementeert zijn eigen treatment methode

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.treatAnimal(1); //Check to see if this runs.

        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(20, "Donald"));//2
        myAnimalShelter.addAnimal(new Cat(2, "Fluffy"));//3

        boolean beforeTreatAnimal = myAnimalShelter.findAnimal(0).get().getIsVaccinated(Disease.FLUE);
        myAnimalShelter.treatAnimal(0);
        boolean afterTreatAnimal = myAnimalShelter.findAnimal(0).get().getIsVaccinated(Disease.FLUE);

        Assertions.assertTrue((!beforeTreatAnimal && afterTreatAnimal)); //not vaccinated before and vaccinated afterwards

        //test for declawing treament for Cats
        beforeTreatAnimal = (myAnimalShelter.findAnimal(3).get().toString().contains("hasLongNails= true, isclean= false"));
        myAnimalShelter.treatAnimal(3);//Zelda
        System.out.println(myAnimalShelter.findAnimal(3).get().toString());//debugging
        afterTreatAnimal = (myAnimalShelter.findAnimal(3).get().toString().contains("hasLongNails= true, isclean= false"));
        Assertions.assertTrue((beforeTreatAnimal && !afterTreatAnimal)); //have the nails been shortened in Cats?

        //test for foulBreath treament for Dogs
        beforeTreatAnimal = (myAnimalShelter.findAnimal(1).get().toString().contains("hasFoulBreath= true, isclean= false"));
        myAnimalShelter.treatAnimal(1);//Worf
        afterTreatAnimal = (myAnimalShelter.findAnimal(1).get().toString().contains("hasFoulBreath= true, isclean= false"));
        Assertions.assertTrue((beforeTreatAnimal && !afterTreatAnimal)); //is foul breath in Dogs being treated?


        //test for behavioural therapy for Monkeys
        boolean beforeTreatAnimal3 = (myAnimalShelter.findAnimal(2).get().toString().contains("isHyperActive= true, isclean= false"));
        myAnimalShelter.treatAnimal(2);//Zelda
        System.out.println(myAnimalShelter.findAnimal(2).get().toString());//debugging
        boolean afterTreatAnimal3 = (myAnimalShelter.findAnimal(2).get().toString().contains("isHyperactive= true, isclean= false"));
        Assertions.assertTrue((beforeTreatAnimal3 && !afterTreatAnimal3)); //has the monkey received therapy?

    }

    @Test
    void testTreatAnimal_byName() {

        //Opgelet: elke subklasse van animal implementeert zijn eigen treatment methode

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.treatAnimal("Zelda"); //Check to see if this runs.

        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2, "Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(20, "Donald"));//2
        myAnimalShelter.addAnimal(new Cat(2, "Fluffy"));//3

        boolean beforeTreatAnimal = myAnimalShelter.findAnimal("Zelda").stream()
                .map(animal -> animal.getIsVaccinated(Disease.FLUE))
                .reduce((aBoolean, aBoolean2) -> aBoolean).orElse(false);
        myAnimalShelter.treatAnimal("Zelda");
        boolean afterTreatAnimal = myAnimalShelter.findAnimal("Zelda").stream()
                .map(animal -> animal.getIsVaccinated(Disease.FLUE)).filter(aBoolean -> aBoolean)
                .reduce((aBoolean, aBoolean2) -> aBoolean).orElse(false);
        Assertions.assertTrue((!beforeTreatAnimal && afterTreatAnimal)); //not vaccinated before and vaccinated afterwards

        //test for declawing treatment for Cats
        beforeTreatAnimal = myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString()
                        .contains("hasLongNails= true, isclean= false"))
                .reduce((aBoolean1, aBoolean2) -> aBoolean1).orElse(false);

        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString().contains("hasLongNails= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging
        myAnimalShelter.treatAnimal("Fluffy");
        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString().contains("hasLongNails= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging

        afterTreatAnimal = myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString()
                        .contains("hasLongNails= true, isclean= false"))
                .reduce((aBoolean1, aBoolean2) -> aBoolean1).orElse(false);
        ;

        Assertions.assertTrue((beforeTreatAnimal && !afterTreatAnimal)); //have the nails been shortened in Cats?

        //test for foulBreath treament for Dogs
        beforeTreatAnimal = myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString()
                        .contains("hasFoulBreath= true, isclean= false"))
                .reduce((aBoolean1, aBoolean2) -> aBoolean1).orElse(false);
        ;

        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString().contains("hasFoulBreath= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging
        myAnimalShelter.treatAnimal("Worf");
        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString().contains("hasFoulBreath= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging

        afterTreatAnimal = myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString().contains("hasFoulBreath= true, isclean= false")).reduce((aBoolean1, aBoolean2) -> aBoolean1).orElse(false);
        ;

        Assertions.assertTrue((beforeTreatAnimal && !afterTreatAnimal)); //is foul breath in Dogs being treated?


        //test for behavioural therapy for Monkeys

        beforeTreatAnimal = myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString()
                        .contains("isHyperActive= true, isclean= false"))
                .reduce((aBoolean1, aBoolean2) -> aBoolean1).orElse(false);
        ;

        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString().contains("isHyperActive= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging
        myAnimalShelter.treatAnimal("Donald");
        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString().contains("isHyperActive= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging

        afterTreatAnimal = myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString()
                        .contains("isHyperActive= true, isclean= false"))
                .reduce((aBoolean1, aBoolean2) -> aBoolean1).orElse(false);
        ;

        Assertions.assertTrue((beforeTreatAnimal && !afterTreatAnimal)); //is foul breath in Dogs being treated?

    }

}