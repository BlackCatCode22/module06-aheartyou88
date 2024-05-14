package aYouZookeepersChallenge;

import java.time.LocalDate;

public class Hyena extends Animal {
    public Hyena(String species, int age, String gender, String color, int weight, String birthPlace, LocalDate birthday) {
        super(species, age, gender, color, weight, birthPlace, birthday);
    }

    @Override
    public String getUniqueIdentifier() {
        return "Hyena: " + getSpecies() + " - " + getAge() + " years old";
    }
}
