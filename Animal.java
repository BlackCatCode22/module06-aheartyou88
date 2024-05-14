package aYouZookeepersChallenge;

import java.util.UUID;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public abstract class Animal {
    private final String id;
    private final String species;
    // Other fields and methods omitted for brevity

    private static int nextId = 1;

    private static String generateUniqueId(String species) {
        String prefix = species.substring(0, 1).toUpperCase() + species.substring(1, 3).toLowerCase();
        return prefix + "-" + nextId++;
    }

    public String getId() {
        return id;
    }
    private static final Map<String, Month> SEASON_TO_MONTH = new HashMap<>();
    private static final Map<String, Integer> SPECIES_COUNT = new HashMap<>();

    static {
        SEASON_TO_MONTH.put("spring", Month.MARCH);
        SEASON_TO_MONTH.put("summer", Month.JUNE);
        SEASON_TO_MONTH.put("fall", Month.SEPTEMBER);
        SEASON_TO_MONTH.put("autumn", Month.SEPTEMBER);
        SEASON_TO_MONTH.put("winter", Month.DECEMBER);
    }


    private final int age;
    private final String gender;
    private final String color;
    private final int weight;
    private final String birthPlace;
    private final LocalDate birthday;

    public static int numOfAnimals = 0;

    public Animal(String species, int age, String gender, String color, int weight, String birthPlace, LocalDate birthday) {
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.weight = weight;
        this.birthPlace = birthPlace;
        this.birthday = birthday;
        this.id = generateUniqueId(species);

        // Increment species count
        SPECIES_COUNT.put(species, SPECIES_COUNT.getOrDefault(species, 0) + 1);

        numOfAnimals++;
    }

    public static int getNumOfAnimals() {
        return numOfAnimals;
    }

    public static Map<String, Integer> getSpeciesCount() {
        return new HashMap<>(SPECIES_COUNT);
    }

    public static LocalDate genBirthday(int age, String birthSeason) {
        int currentYear = LocalDate.now().getYear();
        int birthYear = currentYear - age;
        Month birthMonth = SEASON_TO_MONTH.getOrDefault(birthSeason.toLowerCase(), Month.JANUARY);
        return LocalDate.of(birthYear, birthMonth, 1);
    }

    // Generate unique ID for each animal
    public String getUniqueIdentifier() {
        int speciesCount = SPECIES_COUNT.getOrDefault(species, 0);
        return species + "_" + speciesCount;
    }

//    public abstract String getUniqueIdentifier();

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

    public String getBirthday() {
        return birthday.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

