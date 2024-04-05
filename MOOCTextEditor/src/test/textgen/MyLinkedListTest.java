package textgen;

import junit.framework.TestCase;
import org.junit.Before;



public class MyLinkedListTest extends TestCase {

    private MyLinkedList<String> shortList;
    private MyLinkedList<Integer> emptyList;
    private MyLinkedList<Integer> longerList;
    private static final int LONG_LIST_LENGTH =10;
    private MyLinkedList<Integer> list1;

    @Before
    public void setUp() throws Exception {
        // Feel free to use these lists, or add your own
        shortList = new MyLinkedList<String>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyLinkedList<Integer>();
        longerList = new MyLinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++)
        {
            longerList.add(i);
        }
        list1 = new MyLinkedList<Integer>();
        list1.add(65);
        list1.add(21);
        list1.add(42);

    }

    public void testGet() {
    }
}