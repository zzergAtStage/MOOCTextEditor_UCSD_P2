package exercises;

import trees.BasicTree;

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
    }
}
