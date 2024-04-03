package trees;

/**
 * @author father
 */

public class TreeNode<E extends Comparable<E>>{
    private E data;

    private TreeNode<E> parent;

    private TreeNode<E> leftNode;
    private TreeNode<E> rightNode;
    public TreeNode(TreeNode<E> parent, E data) {
        this.data = data;
        this.parent = parent;
        this.leftNode = null;
        this.rightNode = null;
    }
    //root case
    public TreeNode( E data) {
        this.data = data;
        this.parent = null;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TreeNode<E> addLeftChild(E data) {
        this.leftNode = new TreeNode<>(this, data);
        return this.leftNode;
    }

    public TreeNode<E> addRightNode(E data) {
        this.rightNode = new TreeNode<>(data);
        return this.rightNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }



    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }
}
