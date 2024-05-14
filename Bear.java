package aYouZookeepersChallenge;

import java.time.LocalDate;

public class Bear extends Animal {
    public Bear(String species, int age, String gender, String color, int weight, String birthPlace, LocalDate birthday) {
        super(species, age, gender, color, weight, birthPlace, birthday);
    }

    @Override
    public String getUniqueIdentifier() {
        return "Bear: " + getSpecies() + " - " + getAge() + " years old";
    }
}
