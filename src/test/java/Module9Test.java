import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.mani123.module9.MyHashMap;

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

}
