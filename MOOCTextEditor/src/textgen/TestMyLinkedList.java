/**
 *
 */
package textgen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author UC San Diego MOOC team
 *
 */
public class TestMyLinkedList {

    private static final int LONG_LIST_LENGTH = 10;

    MyLinkedList<String> shortList;
    MyLinkedList<Integer> emptyList;
    MyLinkedList<Integer> longerList;
    MyLinkedList<Integer> list1;

    /** Tuning variables before tests
     */
    @Before
    public void setUp()  {
        // Feel free to use these lists, or add your own
        shortList = new MyLinkedList<>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyLinkedList<>();
        longerList = new MyLinkedList<>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        list1 = new MyLinkedList<>();
        list1.add(65);
        list1.add(21);
        list1.add(42);

    }


    /** Test if the get method is working correctly.
     */
    /*You should not need to add much to this method.
     * We provide it as an example of a thorough test. */
    @Test
    public void testGet() {
        //test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }

        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            shortList.get(2);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        // test longer list contents
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
        }

        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }

    }


    /** Test removing an element from the list.
     * We've included the example from the concept challenge.
     * You will want to add more tests.  */
    @Test
    public void testRemove() {
        try {
            list1.remove(-1);
            fail("Remove: too low index not to throw");
        } catch (IndexOutOfBoundsException e) {

        }



        int a = list1.remove(0);
        assertEquals("Remove: check a is correct ", 65, a);
        assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
        assertEquals("Remove: check size is correct ", 2, list1.size());

        // Test removing the last element
        int removedValue = list1.remove(list1.size() - 1);
        assertEquals("Remove: check removed value", 42, removedValue);
        assertEquals("Remove: check size is correct", 1, list1.size());

        // Test removing from an empty list
        MyLinkedList<Integer> emptyList = new MyLinkedList<>();
        assertNull("Remove: check removing from empty list returns null", emptyList.remove(0));

        // Test removing from an invalid index
        try{
            list1.remove(list1.size());
            fail("Remove: check removing from invalid index returns null");
        } catch (IndexOutOfBoundsException e){

        }

    }

    /** Test adding an element into the end of the list, specifically
     *  public boolean add(E element)
     * */
    @Test
    public void testAddEnd() {
        //add a single element to an empty list
        Integer[] checkedValues = {2, 33, 46};
        emptyList.add(checkedValues[0]);
        assertEquals("Expected size of an empty list after insertion", 1, emptyList.size());
        assertEquals("Added element is the only in the list", checkedValues[0], (emptyList.get(emptyList.size() - 1)));

        //add a multiple elements to a nonempty list
        emptyList.add(checkedValues[1]);
        emptyList.add(checkedValues[2]);
        assertEquals("Check multiple insertiona at the end of the list", 3, emptyList.size());
        for (int i = 0; i < checkedValues.length; i++) {
            assertEquals("Checked elements are ordered as expected", checkedValues[i], emptyList.get(i));
        }
    }


    /** Test the size of the list */
    @Test
    public void testSize() {
        assertEquals("Size: check size of empty list", 0, emptyList.size());
        //test initially nonempty list
        assertEquals("Size: check size nonempty initialized list", 3, list1.size());
        list1.add(new Integer(88));
        assertEquals("Size: check zise after adding elements", 4, list1.size());
        list1.remove(0);
        assertEquals("Size: check size after removing elements", 3, list1.size());
        //test size after adding end removing elements
        shortList.add("3");
        shortList.add("33");
        shortList.remove(shortList.size() - 1);
        assertEquals("Size: check size after adding and removing elements", 3, shortList.size());

    }


    /** Test adding an element into the list at a specified index,
     * specifically:
     * public void add(int index, E element)
     * */
    @Test
    public void testAddAtIndex() {
        // Test adding elements to an empty list
        emptyList.add(0, 10);
        assertEquals("AddAtIndex: check added element at index 0", (Integer) 10, emptyList.get(0));
        assertEquals("AddAtIndex: check size after adding element", 1, emptyList.size());
        // Test adding elements at the beginning of a non-empty list
        emptyList.add(0, 5);
        System.out.println("AddAtIndex: " + emptyList);
        assertEquals("AddAtIndex: check added element at index 0", (Integer) 5, emptyList.get(0));
        assertEquals("AddAtIndex: check element at index 1 after adding", (Integer) 10, emptyList.get(1));
        assertEquals("AddAtIndex: check size after adding element", 2, emptyList.size());
        // Test adding elements in the middle of a list
        emptyList.add(1, 7);
        assertEquals("AddAtIndex: check added element at index 1", (Integer) 7, emptyList.get(1));
        assertEquals("AddAtIndex: check element at index 2 after adding", (Integer) 10, emptyList.get(2));
        assertEquals("AddAtIndex: check size after adding element", 3, emptyList.size());
        // Test adding elements at the end of a list
        emptyList.add(emptyList.size() - 1, 15);
        assertEquals("AddAtIndex: check added element at the end", (Integer) 10, emptyList.get(emptyList.size() - 1));
        assertEquals("AddAtIndex: check size after adding element", 4, emptyList.size());
        try {
            emptyList.add(10, 20);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        assertEquals("AddAtIndex: check size after adding element at invalid index", 4, emptyList.size());

    }

    /** Test setting an element in the list */
    @Test
    public void testSet() {

        // Test setting elements at various indexes

        // Test setting an element in an empty list (should throw IndexOutOfBoundsException)
        MyLinkedList<Integer> emptyList = new MyLinkedList<>();
        try {
            emptyList.set(0, 10);
        } catch (IndexOutOfBoundsException e) {
            // Exception expected, do nothing
        }

        // Test setting an element in a non-empty list
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(5);
        list1.add(10);
        list1.add(15);

        // Test setting an element at the beginning of the list
        list1.set(0, 1);
        assertEquals("Set: check element at index 0", (Integer) 1, list1.get(0));
        assertEquals("Set: check size after setting element", 3, list1.size());

        // Test setting an element in the middle of the list
        list1.set(1, 20);
        assertEquals("Set: check element at index 1", (Integer) 20, list1.get(1));
        assertEquals("Set: check size after setting element", 3, list1.size());

        // Test setting an element at the end of the list
        list1.set(list1.size() - 1, 30);
        assertEquals("Set: check element at the end", (Integer) 30, list1.get(list1.size() - 1));
        assertEquals("Set: check size after setting element", 3, list1.size());

        // Test setting an element at an invalid index
        try {
            list1.set(10, 40);
        } catch (IndexOutOfBoundsException e) {
            // Exception expected, do nothing
        }
        assertEquals("Set: check size after setting element at invalid index", 3, list1.size());

    }

}
