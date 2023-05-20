package ua.mani123.module8;

public abstract class Shape {
    String getName() {
        return this.getClass().getName().split("\\.")[3];
    }
}
