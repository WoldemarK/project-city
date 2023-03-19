import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<City> cities = Utils.parse();
        print(cities);

        sortListNameCityV1(cities);
        print(cities);


        sortListDistrictAndNameCityV1(cities);
        print(cities);

        searchСityMaxPopulationV1(cities);

        quantityOfCitiesByRegion(cities);

    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    /**
     * Поиск количества городов в каждом из регионов (lambda-выражения)
     *
     * @param cities массив городов
     */
    private static void quantityOfCitiesByRegion(List<City> cities) {
        cities.stream()
                .collect(Collectors.groupingBy(
                        City::getRegion, Collectors.counting()))
                .forEach((s, count) -> System.out.println(s + " - " + count));

    }

    /**
     * Поиск города с наибольшим количеством жителей с использованием lambda-выражений
     *
     * @param cities массив городов
     */
    private static void searchСityMaxPopulationV1(List<City> cities) {
        System.out.println(cities.stream().max(Comparator.comparing(City::getPopulation)));
    }

    /**
     * Сортировка массива городов по наименованию в алфавитном порядке по убыванию
     * без учета регистра, используя lambda-выражения
     *
     * @param cities массив городов
     */
    private static void sortListNameCityV1(List<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    /**
     * Сортировка массива городов по федеральному округу и наименованию города внутри каждого федерального округа
     * в алфавитном порядке по убыванию с учетом регистра
     * используя {@link java.util.Comparator}
     *
     * @param cities массив городов
     */
    private static void sortListDistrictAndNameCityV1(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }
}
