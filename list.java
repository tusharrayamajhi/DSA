import javax.lang.model.SourceVersion;

public class list {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void Addfirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void AddLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void Addmid(int idx,int data){
        Node newNode = new Node(data);
        size++;
        int i = 0;
        Node temp = head;
        while(i < idx - 1){
            temp = head.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println(size);
    }
    public int helper(Node head,int key){
        if(head.next == null){
            System.out.println("key not found");
        }else if(head.data == key){
            return 0;
        }
        int count = helper(head.next, key);
        return count + 1;

    }
    public int findnum(Node head,int key){
        return helper(head,key);
    }
    public static void main(String[] args) {
        list ll = new list();
        ll.Addfirst(1);
        ll.AddLast(2);
        ll.AddLast(3);
        ll.AddLast(4);
        ll.Addmid(2, 5);
        ll.print();
        System.out.println(ll.findnum(head,7));

    }
}
