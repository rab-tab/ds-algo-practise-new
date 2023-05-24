package linkedList;

public class insertAtTail {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        Node head = first;
        insert(head);
        head = first;
        printLinkedList(head);

    }

    public static void insert(Node head) {

        Node tail = new Node(60);
        System.out.println("Before insertion at tail");
        while (head.next != null) {
            System.out.println(head.data);
            head = head.next;
        }
        head.next = tail;
        tail.next = null;

    }

    public static void printLinkedList(Node head) {
        System.out.println("Post insertion at tail");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }
}
