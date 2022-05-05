package workspace.previous;

import data.lab.Lab;
import data.lab.Mentor;
import data.lab.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        printDigits();
//        printNames();
//        printStudents();
//        printStudentsNamesD();
//        System.out.println(getStringWithStudentsNames());
//        System.out.println(divideMentorsByBackend());
    }

    //    1
    //создать поток чисел от 1 до 10 и вывести их на экран
    public static void printDigits(){
        IntStream.range(1,11).forEach(System.out::println);
    }

    //    2
    //Задана строка: вывести все имена длиннее 5 букв CAPSLOCK
    public static void printNames(){
        String names = "Hanna, Sergej, Maxim, Elena, Ksenia, Egor, Alexander";
        Stream.of(names.split(", ")).filter(name->name.length()>5).map(name->name.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);
    }

    //    3
    //Задана строка c фамилиями
    //Записать в строку все фамилии, которые начинаются на "A". Объединить через запятую
    public static String getSurnames(){
        String names = "Stepanov, Aleksandrov, Popov, Averin, Ivanov, Arnautov";
        String res = Stream.of(names.split(", ")).filter(name->name.startsWith("A")).collect(Collectors.joining(", "));
        return res;
    }

    //    4
    //определить количесвто четных чисел
    public static long getEvenNumbers(){
        Integer[] numbers = new Integer[]{14,22,31,4,57,6,7,8,9,10};
        long res = Stream.of(numbers).filter(number->number%2==0).count();
        return res;
    }

    //    5
    //Есть список animals с полями: name, color, type
    //Сохранить в список всех собак (dog)
    //Поля могут содержать null значения!!!
    public static List getDogs(){
        List<Animal> animals = createAnimals();

        //решение
        List<Animal> dogs = animals.stream().filter(animal -> animal.getType()!=null && animal.getType()=="dog").collect(Collectors.toList());
        return dogs;
    }

    //    6
    //какой проект имеет больше всего студентов
    public static String getProjectMaxStudents(){
        Lab lab = new Lab();

        //решение
        String res = lab.getProjects().stream()
                .max(Comparator.comparing(x -> Long.valueOf(x.getStudents().stream().count())))
                .map(project -> project.getName()).get();
        return res;
    }

    //    7
    //получить количество студентов на всех проектах
    public static long getCountAllStudents(){
        Lab lab = new Lab();

        //решение
        long count = lab.getProjects().stream().flatMap(project -> project.getStudents().stream()).count();
        return count;
    }

    //    8
    //вывести список всех студентов на экран
    public static void printStudents(){
        Lab lab = new Lab();
        lab.getProjects().stream().flatMap(project -> project.getStudents().stream()).forEach(System.out::println);
    }

    //8.1
    //вывести список всех студентов на экран, у которых имена не повторяются
    public static void printStudentsNamesD(){
        Lab lab = new Lab();
        lab.getProjects().stream().flatMap(project -> project.getStudents().stream())
                .map(student -> student.getName()).distinct().forEach(System.out::println);
    }

    //    9
    //вывести информацию о проектах: ключ - название проекта, значение - студенты этого проекта
    public static Map<String, List<Student>> getStudentsByProject(){
        Lab lab = new Lab();

        //решение
        Map<String, List<Student>> studentsMap = lab.getProjects().stream()
                .collect(Collectors.toMap(project -> project.getName(), project -> project.getStudents()));
        return studentsMap;
    }

    //    10
    //Есть список students с полями: name, dateOfJoinProject, nameOfProject
    //Сохранить в список всех студентов с проекта "edp"
    public static List<Student> getEDPStudents(){
        Lab lab = new Lab();

        //решение
        List<Student> students = lab.getProjects().stream().flatMap(project -> project.getStudents().stream())
                .filter(student -> student.getNameOfProject().equals("edp")).collect(Collectors.toList());
        return students;
    }

    //    11 call from main
    //Записать имена всех студентов в строку через запятую
    public static String getStringWithStudentsNames(){
        Lab lab = new Lab();
        String res = lab.getProjects().stream().flatMap(project -> project.getStudents().stream())
                .map(student -> student.getName()).collect(Collectors.joining(", "));
        return res;
    }

    //    12
    //вывести имена 3 студентов, которые дольше всего находится в лабе
    public static List<Student> getOldStudents(){
        Lab lab = new Lab();
        List<Student> students = lab.getProjects().stream().flatMap(project -> project.getStudents().stream())
                .sorted(Comparator.comparing(Student::getDateOfJoinProject))
                .limit(3).collect(Collectors.toList());
        return students;
    }

    //    13
    //вывести имя студента, который меньше всего находится в лабе
    public static String getNameNewStudent(){
        Lab lab = new Lab();
        String name = lab.getProjects().stream().flatMap(project -> project.getStudents().stream()).max(Comparator.comparing(Student::getDateOfJoinProject))
                .map(student -> student.getName()).get();
        return name;
    }

    //    14
    //найти список имен менторов проекта lama
    public static List<String> getLamaMentorsNames(){
        Lab lab = new Lab();

        //решение
        List<String> mentors = lab.getProjects().stream().filter(project -> project.getName().equals("lama"))
                .flatMap(project -> project.getMentors().stream())
                .map(mentor -> mentor.getName())
                .collect(Collectors.toList());
        return mentors;
    }

    //    15
    //разбить всех студентов на группы по году зачисления
    public static Map<Integer, List<Student>> separateStudentsByYear(){
        Lab lab = new Lab();

        //решение
        Map<Integer, List<Student>> studentMap = lab.getProjects().stream()
                .flatMap(project -> project.getStudents().stream())
                .collect(Collectors.groupingBy(student -> student.getDateOfJoinProject().getYear()));

        return studentMap;
    }

    //    16 - print from main
    //вывести менторов, разделив на 2 группы: относятся к backend или нет
    //Поля менторов: id, name, role (backend, frontend)
    public static Map<Boolean, List<Mentor>> divideMentorsByBackend(){
        Lab lab = new Lab();

        //решение
        Map<Boolean, List<Mentor>> mentorsMap = lab.getProjects().stream()
                .flatMap(project -> project.getMentors().stream())
                .collect(Collectors.partitioningBy(mentor -> mentor.getRole().equals("backend")));
        return mentorsMap;
    }

    private static List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Tom", "grey", "cat");
        Animal animal2 = new Animal("Jerry", "brown", "mouse");
        Animal animal3 = new Animal("Pushok", null, "cat");
        Animal animal4 = new Animal("Chappy", "black", "dog");
        Animal animal5 = new Animal("Bruno", "orange", "dog");
        Animal animal6 = new Animal("Barsik", "grey", null);
        Animal animal7 = new Animal("Kesha", "blue", "parrot");
        Animal animal8 = new Animal("Ariel", "gold", "fish");
        Animal animal9 = new Animal(null, "white", "dog");

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animals.add(animal6);
        animals.add(animal7);
        animals.add(animal8);
        animals.add(animal9);

        return animals;
    }
}
