//package aYouZookeepersChallenge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

abstract public class Animal {


    private String animalName;
    private int age;
    private String gender;
    private String species;
    private String color;
    private int weight;
    private String birthPlace;
    public LocalDate birthday; // Birthday derived from age and birth season


    // Create a static attribute that belongs to the Animal class.
    public static int numOfAnimals = 0;
    // Map to derive the birth month from the season

    // Method to get the complete species count map
    public static Map<String, Integer> getAllSpeciesCount() {
        return new HashMap<>(speciesCount);
    }

    private static final Map<String, Integer> seasonToMonth = new HashMap<>();

    static {
        seasonToMonth.put("spring", 3); // March
        seasonToMonth.put("summer", 6); // June
        seasonToMonth.put("autumn", 9);  // September
        seasonToMonth.put("winter", 12); // December
    }


    // Animal Class constructors
    public Animal(int age, String gender, String species, String color, int weight, String birthPlace, String animalName) {
        System.out.println("\n A new Animal object was created.\n");

// Create initial values for the class attributes.
        this.animalName = animalName;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.color = color;
        this.weight = weight;
        this.birthPlace = birthPlace;
//        this.birthday = birthday;


        numOfAnimals++;
        speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
    }
}

    // Correct placement of method within class
    public LocalDate genBirthday(int age, String birthSeason) { // Ensure proper method definition
        int currentYear = LocalDate.now().getYear(); // Get current year
        int birthYear = currentYear - age; // Calculate birth year
        int birthMonth = seasonToMonth.getOrDefault(birthSeason.toLowerCase(), 1); // Default to January
        return LocalDate.of(birthYear, birthMonth, 1); // Return birthdate
    }
public String getBirthday() {
    return birthday.format(DateTimeFormatter.ISO_LOCAL_DATE); // Return ISO 8601 formatted date
}

public abstract String getID();



// Public getter method for 'animalName'
    public String getAnimalName() {
        return animalName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String getBirthPlace() {
        return birthPlace;
    }



// Derived classes for specific animals
class Hyena extends Animal {
    public Hyena(int age, String gender, String species, String color, int weight, String birthPlace, String animalName, LocalDate birthday) {
        super(age, gender, species, color, weight, birthPlace, animalName);
        System.out.println("Animal created: " + animalName + " - Birthday: " + birthday);
    }


//    @Override
    public String getID() {
        return "Hyena: " + animalName;
    }
}
    class Lion extends Animal {
        public Lion(int age, String gender, String species, String color, int weight, String birthPlace, String animalName, LocalDate birthday) {
            super(age, gender, species, color, weight, birthPlace, animalName);
            System.out.println("Animal created: " + animalName + " - Birthday: " + birthday);
        }


//        @Override
        public String getID() {
            return "Lion: " + animalName;
        }
    }
        class Bear extends Animal {
            public Bear(int age, String gender, String species, String color, int weight, String birthPlace, String animalName, LocalDate birthday) {
                super(age, gender, species, color, weight, birthPlace, animalName);
                System.out.println("Animal created: " + animalName + " - Birthday: " + birthday);
            }


//            @Override
            public String getID() {
                return "Bear: " + animalName;
            }
}
            class Tiger extends Animal {
                public Tiger(int age, String gender, String species, String color, int weight, String birthPlace, String animalName, LocalDate birthday) {
                    super(age, gender, species, color, weight, birthPlace, animalName);
                    System.out.println("Animal created: " + animalName + " - Birthday: " + birthday);
                }

//                @Override
                public String getID() {
                    return "Tiger: " + animalName;
                }
            }





