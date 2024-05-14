package aYouZookeepersChallenge;

import java.time.LocalDate;

public class Lion extends Animal {
    public Lion(String species, int age, String gender, String color, int weight, String birthPlace, LocalDate birthday) {
        super(species, age, gender, color, weight, birthPlace, birthday);
    }

    @Override
    public String getUniqueIdentifier() {
        return "Lion: " + getSpecies() + " - " + getAge() + " years old";
    }
}
