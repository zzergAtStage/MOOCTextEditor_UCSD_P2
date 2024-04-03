package trees;

/**
 * Realize a basic tree structure
 *
 * @author father
 */
public class BasicTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BasicTree(E data) {
        this.root = new TreeNode<>(data);
    }

    public BasicTree() {

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

    private TreeNode<E> insert(E data, TreeNode<E> node) {
        TreeNode<E> currentNode = node;
        int compareResult = data.compareTo(currentNode.getData());
        while (compareResult < 0 && currentNode.getLeftNode() != null ||
                compareResult > 0 && currentNode.getRightNode() != null) {

            if (compareResult < 0) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
            compareResult = data.compareTo(currentNode.getData());
        }
        if (compareResult < 0) {
            return currentNode.addLeftChild(data);
        } else if (compareResult > 0) {
            return currentNode.addRightNode(data);
        } else {
            return null; }

    }


    public TreeNode<E> findObject(E data) {
        TreeNode<E> curr = getRoot();
        while (curr != null) {

        }
        return null;
    }

    public TreeNode<E> getRoot() {
        return this.root;
    }
}
