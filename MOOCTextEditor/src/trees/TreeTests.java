package trees;

/**
 * @author father
 */
public class TreeTests {
    public static void main(String[] args) {

        BasicTree<Character> bTree = new BasicTree<>('K');
        "BCZADEFYG".chars()
                .mapToObj(c -> (char) c)
                .forEach(bTree::insert);
    }
}
