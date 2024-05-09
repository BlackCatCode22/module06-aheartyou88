package aYouZookeepersChallenge;

import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ZookeepersChallenge {
    public static LocalDate genBirthday(int age, String birthSeason) {
        int currentYear = LocalDate.now().getYear(); // Current year
        int birthYear = currentYear - age; // Calculate the birth year
        int birthMonth = switch (birthSeason != null ? birthSeason.toLowerCase() : "") {
            case "spring" -> 3; // March
            case "summer" -> 6; // June
            case "fall" -> 9; // September
            case "winter" -> 12; // December
            default -> 1; // Default to January if unknown
        };

        return LocalDate.of(birthYear, birthMonth, 1); // Return derived birthday
    }

    public static void main(String[] args) {

        System.out.println("\n\n Welcome to My aYouZoo Program\n\n");

        // local variables
        String animalName;
        int age;
        String gender;
        String species;
        String color;
        int weight;
        String birthPlace;

// ArrayList of Animal objects

        ArrayList<String> animalData = new ArrayList<>();
        animalData.add("4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia");
        animalData.add("12 year old male hyena, born in fall, brown color, 150 pounds, from Friguia Park, Tunisia");

        ArrayList<Animal> animals = new ArrayList<>();

        // Open an external file, parse it line by line, and fill the name arrayLists
        String filePath = "C:\\Users\\Amanda Panda\\Desktop\\FCC\\CIT 63\\aYouZookeepersChallenge\\src\\aYouZookeepersChallenge\\arrivingAnimals.txt";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                System.out.println("\n A new animal is created: " + line);


                // Age is in the first element of the array named parts
                String[] parts = line.split(", ");


                // Check if the line has at least 1 part
                if (parts.length >= 7) {
                    age = Integer.parseInt(parts[0].split(" ")[0]); // Get age
                    gender = parts[1].split(" ")[1]; // Extract gender
                    species = parts[2].split(" ")[3]; // Extract species
                    color = parts[3]; // Color
                    weight = Integer.parseInt(parts[3].split(" ")[0]); // Ensure this is a valid number
                    birthPlace = parts[4].substring(6); // Extract birthplace
                    animalName = parts[5].substring(6); // Animal name

                    // Extract birth season from parts
                    String birthSeason = null;
                    for (String part : parts) {
                        if (part.toLowerCase().contains("born in")) {
                            birthSeason = part.substring(9); // Get the birth season text
                            break;
                        }
                    }

                    // Generate the birthday based on age and birth season
                    LocalDate birthday = genBirthday(age, birthSeason);

                    // Create the animal object based on species
                    Animal myAnimal = switch (species.toLowerCase()) {
                        case "hyena" ->
                                new Hyena(age, gender, species, color, weight, birthPlace, animalName, birthday);
                        case "lion" -> new Lion(age, gender, species, color, weight, birthPlace, animalName, birthday);
                        case "tiger" ->
                                new Tiger(age, gender, species, color, weight, birthPlace, animalName, birthday);
                        case "bear" -> new Bear(age, gender, species, color, weight, birthPlace, animalName, birthday);
                        default -> null;
                    };
                    if (myAnimal != null) { // Check if a valid animal was created
                        animals.add(myAnimal); // Add to the list of animals
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();

        }
        // Display the animals with their birthdays
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.getID() + " - Birthday: " + animal.getBirthday());
        }
    }
}
