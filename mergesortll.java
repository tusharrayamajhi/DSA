import java.util.function.ObjDoubleConsumer;

public class mergesortll {
    public class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void Addfirst(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
        }
        newnode.next = head;
        head = newnode;
    }
    public void Addlast(int data){
        Node newnode = new Node(data);
        if(head == null){
            tail = head = newnode;
        }
        tail.next = newnode;
        tail = newnode;
    }
    public void Addmid(int data,int index){
        Node newnode = new Node(data);
        Node temp = head;
        int i = 1;
        while(i<index){
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;

    }
    private Node merge(Node lefthead,Node righthead){
        Node domy = new Node(-1);
        Node tmep = domy;
        while(righthead != null && lefthead != null){
           if(lefthead.data <= righthead.data){
            tmep.next = lefthead;
            lefthead = lefthead.next;
            tmep = tmep.next;
        }else{
            tmep.next = righthead;
            righthead =righthead.next;
            tmep = tmep.next;
        }  
        }
        while(lefthead != null){
            tmep.next = lefthead;
            lefthead = lefthead.next;
            tmep = tmep.next;
        }
        while(righthead != null){
            tmep.next = righthead;
            righthead = righthead.next;
            tmep = tmep.next;
        }
        return domy.next;
       
    }
    private static Node findmid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next !=  null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public Node mergesort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = findmid(head);
        //call mergershort
        Node right = mid.next;
        mid.next = null;
        Node lefthead = mergesort(head);
        Node righthead = mergesort(right);
        //merge
        return merge(lefthead,righthead);

    }
    public void print(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " ->");
            temp = temp.next;   
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        mergesortll ll = new mergesortll();
        ll.Addfirst(1);
        ll.Addlast(2);
        ll.Addlast(4);
        ll.Addlast(1);
        ll.Addlast(3);
        ll.Addlast(4);
        ll.print();
        ll.head = ll.mergesort(ll.head);
        ll.print();
    }
}
