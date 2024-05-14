package aYouZookeepersChallenge;

import java.time.LocalDate;

public class Tiger extends Animal {
    public Tiger(String species, int age, String gender, String color, int weight, String birthPlace, LocalDate birthday) {
        super(species, age, gender, color, weight, birthPlace, birthday);
    }

    @Override
    public String getUniqueIdentifier() {
        return "Tiger: " + getSpecies() + " - " + getAge() + " years old";
    }
}
