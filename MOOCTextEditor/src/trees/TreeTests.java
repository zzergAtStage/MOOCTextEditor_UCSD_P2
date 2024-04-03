package trees;

/**
 * @author father
 */
public class TreeTests {
    public static void main(String[] args) {
        BasicTree<Integer> integerTree = new BasicTree<>(42);

        // Insert some values into the tree
        integerTree.insert(25);
        integerTree.insert(60);
        integerTree.insert(15);
        integerTree.insert(30);
        integerTree.insert(50);
        integerTree.insert(70);
    }
}
