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

import static java.lang.reflect.Array.get;
import static java.util.List.of;

public class AnimalShelterTest {


    @BeforeAll
    static void init() {


    }


    @Test
    void testPrintAnimals_AlsoWithEmptyList() {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        List<Animal> result = myAnimalShelter.printAnimals();

        Assertions.assertEquals(Collections.EMPTY_LIST,result);   //is het beter om null of empty list te returnen?


    }


    @Test
    void testAddAnimal_ContainsAnimalNumber() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(0, null));
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));
        myAnimalShelter.addAnimal(new Monkey(10,"Donald"));

        List<Animal> result = myAnimalShelter.printAnimals();

        Assertions.assertTrue(result.contains(new Cat(0, null,0)));
        Assertions.assertTrue(result.contains(new Monkey(10, "Donald",2)));
        Assertions.assertTrue(result.contains(new Dog(2, "Worf",1)));

    }


    @Test
    void testAddAnimal2_withCountAnimals_andLargeSizeOfList() {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        int sizeExpected=0;
        int sizeActual = myAnimalShelter.countAnimals();

        Assertions.assertEquals(sizeExpected,sizeActual); //empty list


        for (int i=0;i<1000000;i++) {

            myAnimalShelter.addAnimal(new Cat(0, "Fluffy"+i));
            myAnimalShelter.addAnimal(new Dog(2,"Worf"+i));
            myAnimalShelter.addAnimal(new Monkey(10,"Donald"+i));
        }

        sizeExpected=3000000;
        sizeActual = myAnimalShelter.countAnimals();

        Assertions.assertEquals(sizeExpected,sizeActual); //3_000_000

        List<Animal> result = myAnimalShelter.printAnimals();


        Assertions.assertEquals(sizeExpected,result.size()); //does this also match with printAnimals method?

    }

    @Test
    void testSortAnimalbyName() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(0, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(10,"Donald"));//2

        List<Animal> resultSortedByName = myAnimalShelter.sortAnimalsbyName();

        Assertions.assertEquals("Donald",resultSortedByName.get(0).getName());
    }

    @Test
    void testSortAnimal() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(0, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(10,"Donald"));//2

        List<Animal> resultSortedByName = myAnimalShelter.sortAnimalsbyName();

        List<Animal> resultSortedByIDnumber = myAnimalShelter.sortAnimals();

        Assertions.assertTrue(resultSortedByIDnumber.get(0).getAnimalNumber() == 0);
    }

    @Test
    void testSortAnimalbyAge() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(0,"Donald"));//2

        List<Animal> resultSortedByAge = myAnimalShelter.sortAnimalsbyAge();

        Assertions.assertEquals("Donald",resultSortedByAge.get(0).getName());
    }

    @Test
    void testPrintAnimalsNotVaccinated_CombinedWith_TreatAllAnimals() {

        AnimalShelter myAnimalShelter = new AnimalShelter();
        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(0,"Donald"));//2

        List<Animal> result1= myAnimalShelter.printAnimalsNotVaccinated(Disease.POLIO);
        myAnimalShelter.treatAllAnimals();
        List<Animal> result2= myAnimalShelter.printAnimalsNotVaccinated(Disease.POLIO);

        Assertions.assertEquals(3,result1.size());//testing for printAnimalsNotVaccinated
        Assertions.assertEquals(0,result2.size()); //testing for treatAllAnimals
    }

    @Test
    void testFindAnimal_byAnimalNumber() {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.addAnimal(new Cat(10, null)); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(0,"Donald"));//2
        String resultFindAnimalbyAnimalID2 = myAnimalShelter.findAnimal(0).get().getName(); //return type is Optional!!!
        String resultFindAnimalbyAnimalID3 = myAnimalShelter.findAnimal(1).get().getName();
        String resultFindAnimalbyAnimalID4 = myAnimalShelter.findAnimal(2).get().getName();

        Assertions.assertEquals(null,resultFindAnimalbyAnimalID2);
        Assertions.assertEquals("Worf",resultFindAnimalbyAnimalID3);
        Assertions.assertEquals("Donald",resultFindAnimalbyAnimalID4);
    }


    @Test
    void testFindAnimal_byName() {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        List<Animal> resultFindAnimalbyName1 = myAnimalShelter.findAnimal("Worf");

        Assertions.assertEquals(Collections.EMPTY_LIST,resultFindAnimalbyName1);

        myAnimalShelter.addAnimal(new Cat(10, null)); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(0,"Donald"));//2
        myAnimalShelter.addAnimal(new Monkey(4,"Donald"));//3

        List<Animal> resultFindAnimalbyAnimalID2 = myAnimalShelter.findAnimal("Worf");
        List<Animal> resultFindAnimalbyAnimalID3 = myAnimalShelter.findAnimal("Donald");

        Assertions.assertTrue(resultFindAnimalbyAnimalID2.contains(new Dog(2,"Worf",1)));
        Assertions.assertEquals(2,resultFindAnimalbyAnimalID3.size());//number of animals with name "Donald" = 2

    }

    @Test
    void testFindOldestAnimal() {

        AnimalShelter myAnimalShelter = new AnimalShelter();

        List <Animal> resultFindOldestAnimal1 = myAnimalShelter.findOldestAnimal();

        Assertions.assertEquals(Collections.EMPTY_LIST,resultFindOldestAnimal1); //empty?

        //all animals have the same age
        myAnimalShelter.addAnimal(new Cat(2, "Fluffy")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(2,"Donald"));//2

        List <Animal> resultFindOldestAnimal2 = myAnimalShelter.findOldestAnimal();
        //System.out.println(resultFindOldestAnimal2);//for debugging

        Assertions.assertEquals(3,resultFindOldestAnimal2.size());//number of oldest animals

    }


    @Test
    void testTreatAnimal_byAnimalNumber() {

        //Opgelet: elke subklasse van animal implementeert zijn eigen treatment methode

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.treatAnimal(1); //Check to see if this runs.

        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(20,"Donald"));//2
        myAnimalShelter.addAnimal(new Cat(2,"Fluffy"));//3

        boolean beforeTreatAnimal = myAnimalShelter.findAnimal(0).get().getIsVaccinated(Disease.FLUE);
        myAnimalShelter.treatAnimal(0);
        boolean afterTreatAnimal = myAnimalShelter.findAnimal(0).get().getIsVaccinated(Disease.FLUE);

        Assertions.assertTrue((!beforeTreatAnimal&&afterTreatAnimal)); //not vaccinated before and vaccinated afterwards

        //test for declawing treament for Cats
        beforeTreatAnimal= (myAnimalShelter.findAnimal(3).get().toString().contains("hasLongNails= true, isclean= false"));
        myAnimalShelter.treatAnimal(3);//Zelda
        System.out.println(myAnimalShelter.findAnimal(3).get().toString());//debugging
        afterTreatAnimal= (myAnimalShelter.findAnimal(3).get().toString().contains("hasLongNails= true, isclean= false"));
        Assertions.assertTrue((beforeTreatAnimal&&!afterTreatAnimal)); //have the nails been shortened in Cats?

        //test for foulBreath treament for Dogs
        beforeTreatAnimal= (myAnimalShelter.findAnimal(1).get().toString().contains("hasFoulBreath= true, isclean= false"));
        myAnimalShelter.treatAnimal(1);//Worf
        afterTreatAnimal= (myAnimalShelter.findAnimal(1).get().toString().contains("hasFoulBreath= true, isclean= false"));
        Assertions.assertTrue((beforeTreatAnimal&&!afterTreatAnimal)); //is foul breath in Dogs being treated?


        //test for behavioural therapy for Monkeys
        boolean beforeTreatAnimal3= (myAnimalShelter.findAnimal(2).get().toString().contains("isHyperActive= true, isclean= false"));
        myAnimalShelter.treatAnimal(2);//Zelda
        System.out.println(myAnimalShelter.findAnimal(2).get().toString());//debugging
        boolean afterTreatAnimal3= (myAnimalShelter.findAnimal(2).get().toString().contains("isHyperactive= true, isclean= false"));
        Assertions.assertTrue((beforeTreatAnimal3&&!afterTreatAnimal3 )); //has the monkey received therapy?

    }

    @Test
    void testTreatAnimal_byName() {

        //Opgelet: elke subklasse van animal implementeert zijn eigen treatment methode

        AnimalShelter myAnimalShelter = new AnimalShelter();

        myAnimalShelter.treatAnimal("Zelda"); //Check to see if this runs.

        myAnimalShelter.addAnimal(new Cat(10, "Zelda")); //0
        myAnimalShelter.addAnimal(new Dog(2,"Worf"));//1
        myAnimalShelter.addAnimal(new Monkey(20,"Donald"));//2
        myAnimalShelter.addAnimal(new Cat(2,"Fluffy"));//3

        boolean beforeTreatAnimal = myAnimalShelter.findAnimal("Zelda").stream()
                        .map(animal -> animal.getIsVaccinated(Disease.FLUE))
                        .reduce((aBoolean, aBoolean2) -> aBoolean).orElse(false);
        myAnimalShelter.treatAnimal("Zelda");
        boolean afterTreatAnimal = myAnimalShelter.findAnimal("Zelda").stream()
                        .map(animal -> animal.getIsVaccinated(Disease.FLUE)).filter(aBoolean -> aBoolean)
                        .reduce((aBoolean, aBoolean2) -> aBoolean).orElse(false);
        Assertions.assertTrue((!beforeTreatAnimal&&afterTreatAnimal)); //not vaccinated before and vaccinated afterwards

        //test for declawing treatment for Cats
        beforeTreatAnimal= myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString()
                        .contains("hasLongNails= true, isclean= false"))
                        .reduce((aBoolean1, aBoolean2)-> aBoolean1).orElse(false);

        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString().contains("hasLongNails= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging
        myAnimalShelter.treatAnimal("Fluffy");
        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString().contains("hasLongNails= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging

        afterTreatAnimal= myAnimalShelter.findAnimal("Fluffy").stream().map(animal -> animal.toString()
                        .contains("hasLongNails= true, isclean= false"))
                        .reduce((aBoolean1, aBoolean2)-> aBoolean1).orElse(false);;

        Assertions.assertTrue((beforeTreatAnimal&&!afterTreatAnimal)); //have the nails been shortened in Cats?

        //test for foulBreath treament for Dogs
        beforeTreatAnimal= myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString()
                        .contains("hasFoulBreath= true, isclean= false"))
                        .reduce((aBoolean1, aBoolean2)-> aBoolean1).orElse(false);;

        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString().contains("hasFoulBreath= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging
        myAnimalShelter.treatAnimal("Worf");
        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString().contains("hasFoulBreath= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging

        afterTreatAnimal= myAnimalShelter.findAnimal("Worf").stream().map(animal -> animal.toString().contains("hasFoulBreath= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).orElse(false);;

        Assertions.assertTrue((beforeTreatAnimal&&!afterTreatAnimal)); //is foul breath in Dogs being treated?



        //test for behavioural therapy for Monkeys

        beforeTreatAnimal= myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString()
                        .contains("isHyperActive= true, isclean= false"))
                        .reduce((aBoolean1, aBoolean2)-> aBoolean1).orElse(false);;

        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString().contains("isHyperActive= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging
        myAnimalShelter.treatAnimal("Donald");
        //System.out.println("not treated: "+myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString().contains("isHyperActive= true, isclean= false")).reduce((aBoolean1, aBoolean2)-> aBoolean1).get());//debugging

        afterTreatAnimal= myAnimalShelter.findAnimal("Donald").stream().map(animal -> animal.toString()
                        .contains("isHyperActive= true, isclean= false"))
                        .reduce((aBoolean1, aBoolean2)-> aBoolean1).orElse(false);;

        Assertions.assertTrue((beforeTreatAnimal&&!afterTreatAnimal)); //is foul breath in Dogs being treated?

    }

}