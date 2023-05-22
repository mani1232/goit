package ua.mani123.module8;

public class ShapeUtils {

    private final Shape shape;

    public ShapeUtils(Shape shape) {
        this.shape = shape;
    }

    public void print() {
        System.out.printf("I'am a %s", shape.getName());
    }

}
