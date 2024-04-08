package textgen;

import java.util.AbstractList;


/**
 * A class that implements a doubly linked list
 *
 * @param <E> The type of the elements stored in the list
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class MyLinkedList<E> extends AbstractList<E> {
    private final int FIRST = 0;
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        this.head = new LLNode<>();
        this.tail = new LLNode<>();
        //set pointer to each other
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size = 0;
    }

    private static <E> void checkNullElements(E element) {
        if (element == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
    }

    /**
     * Appends an element to the end of the list
     * NotNull
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        checkNullElements(element);
        LLNode<E> newNode = new LLNode<>(element);
        newNode.prev = this.tail.prev;
        newNode.prev.next = newNode;
        this.tail.prev = newNode;
        newNode.next = this.tail;
        this.size++;
        return true;

    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        checkBoundsGet(index);
        LLNode<E> currNode = getEllNode(index);
        return currNode.data;
    }

    /**
     * Add an element to the list at the specified index
     *
     * @param index   index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        checkBoundsAdd(index);
        LLNode<E> currNode;
        if (this.size == 0) {
            currNode = this.tail;
        } else {
            currNode = getEllNode(index);
        }
        LLNode<E> newNode = new LLNode<>(element);
        newNode.prev = currNode.prev;
        newNode.prev.next = newNode;
        currNode.prev = newNode;
        newNode.next = currNode;
        this.size++;
    }


    /**
     * Return the size of the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public E remove(int index) {
        if (this.size == 0 ) return null;
        if (!checkInBoundsToRemove(index)) return null;
        LLNode<E> currNode = getEllNode(index);
        LLNode<E> restNode = currNode.prev;
        restNode.next = currNode.next;
        restNode.next.prev = restNode;
        this.size--;
        return currNode.getData();
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        checkBoundsGet(index);
        checkNullElements(element);
        LLNode<E> currNode = getEllNode(index);
        E valueToReturn = currNode.getData();
        currNode.setData(element);
        return valueToReturn;
    }
//Helper methods
    private void checkBoundsAdd(int index) {
        //logic: iif we add at any position or inbounds, it will pass good
        // if we add to empty list, position will be 0, but the upper bound will 0 too
        if (index < 0 || (index > this.size - 1 && index != 0)) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + this.size() + ". Given is: " + index);
        }
    }

    private void checkBoundsGet(int index) {
        if (index < 0 || this.size == 0
                || index > this.size - 1 ) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + this.size() + ". Given is: " + index);
        }
    }
    //returns true if out of bounds
    private boolean checkInBoundsToRemove(int index) {
        if (index < 0 || this.size > 0 && index > this.size - 1) throw new IndexOutOfBoundsException("Invalid index through remove method");
        return index >= 0 && this.size != 0
                && index <= this.size - 1;
    }

    private LLNode<E> getEllNode(int index) {
        if (this.size == 0 ) return this.head;
        int curr = this.FIRST;
        LLNode<E> currNode = this.head.next;
        while (index != curr) {
            curr++;
            currNode = currNode.next;
        }
        return currNode;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int idx = 0;
        while (idx < this.size) {
            result.append(this.get(idx).toString())
                    .append(" ");
            idx++;
        }
        return result.toString();
    }
}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    // E.g. you might want to add another constructor
    public LLNode() {

    }

    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

    public void setNext(LLNode<E> child) {
        this.next = child;
    }

    public void setPrev(LLNode<E> parent) {
        this.prev = parent;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
