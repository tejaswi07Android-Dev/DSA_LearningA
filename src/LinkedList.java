// LinkedListExample.java
public class LinkedList {

    // Node class representing each element in the list
    class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // Insert method to add new elements to the end
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the end and insert the new node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Display method to print the linked list
    public void display() {
        Node current = head;

        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Linked List: ");
        while (current != null) {
            if (current.next == null){
                System.out.print(current.data);
            }else{
                System.out.print(current.data + " -> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    public void reverse(){
        Node prev = null;
        Node current = head;
        Node then;

        while (current != null) {
            then = current.next;   // Save the next node
            current.next = prev;   // Reverse the current node's pointer
            prev = current;        // Move prev forward
            current = then;        // Move current forward
        }

        // After the loop, 'prev' will be the new head
        head = prev;

    }


    public void reverseFrom(int n) {
        if (head == null || n <= 0) return;

        Node current = head;
        Node prev = null;

        // Step 1: Move to the (n-1)th node
        for (int i = 1; i < n && current != null; i++) {
            prev = current;
            current = current.next;
        }

        // If n is greater than the length of the list, do nothing
        if (current == null) return;

        Node connection = prev;   // Node before the part to reverse
        Node tail = current;      // The first node in the section to be reversed
        Node next = null;
        Node newPrev = null;

        // Step 2: Reverse from current to the end
        while (current != null) {
            next = current.next;
            current.next = newPrev;
            newPrev = current;
            current = next;
        }

        // Step 3: Reconnect
        if (connection != null) {
            connection.next = newPrev; // connect the first part to the reversed part
        } else {
            head = newPrev;            // if reversing from the head
        }

        // Step 4: tail should now point to the remainder (null)
        tail.next = current; // (current is null here)
    }


    public void reverseBetween(int n, int m) {
        if (head == null || n >= m) return;

        Node dummy = new Node(0); // dummy node to simplify edge cases
        dummy.next = head;
        Node prev = dummy;

        // Step 1: Move prev to the (n - 1)-th node
        for (int i = 1; i < n; i++) {
            if (prev == null) return; // n is out of bounds
            prev = prev.next;
        }

        // Step 2: Start reversing from n-th node to m-th node
        Node start = prev.next;      // The first node of the segment to reverse
        Node then = start.next;      // Node that will be moved to the front iteratively

        // Step 3: Reverse between n and m
        for (int i = 0; i < m - n; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        // Step 4: Update head in case we reversed from the first node
        head = dummy.next;
    }



}
