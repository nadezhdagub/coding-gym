package workspace;

import data.formula.Championship;
import data.formula.Driver;
import data.formula.Team;
import data.formula.Track;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyChampionship {

    public static void main(String[] args) {
        var championship = ObjectGenerator.generateChampionship();

        System.out.println(getConstructorChampionshipResults(championship));
    }

    private static void printNames(String names) {
        // приходит строка имен, разделенных запятой
        // пропустить первое имя, остальные вывести в консоль
        Stream.of(names.split(", "))
                .skip(1)
                .forEach(System.out::println);
    }

    private static void generateRandomNumbers() {
        // создать поток бесконечно генерируемых случайных чисел
        // ограничить его 10 элементами
        // вывести их в консоль
        final var randomSeed = new Random();
        IntStream.generate(() -> randomSeed.nextInt(1000))
                .limit(10)
                .forEach(System.out::println);
    }

    private static void printNumbers() {
        // создать поток чисел от 0 до 20
        // вывести их в консоль
        // найти среднее арифметическое
        IntStream.rangeClosed(0, 20)
                .peek(System.out::println)
                .average()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Computations went wrong :("));
    }

    private static void printUniqueOddNumbers(int[] numbers) {
        // вывести нечетные числа в консоль
        // отсортировав их по возрастанию
        Arrays.stream(numbers)
                .filter(num -> num % 2 != 0)
                .sorted()
                .forEach(System.out::println);
    }

    private static void printUniquePalindroms(String[] arr1, String[] arr2) {
        // найти палиндромы в двух массивах, вывести их в консоль
        // повторяющиеся значения не выводить
        // палиндром - слово, которое одинаково читается в обоих направлениях
        Stream.of(arr1, arr2)
                .flatMap(Arrays::stream)
                .distinct()
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .forEach(System.out::println);
//        Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
//                .distinct()
//                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
//                .forEach(System.out::println);
    }

    private static String getDriversChampionshipResults(Championship championship) {
        // вернуть результаты личного зачета (список гонщиков, отсортированный по очкам)
        // вывести в строку вида: "имя гонщика : кол-во очков"
        return championship.getTeams().stream()
                .flatMap(team -> team.getDrivers().stream())
                .sorted(Comparator.comparing(Driver::getPoints).reversed())
                .map(driver -> driver.getName() + " : " + driver.getPoints())
                .collect(Collectors.joining("\n"));
    }

    private static List<Team> getConstructorChampionshipResults(Championship championship) {
        // отсортировать команды по количеству набранных очков
        return championship.getTeams().stream()
                .sorted(Comparator.comparing(team -> team.getDrivers().stream()
                        .mapToInt(Driver::getPoints)
                        .sum()))
                .collect(Collectors.toList());
    }

    private static String findAnyDriverFromCountry(String country) {
        // найти хотя бы одного гонщика из заданной страны, в противном случае кинуть исключение
        return null;
    }

    private static long getMaxSalaryDriver(Championship championship) {
        // вернуть самую большую зарплату гонщика
        return championship.getTeams().stream()
                .flatMap(team -> team.getDrivers().stream())
                .mapToLong(Driver::getSalary)
                .max()
                .orElse(0);
    }

    private static Map<String, Long> filterDriversWithSmallSalary(Championship championship) {
        // оставить только гонщиков с зарплатой ниже 2м
        // собрать в мапу имя-зарплата
        // * вариант с treeMap
        return championship.getTeams().stream()
                .flatMap(team -> team.getDrivers().stream())
                .filter(driver -> driver.getSalary() < 2_000_000)
                .collect(Collectors.toMap(Driver::getName, Driver::getSalary));
//                .collect(Collectors.toMap(Driver::getName, Driver::getSalary, Long::sum, TreeMap::new));
    }

    private static Team findAnyTeamWithEqualSalaries(Championship championship) {
        // найти любую команду в которой гонщики получают одинаковую зарплату
        return null;
    }

 /*   private static String findMostWinsDriver(Championship championship) {
        // найти гонщика с наибольшим числом побед
        // вывести строку "[имя_гонщика] won [количество побед] times"
        // в случае неудачи бросить исключение
        return championship.getTracks()
                .stream()
                .collect(Collectors.groupingBy(Track::getWinner))
                .entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().size()))
                .map(entry -> entry.getKey().getName() + " won " + entry.getValue().size() + " times")
                .orElseThrow(() -> new RuntimeException("Sorry you not a winner"));
    }*/

   /* private static Map<Boolean, List<Driver>> findWinnerAndLosers(Championship championship) {
        // разделить гонщиков на тех кто побеждал хотя бы один раз и остальных
        var winners = championship.getTracks().stream()
                .map(Track::getWinner)
                .distinct()
                .toList();
        return championship.getTeams().stream()
                .flatMap(team -> team.getDrivers().stream())
                .collect(Collectors.partitioningBy(winners::contains));
    }*/

    private static String getFibonacciSequence() {
        // вернуть последовательность чисел фибоначчи через запятую, ограничиться 10 числами
        // оригинал задачи https://mkyong.com/java/java-fibonacci-examples/
        return Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .collect(Collectors.joining(", "));
    }
}
