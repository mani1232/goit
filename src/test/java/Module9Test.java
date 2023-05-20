import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.mani123.module9.MyHashMap;
import ua.mani123.module9.MyStack;

@DisplayName("Module 9")
public class Module9Test {

    @Test
    @DisplayName("Test MyHashMap methods")
    void TestHashMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Test", "Test2");
        map.put("Test2", "Test4");
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals(map.get("Test"), "Test2");
        Assertions.assertEquals(map.get("Test2"), "Test4");
        map.remove("Test2");
        Assertions.assertEquals(1, map.size());
        Assertions.assertNull(map.get("Test2"));
        map.clear();
        Assertions.assertEquals(0, map.size());
        Assertions.assertNull(map.get("Test"));
    }

    @Test
    @DisplayName("Test MyHashMap methods")
    void TestStack() {
        MyStack<String> stack = new MyStack<>();
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");
        stack.push("Test4");
        stack.push("Test5");
        Assertions.assertEquals(5, stack.size());
        Assertions.assertEquals(stack.peek(), "Test5");
        stack.remove(1);
        Assertions.assertEquals(4, stack.size());
        Assertions.assertEquals(stack.pop(), "Test5");
        Assertions.assertEquals(stack.pop(), "Test3");
        Assertions.assertEquals(stack.pop(), "Test2");
        //Assertions.assertEquals(stack.pop(), "Test1");
        Assertions.assertFalse(stack.isEmpty());
        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
    }

}
