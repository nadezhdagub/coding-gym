package workspace;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import data.formula.Championship;
import data.formula.Driver;

public class Lesson {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 11, 28, 35, 90, 111, 54, 3, 17, 42, 53, 100};
        var names = "Ann, John, Billy, Viktor, Shrek, Bob";
        var str1 = new String[]{"lake", "bob", "cat", "madam", "level"};
        var str2 = new String[]{"game", "bob", "cate", "kayak"};
        var championship = ObjectGenerator.generateChampionship();

        //System.out.println(getFibonacciSequence());
    }

    public static void printNames(String names) {
        //a comma-separated string of names arrives
        //skip the first name, output the rest to the console

        Arrays.stream(names.split(","))
                .skip(1)
                .forEach(System.out::print);
    }

    public static void generateRandomNumbers() {
        //create a stream of infinitely generated random numbers
        //limit it to 10 elements
        //output them to the console

        final var randomSeed = new Random();
        IntStream.generate(() -> randomSeed.nextInt(1000))
                .limit(10)
                .forEach(System.out::println);
    }

    public static void printNumbers() {
        //create a stream of numbers from 0 to 20
        //output them to the console
        //find the arithmetic mean

        IntStream.rangeClosed(0, 20)
                .peek(System.out::println)
                .average()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Something wrong"));
    }

    public static void printUniqueOddNumber(int[] numbers) {
        //output odd numbers to the console
        //sort them in ascending order

        Arrays.stream(numbers)
                .filter(num -> num % 2 != 0)
                .sorted()
                .forEach(System.out::println);
    }

    public static void printUniquePalindroms(String[] arr1, String[] arr2) {
        //find a palindrome in two arrays, output them to the console
        //do not output duplicate values
        //a palindrome is a word that reads equally in both directions

        Stream.of(arr1, arr2)
                .flatMap(Arrays::stream)
                .distinct()
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .forEach(System.out::println);
    }

    public static String getDriversChampiomshipResult(Championship championship) {
        //return the results of the personal standings (list of riders sorted by points)
        //output in a line of the form: name of the rider: number of points

        return championship.getTeams()
                .stream()
                .flatMap(team -> team.getDrivers().stream())
                .sorted(Comparator.comparing(Driver::getPoints).reversed())
                .map(driver -> driver.getName() + " : " + driver.getPoints())
                .collect(Collectors.joining("\n"));
    }



}
