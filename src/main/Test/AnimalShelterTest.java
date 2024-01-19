import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    void testAddAnimal_andAnimalNumber() {

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

        Assertions.assertEquals(3,result1.size());//testing for Polio
        Assertions.assertEquals(0,result2.size()); //testing for treatment effects
    }



}