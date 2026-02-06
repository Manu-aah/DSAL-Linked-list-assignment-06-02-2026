public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null; // true is list is empty
    }

    /**
     * Adds a new node to the lined list
     * @param data - the String we are adding
     */
    public void add(String data) {
        Node node = new Node(data);// Make a new node object
        if (isEmpty()) { // if the list is empty this is the first item
            head = node;
            tail = node;
        } else { // otherwise add it to the tail
            tail.setNext(node); // What was the tail is now pointing to the new item
            tail = node; // the new item is now the tail
        }
    }

    public void print() {
        Node next = head;
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }

    public String search(String item) {
        Node next = head;
        String itemFound = "";
        while (next != null) {
            if (next.getData().equals(item)) {
                itemFound = item;
            }
            next = next.getNext();
        }
        return itemFound;
    }

    /**
     * For your in class exercise explore completing the following methods for a Singly Linked list supported by
     * your tutor.
     *     // remove
     *     // replace
     *     // delete
     *     // add at head
     *     // menu
     * If you complete all of these save the code, copy  and refactor the entire project as a doubly linked list.
     */
    // to remove an item
    public void remove(String item){
        if (isEmpty()) {
            return;
        }

        if (head.getData().equals(item)) {
            head = head.getNext();
            size--;
            if (head==null) {
                tail = null;
            }
            return;
        }

        Node node = head;
        while (node != null) {
            if (node.getNext().getData().equals(item)) {
                if (node.getNext()==tail) {
                    tail = node;
                }
                node.setNext(node.getNext().getNext());
                size--;
                return;
            }
            node = node.getNext();
        }

    }
        // replace item
    public void replace (String item, String newItem){
        Node current = head;
        boolean found = false;
        while (current != null && !found) {
            if (current.getData().equals(item)) {
                current.setData(newItem);
                found = true;
            }
            current = current.getNext();
        }

        }
        //  delete item at index
    public void delete(int index){
        Node temp = head;
        if (index == 0) {
            head = head.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }
    // add at head
    public void addAtHead(String item){
        Node tempHead = new Node(item);
        tempHead.setNext(head);
        head = tempHead;
    }

}