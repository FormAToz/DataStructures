package single_linked_list;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList {
    private ListItem top;

    public void push(ListItem item) {
        if (top != null) {
            item.setNext(top);
        }
        top = item;
    }

    public ListItem pop() {
        ListItem item = top;
        if (top != null) {
            top = top.getNext();
            item.setNext(null);
        }
        return item;
    }

    public void removeTop() {
        if (top != null) {
            top = top.getNext();
        }
    }

    public void removeLast() {
        if (top != null) {
            ListItem previous = top;
            ListItem current = previous.getNext();
            while (current != null) {
                previous = previous.getNext();
                current = current.getNext();
                if (current.getNext() == null) {
                    current = null;
                    previous.setNext(null);
                }
            }
        }
    }

    public List<String> getAllItems() {
        List<String> items = new ArrayList<>();
        ListItem current = top;
        while (current != null) {
            items.add(current.getData());
            current = current.getNext();
        }
        return items;
    }
}