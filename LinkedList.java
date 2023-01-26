public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void Addfirst(int data) {
        // creat node first
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // add head in new node
        newNode.next = head;
        // add newNode in head
        head = newNode;

    }

    public void Addlast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            tail = head = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addinmid(int idx, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void Print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node per = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = per;
            per = curr;
            curr = next;
        }
        head = per;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.Addfirst(2);
        ll.Addfirst(1);
        ll.Addlast(3);
        ll.Addlast(4);
        ll.Addfirst(0);
        ll.addinmid(2, 9);
        ll.Print();
        ll.reverse();
        ll.Print();

    }

}