import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.mani123.module8.*;

@DisplayName("Module 8")
public class Module8Test {
    @Test
    @DisplayName("Validation shapes")
    void test1() {
        Shape shape = new Quad();
        Assertions.assertEquals(Quad.class.getName().split("\\.")[3], ShapeUtils.getName(shape));
        shape = new Circle();
        Assertions.assertEquals(Circle.class.getName().split("\\.")[3], ShapeUtils.getName(shape));
        shape = new Rectangle();
        Assertions.assertEquals(Rectangle.class.getName().split("\\.")[3], ShapeUtils.getName(shape));
        shape = new Trapeze();
        Assertions.assertEquals(Trapeze.class.getName().split("\\.")[3], ShapeUtils.getName(shape));
        shape = new Square();
        Assertions.assertEquals(Square.class.getName().split("\\.")[3], ShapeUtils.getName(shape));
    }

}
