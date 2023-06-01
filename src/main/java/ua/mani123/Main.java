package ua.mani123;

import ua.mani123.module10.FileUtils;
import ua.mani123.module11.Utils;
import ua.mani123.module8.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //module10();
        //module8();
        module11();
    }

    public static void module8() {
        new ShapeUtils(new Trapeze()).print();
        new ShapeUtils(new Quad()).print();
        new ShapeUtils(new Rectangle()).print();
        new ShapeUtils(new Circle()).print();
        new ShapeUtils(new Square()).print();
    }

    public static void module10() {
        new FileUtils("file.txt").loadNumbers(true);
        new FileUtils("file.txt").loadUsers(true, "users.json");
        FileUtils fileUtils = new FileUtils("words.txt").countWords(true);
        fileUtils.sort(true);
    }

    public static void module11() {
        List<Object> list = Utils.oddList(List.of("AName0", "AName1", "VName2", "YName3", "GName4", "HName5", "TName6", "BName7"), false);//.forEach(System.out::println);
        list.stream().filter(s -> s instanceof String).toList().stream().map(s -> s.toString().toUpperCase()).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println(Stream.of("1, 2, 0", "3, 4, 5").flatMap(s -> Arrays.stream(s.split(", ")))
                .map(String::trim)
                .sorted()
                .collect(Collectors.joining(", ")));
        Utils.generateRandomStream(25214903917L, 11L, (long) Math.pow(2, 48)).limit(10).forEach(System.out::println);
        Utils.zip(Stream.of(1, 2, 3, 4, 5), Stream.of(6, 7, 8)).forEach(System.out::println);
    }

}