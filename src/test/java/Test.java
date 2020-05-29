import double_linked_list.DoubleLinkedList;
import junit.framework.TestCase;
import single_linked_list.ListItem;
import single_linked_list.SingleLinkedList;

import java.util.Arrays;
import java.util.List;

public class Test extends TestCase {
    private SingleLinkedList singleLinkedList;
    private DoubleLinkedList doubleLL_headInsert;
    private DoubleLinkedList doubleLL_tailInsert;

    @Override
    protected void setUp() throws Exception {
        singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(new ListItem("One"));
        singleLinkedList.push(new ListItem("Two"));
        singleLinkedList.push(new ListItem("Three"));

        doubleLL_headInsert = new DoubleLinkedList();
        doubleLL_headInsert.addToHead(new double_linked_list.ListItem("1"));
        doubleLL_headInsert.addToHead(new double_linked_list.ListItem("2"));
        doubleLL_headInsert.addToHead(new double_linked_list.ListItem("3"));

        doubleLL_tailInsert = new DoubleLinkedList();
        doubleLL_tailInsert.addToTail(new double_linked_list.ListItem("1"));
        doubleLL_tailInsert.addToTail(new double_linked_list.ListItem("2"));
        doubleLL_tailInsert.addToTail(new double_linked_list.ListItem("3"));
    }

    // tests single_linked_list
    public void testRemoveLast() {
        singleLinkedList.removeLast();
        List<String> expected = Arrays.asList("Three", "Two");
        List<String> actual = singleLinkedList.getAllItems();
        assertTrue("Lists aren`t equals", expected.equals(actual));
    }

    // tests double_linked_list
    public void testInsertToHead() {
        List<String> expected = Arrays.asList("3", "2", "1");
        List<String> actual = doubleLL_headInsert.getAllElemForward();
        assertTrue("Lists aren`t equals", expected.equals(actual));
    }

    public void testInsertToTail() {
        List<String> expected = Arrays.asList("1", "2", "3");
        List<String> actual = doubleLL_tailInsert.getAllElemForward();
        assertTrue("Lists aren`t equals", expected.equals(actual));
    }

    public void testRemoveHeadElement() {
        doubleLL_tailInsert.removeHeadElement();
        List<String> expected = Arrays.asList("2", "3");
        List<String> actual = doubleLL_tailInsert.getAllElemForward();
        assertTrue("Lists aren`t equals", expected.equals(actual));
    }

    public void testRemoveTailElement() {
        doubleLL_tailInsert.removeTailElement();
        List<String> expected = Arrays.asList("1", "2");
        List<String> actual = doubleLL_tailInsert.getAllElemForward();
        assertTrue("Lists aren`t equals", expected.equals(actual));
    }

    public void testPopTailElement() {
        double_linked_list.ListItem item = doubleLL_tailInsert.popTailElement();
        String expected = "3";
        String actual = item.toString();
        assertEquals(expected, actual);
    }

    public void testPopHeadElement() {
        double_linked_list.ListItem item = doubleLL_tailInsert.popHeadElement();
        String expected = "1";
        String actual = item.toString();
        assertEquals(expected, actual);
    }
}
