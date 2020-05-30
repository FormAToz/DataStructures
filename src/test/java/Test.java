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
    private DoubleLinkedList doubleLL_headInsert;
    private DoubleLinkedList doubleLL_tailInsert;
    private BinaryTree bTree;
    private SuffixTree sfxTree;
    private List expected;
    private List actual;
    private String expString;
    private String actString;

    @Override
    protected void setUp() throws Exception {
        // single_linked_list
        singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(new ListItem("One"));
        singleLinkedList.push(new ListItem("Two"));
        singleLinkedList.push(new ListItem("Three"));

        // double_linked_list
        doubleLL_headInsert = new DoubleLinkedList();
        doubleLL_headInsert.addToHead(new double_linked_list.ListItem("1"));
        doubleLL_headInsert.addToHead(new double_linked_list.ListItem("2"));
        doubleLL_headInsert.addToHead(new double_linked_list.ListItem("3"));

        doubleLL_tailInsert = new DoubleLinkedList();
        doubleLL_tailInsert.addToTail(new double_linked_list.ListItem("1"));
        doubleLL_tailInsert.addToTail(new double_linked_list.ListItem("2"));
        doubleLL_tailInsert.addToTail(new double_linked_list.ListItem("3"));

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
        expected = Arrays.asList("Three", "Two");
        actual = singleLinkedList.getAllItems();
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }

    // tests double_linked_list
    public void testInsertToHead() {
        expected = Arrays.asList("3", "2", "1");
        actual = doubleLL_headInsert.getAllElemForward();
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }

    public void testInsertToTail() {
        expected = Arrays.asList("1", "2", "3");
        actual = doubleLL_tailInsert.getAllElemForward();
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }

    public void testRemoveHeadElement() {
        doubleLL_tailInsert.removeHeadElement();
        expected = Arrays.asList("2", "3");
        actual = doubleLL_tailInsert.getAllElemForward();
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }

    public void testRemoveTailElement() {
        doubleLL_tailInsert.removeTailElement();
        expected = Arrays.asList("1", "2");
        actual = doubleLL_tailInsert.getAllElemForward();
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }

    public void testPopTailElement() {
        double_linked_list.ListItem item = doubleLL_tailInsert.popTailElement();
        expString = "3";
        actString = item.toString();
        assertEquals(expString, actString);
    }

    public void testPopHeadElement() {
        double_linked_list.ListItem item = doubleLL_tailInsert.popHeadElement();
        expString = "1";
        actString = item.toString();
        assertEquals(expString, actString);
    }

    // tests binary_tree
    public void testCompareNodes() {
        Node aNode = new Node("A");
        Node bNode = new Node("B");
        assertTrue(aNode.compareTo(bNode) < 0);
    }

    public void testFindNodes() {
        expected = Arrays.asList("C", "C", "C");
        actual = bTree.searchNodes("C")
                .stream()
                .map(el -> el.toString())
                .collect(Collectors.toList());
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }

    // tests suffix_tree
    public void testSuffixTreeSearch() {
        sfxTree = new SuffixTree("arttppasdsda"); //positions from 0 to n
        expected = Arrays.asList(0, 6, 11);
        actual = sfxTree.search("a");
        assertTrue("Verify failed! Expected: " + expected.toString() + "\n Actual: " + actual.toString(),
                expected.equals(actual));
    }
}
