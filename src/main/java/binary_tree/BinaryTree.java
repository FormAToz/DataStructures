package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;
    private List<Node> list = new ArrayList<>();

    public void addNode(String data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (newNode.compareTo(current) < 0) {  // move left
                    current = current.getLeft();
                    if (current == null) {               // insert left if end of chain
                        parent.setLeft(newNode);
                        return;
                    }
                }else {                                // move right
                    current = current.getRight();
                    if (current == null) {             // insert right if end of chain
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public List<Node> searchNodes(String data) {
        inOrder(new Node(data), root);
        return list;
    }

    private Boolean isEmpty() { // returns true, if tree is empty
        return root == null;
    }

    // search recursive through the tree
    private void inOrder(Node searchNode, Node rootNode) {
        if (rootNode != null) {
            if (searchNode.toString().equals(rootNode.toString())) {
                list.add(rootNode);
            }
            inOrder(searchNode, rootNode.getLeft());
            inOrder(searchNode, rootNode.getRight());
        }
    }
}