import binary_tree.BinaryTree;
import binary_tree.Node;
import double_linked_list.DoubleLinkedList;
import junit.framework.TestCase;
import single_linked_list.ListItem;
import single_linked_list.SingleLinkedList;
import suffix_tree.SuffixTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test extends TestCase {
    private SingleLinkedList singleLinkedList;
    private DoubleLinkedList doubleLinkedListHeadInsert;
    private DoubleLinkedList doubleLinkedListTailInsert;
    private BinaryTree bTree;
    private SuffixTree sfxTree;

    @Override
    protected void setUp() throws Exception {
        // single_linked_list
        singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(new ListItem("One"));
        singleLinkedList.push(new ListItem("Two"));
        singleLinkedList.push(new ListItem("Three"));

        // double_linked_list
        doubleLinkedListHeadInsert = new DoubleLinkedList();
        doubleLinkedListHeadInsert.addToHead(new double_linked_list.ListItem("1"));
        doubleLinkedListHeadInsert.addToHead(new double_linked_list.ListItem("2"));
        doubleLinkedListHeadInsert.addToHead(new double_linked_list.ListItem("3"));

        doubleLinkedListTailInsert = new DoubleLinkedList();
        doubleLinkedListTailInsert.addToTail(new double_linked_list.ListItem("1"));
        doubleLinkedListTailInsert.addToTail(new double_linked_list.ListItem("2"));
        doubleLinkedListTailInsert.addToTail(new double_linked_list.ListItem("3"));

        /* binary_tree:
        *       C
        *     /   \
        *   A      C
        *    \      \
        *     B      D
        *           / \
        *          C   F
        * */
        bTree = new BinaryTree();
        bTree.addNode("C");
        bTree.addNode("A");
        bTree.addNode("B");
        bTree.addNode("C");
        bTree.addNode("D");
        bTree.addNode("F");
        bTree.addNode("C");
    }

    // tests single_linked_list
    public void testRemoveLast() {
        singleLinkedList.removeLast();
        List<String> expected = Arrays.asList("Three", "Two");
        List<String> actual = singleLinkedList.getAllItems();
        assertEquals(expected, actual);
    }

    // tests double_linked_list
    public void testInsertToHead() {
        List<String> expected = Arrays.asList("3", "2", "1");
        List<String> actual = doubleLinkedListHeadInsert.getAllElemForward();
        assertEquals(expected, actual);
    }

    public void testInsertToTail() {
        List<String> expected = Arrays.asList("1", "2", "3");
        List<String> actual = doubleLinkedListTailInsert.getAllElemForward();
        assertEquals(expected, actual);
    }

    public void testRemoveHeadElement() {
        doubleLinkedListTailInsert.removeHeadElement();
        List<String> expected = Arrays.asList("2", "3");
        List<String> actual = doubleLinkedListTailInsert.getAllElemForward();
        assertEquals(expected, actual);
    }

    public void testRemoveTailElement() {
        doubleLinkedListTailInsert.removeTailElement();
        List<String> expected = Arrays.asList("1", "2");
        List<String> actual = doubleLinkedListTailInsert.getAllElemForward();
        assertEquals(expected, actual);
    }

    public void testPopTailElement() {
        double_linked_list.ListItem item = doubleLinkedListTailInsert.popTailElement();
        String expected = "3";
        String actual = item.toString();
        assertEquals(expected, actual);
    }

    public void testPopHeadElement() {
        double_linked_list.ListItem item = doubleLinkedListTailInsert.popHeadElement();
        String expected = "1";
        String actual = item.toString();
        assertEquals(expected, actual);
    }

    // tests binary_tree
    public void testCompareNodes() {
        Node aNode = new Node("A");
        Node bNode = new Node("B");
        assertTrue(aNode.compareTo(bNode) < 0);
    }

    public void testFindNodes() {
        List<String> expected = Arrays.asList("C", "C", "C");
        List<String> actual = bTree.searchNodes("C")
                .stream()
                .map(Node::toString)
                .collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    // tests suffix_tree
    public void testSuffixTreeSearch() {
        sfxTree = new SuffixTree("arttppasdsda"); //positions from 0 to n
        List<Integer> expected = Arrays.asList(0, 6, 11);
        List<Integer> actual = sfxTree.search("a");
        assertEquals(expected, actual);
    }
}
