package ua.mani123;

import ua.mani123.module10.FileUtils;
import ua.mani123.module8.*;

public class Main {
    public static void main(String[] args) {
        module10();
        //module8();
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

}