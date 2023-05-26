import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.mani123.module9.*;

@DisplayName("Module 9")
public class Module9Test {

    private MyLinkedList<Integer> myLinkedList;
    private MyStack<Integer> myStack;
    private MyHashMap<Integer, Integer> myHashMap;
    private MyQueue<Integer> myQueue;
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void setup() {
        myLinkedList = new MyLinkedList<>();
        myQueue = new MyQueue<>();
        myStack = new MyStack<>();
        myHashMap = new MyHashMap<>();
        myArrayList = new MyArrayList<>();
    }

    @Test
    @DisplayName("Add test")
    public void testAdd() {
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);

        Assertions.assertEquals(3, myArrayList.size());

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);

        Assertions.assertEquals(3, myLinkedList.size());

        myHashMap.put(10, 20);
        myHashMap.put(20, 30);
        myHashMap.put(30, 40);

        Assertions.assertEquals(3, myHashMap.size());

        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);

        Assertions.assertEquals(3, myQueue.size());

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        Assertions.assertEquals(3, myStack.size());
    }

    @Test
    @DisplayName("Remove test")
    public void testRemove() {
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);

        myArrayList.remove(0);

        Assertions.assertEquals(2, myArrayList.size());
        Assertions.assertEquals(30, myArrayList.get(1));

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);

        myLinkedList.remove(0);

        Assertions.assertEquals(2, myLinkedList.size());
        Assertions.assertEquals(30, myLinkedList.get(1));

        myHashMap.put(10, 20);
        myHashMap.put(20, 30);
        myHashMap.put(30, 40);

        myHashMap.remove(0);

        Assertions.assertEquals(2, myHashMap.size());
        Assertions.assertEquals(40, myHashMap.get(1));

        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);

        myQueue.peek();

        Assertions.assertEquals(2, myQueue.size());
        Assertions.assertEquals(20, myQueue.poll());

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        myStack.remove(0);

        Assertions.assertEquals(3, myStack.size());
        Assertions.assertEquals(30, myStack.pop());
    }

    @Test
    @DisplayName("Clear test")
    public void testClear() {
        // TODO
    }

    @Test
    @DisplayName("Get test")
    public void testGet() {
        // TODO
    }

}
