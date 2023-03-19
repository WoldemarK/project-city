import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;


public class Utils {

    public static List<City> parse() {
        List<City> cities = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("City.csv"));

            while (scanner.hasNextLine()) {
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static City parse(String line) {

        Scanner scanner = new Scanner(line);
        String[] values = scanner.nextLine().split(";", 6);

        scanner.close();

        return new City(values[1], values[2], values[3], Integer.parseInt(values[4]), values[5]);
    }
}
