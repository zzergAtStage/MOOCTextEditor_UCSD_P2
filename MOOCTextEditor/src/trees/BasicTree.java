package trees;

/** Realize a basic tree structure
 * @author father
 */
public class BasicTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BasicTree(E data) {
        this.root = new TreeNode<>(data);
    }
    //pre-ordered traversal
    public TreeNode<E> preOrderedTraversalSearch(E data) {
        TreeNode<E> currentNode = this.root;

        while (currentNode != null) {
            //go left
            if (currentNode.getLeftNode() != null) {
                currentNode = currentNode.getLeftNode();
            } else if (currentNode.getRightNode() != null) {
                currentNode = currentNode.getRightNode();
            } else {
                currentNode = currentNode.getParent(); //step upwards
            }
            if (currentNode.getData().equals(data)) return currentNode;

        }
        return null;
    }

    public TreeNode<E> insert(E data) {
        return insert(data, getRoot());
    }
    public TreeNode<E> insert(E data, TreeNode<E> node) {

        return null;

    }

    public TreeNode<E> findObject(TreeNode<E> node, E data) {
        boolean isFound = false;
        return null;
    }

    public TreeNode<E> getRoot() {
        return root;
    }
}
