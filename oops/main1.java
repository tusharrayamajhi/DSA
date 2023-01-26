package oops;

public class main1 {
    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
       ll.head = new Node(1);
       Node temp = ll.head.next = new Node(2);
       ll.head.next.next = new Node(3);
       ll.head.next.next.next = new Node(4);
       ll.head.next.next.next.next = new Node(5);
       ll.head.next.next.next = temp;
       //1->2->3->4->5->2
        System.out.println(ll.checkcircle());
        ll.removecylce();
        System.out.println(ll.checkcircle());
        ll.print();
        //System.out.println(ll.palinderom());
        // ll.farfe(1);
        //ll.Addmid(3, 9);
        //ll.print();
        //System.out.println(ll.findrecursive(ll.head, 4));
        //ll.reverse();
       //ll.print();
        //System.out.println(ll.tail.data);
    }
}
