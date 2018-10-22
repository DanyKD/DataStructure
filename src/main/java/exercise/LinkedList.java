package exercise;

class Node {
    int elem;
    Node next;

    Node(int i, Node n) {
        elem = i;
        next = n;
    }
}

public class LinkedList {

    // storage for elements
    Node first;

    public LinkedList() {
        first = null;
    }

    /**
     * Adds an integer to the end of this list.
     *
     * @param i the integer to add
     */
    public void add(int i) {
        Node newNode = new Node (i, null);

        if (first == null) { // list is empty
            first = newNode;
        } else { // list is not empty
            // 1. step find the last node
            Node current = first;

            while (current.next != null) {
                // current is not the last node!
                current = current.next;
            }
            // current.next == null
            // that means that current is the last node! YAY! :-)

            // 2. step insert new node
            current.next = newNode;
        }
    }

    /**
     * Returns element at given index.
     * <p>
     * Complexity: O(n)
     *
     * @param index
     * @return element at index
     * @throws {@link IndexOutOfBoundsException} if index is negative
     */
    public int get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException ();
        }

        int i = 0;
        Node current = this.first;

        while (index != i && current.next != null) {
            i++;
            current = current.next;
        }

        if (index <= i) {
            // here, we are at the right place!
            return current.elem;
        } else {
            throw new IndexOutOfBoundsException ();
        }
    }

    /**
     * Complexity: O(n)
     *
     * @return the size of the list.
     */
    public int size() {
        if (first == null) { // the list is empty!
            return 0;
        }
        int counter = 1;
        Node current = first;
        while (current.next != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    // Complexity: O(n^2)
    void printAll2() {
        long millisStart = System.nanoTime ();
        System.out.print ("[");
        // only use 'size' and 'get'
        int counter = 0;
        while (counter < size ()) {
            int elem = get (counter);
            System.out.print (elem);
            if (counter < size () - 1) { // it's *not* the last element
                System.out.print (",");
            }
            counter++;
        }
        System.out.print ("]");
        long millisEnd = System.nanoTime ();
        System.out.println ("Time is:" + (millisEnd - millisStart));
    }

    void printAll() {
        long millisStart = System.nanoTime ();
        if (first == null) { // list is empty
            System.out.print ("<empty>");
        } else {
            // we know that first is not null!
            System.out.print ("[");

            Node current = first;
            while (current.next != null) {
                System.out.print (current.elem + ",");
                current = current.next;
            }
            // print last element
            System.out.print (current.elem);

            System.out.print ("]");
            long millisEnd = System.nanoTime ();
            System.out.println ("Time is:" + (millisEnd - millisStart));

        }
    }

    public Node concat(LinkedList l) {

        if (first == null) {
            first = l.first;
            return first;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = l.first;
            return first;
        }

    }

    public Node reverse() {
        Node prevNode = null;
        Node current = first;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        first = prevNode;
        return first;
    }


}