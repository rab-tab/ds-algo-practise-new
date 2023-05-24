package linkedList;

public class LL {
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

        while (head!= null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
