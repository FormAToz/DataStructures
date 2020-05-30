package binary_tree;

public class Node {
    private String data;

    private Node parent;
    private Node left;
    private Node right;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String toString() {
        return data;
    }

    public int compareTo(Node node) {
        return this.toString().compareTo(node.toString());
    }
}