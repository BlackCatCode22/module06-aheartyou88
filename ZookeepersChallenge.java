package aYouZookeepersChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZookeepersChallenge {
    private static List<String> animalNames = new ArrayList<>();
    private static int nameIndex = 0; // Index variable to track the next available name

    static {
        try {
            File namesFile = new File("C:\\Users\\Amanda Panda\\Desktop\\FCC\\CIT 63\\aYouZookeepersChallenge\\src\\aYouZookeepersChallenge\\animalNames.txt");
            Scanner scanner = new Scanner(namesFile);
            while (scanner.hasNextLine()) {
                animalNames.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to generate a unique animal name
    private static String generateUniqueName() {
        if (nameIndex >= animalNames.size()) {
            // Reset the index if it exceeds the size of the animal names list
            nameIndex = 0;
        }
        String name = animalNames.get(nameIndex);
        nameIndex++; // Increment index for next time
        return name;

    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Amanda Panda\\Desktop\\FCC\\CIT 63\\aYouZookeepersChallenge\\src\\aYouZookeepersChallenge\\arrivingAnimals.txt";
        File file = new File(filePath);

        List<Animal> animals = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("\nA new animal is created: " + line);

                String[] parts = line.split(", ");

                if (parts.length >= 6) {
                    String[] ageGenderSpeciesParts = parts[0].split(" ");
                    int age = Integer.parseInt(ageGenderSpeciesParts[0]);
                    String gender = ageGenderSpeciesParts[2];
                    String species = ageGenderSpeciesParts[4];
                    String birthSeason = parts[1].contains("unknown") ? "unknown" : parts[1].split(" ")[2];
                    String color = parts[2];
                    int weight = Integer.parseInt(parts[3].split(" ")[0]);
                    String birthPlace = parts[4].substring(5);
                    LocalDate birthday = Animal.genBirthday(age, birthSeason);

                    Animal myAnimal = switch (species.toLowerCase()) {
                        case "hyena" -> new Hyena(species, age, gender, color, weight, birthPlace, birthday);
                        case "lion" -> new Lion(species, age, gender, color, weight, birthPlace, birthday);
                        case "tiger" -> new Tiger(species, age, gender, color, weight, birthPlace, birthday);
                        case "bear" -> new Bear(species, age, gender, color, weight, birthPlace, birthday);
                        default -> null;
                    };

                    if (myAnimal != null) {
                        animals.add(myAnimal);
                        System.out.println("Animal created: " + myAnimal.getId() + " - " + myAnimal.getAge() + " years old - Born on : " + myAnimal.getBirthday());

                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
            e.printStackTrace();
        }


        System.out.println("\nTotal Number of Animals: " + Animal.getNumOfAnimals());
        System.out.println("Species Count: " + Animal.getSpeciesCount());

        // Query and display the animals collection
        displayAllAnimals(animals);
//        displayAnimalsBySpecies(animals, "Hyena");
//        displayAnimalsBySpecies(animals, "lion");
//        displayAnimalsBySpecies(animals, "tiger");
//        displayAnimalsBySpecies(animals, "bear");
    }

    private static void displayAllAnimals(List<Animal> animals) {
        System.out.println("\nAll Animals:");
        for (Animal animal : animals) {
            System.out.println(animal.getId()  + " - " + animal.getAge() + " years old - Birthday: " + animal.getBirthday() + "- from " + animal.getBirthPlace());
        }
    }

    private static void displayAnimalsBySpecies(List<Animal> animals, String species) {
        System.out.println("\nAnimals of species " + species + ":");
        for (Animal animal : animals) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                System.out.println(animal.getUniqueIdentifier() + " - " + animal.getSpecies() + " - " + animal.getGender() + " - " +
                        animal.getAge() + " years old - Birthday: " + animal.getBirthday());
            }
        }
    }
}
