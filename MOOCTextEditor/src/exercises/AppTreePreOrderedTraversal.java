package exercises;

import java.util.stream.IntStream;

public class AppTreePreOrderedTraversal {

    public static void main(String[] args) {
        //init tree
//        IntStream.rangeClosed(65, 91)
//                .mapToObj(i -> (char) i)
//                .forEach(System.out::println);
        BasicTree<Character> bTree = new BasicTree<>();
        "ABCDEFG".chars()
                .mapToObj(c -> (char) c)
                .forEach(bTree::insert);
        bTree.preOrder();
        System.out.println();
        bTree.levelOrdered();

    }
}
