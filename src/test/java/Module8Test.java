import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.mani123.module8.*;

@DisplayName("Module 8")
public class Module8Test {
    @Test
    @DisplayName("Validation shapes")
    void test1() {
        ShapeUtils shapeUtils = new ShapeUtils();
        Shape shape = new Quad();
        Assertions.assertEquals(Quad.class.getSimpleName(), shapeUtils.getName(shape));
        shape = new Circle();
        Assertions.assertEquals(Circle.class.getSimpleName(), shapeUtils.getName(shape));
        shape = new Rectangle();
        Assertions.assertEquals(Rectangle.class.getSimpleName(), shapeUtils.getName(shape));
        shape = new Trapeze();
        Assertions.assertEquals(Trapeze.class.getSimpleName(), shapeUtils.getName(shape));
        shape = new Square();
        Assertions.assertEquals(Square.class.getSimpleName(), shapeUtils.getName(shape));
    }

}
