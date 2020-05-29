package double_linked_list;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList {
    private ListItem head;
    private ListItem tail;

    public Boolean isEmpty() {  // returns true, if list is empty
        return head == null;
    }

    public ListItem getHeadElement() {
        return head;
    }

    public ListItem getTailElement() {
        return tail;
    }

    public ListItem popHeadElement() {
        ListItem item = head;
        removeHeadElement();
        return item;
    }

    public ListItem popTailElement() {
        ListItem item = tail;
        removeTailElement();
        return item;
    }

    public void removeHeadElement() {
        if (!isEmpty()) {
            if (head.getNext() == null)
                tail = null;
            else
                head.getNext().setPrev(null);
            head = head.getNext();
        }
    }

    public void removeTailElement() {
        if (!isEmpty()) {
            if (head.getNext() == null)
                head = null;
            else
                tail.getPrev().setNext(null);
            tail = tail.getPrev();
        }
    }

    public void addToHead(ListItem item) {
        if (isEmpty())
            tail = item;
        else
            head.setPrev(item);
            item.setNext(head);
            head = item;
    }

    public void addToTail(ListItem item) {
        if (isEmpty())
            head = item;
        else
            tail.setNext(item);
            item.setPrev(tail);
        tail = item;
    }

    public List<String> getAllElemForward() {
        List<String> items = new ArrayList<>();
        ListItem current = head;
        while (current != null) {
            items.add(current.toString());
            current = current.getNext();
        }
        return items;
    }

    public List<String> getAllElemBackward() {
        List<String> items = new ArrayList<>();
        ListItem current = tail;
        while (current != null) {
            items.add(current.toString());
            current = current.getPrev();
        }
        return items;
    }
}