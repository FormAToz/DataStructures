package suffix_tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String fragment;
    private List<Node> nextNodes;
    private int position;

    public Node(String fragment, int position) {
        this.fragment = fragment;
        nextNodes = new ArrayList<>();
        this.position = position;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getFragment() {
        return fragment;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public List<Node> getNextNodes() {
        return nextNodes;
    }
}