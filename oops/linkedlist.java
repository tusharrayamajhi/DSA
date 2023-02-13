package oops;

public class linkedlist {
    public Node head;
    public Node tail;
    int size = 0;

    public void Addfirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void AddAtLast(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            tail = head = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;

    }

    public void Addmid(int index, int data) {
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node pre = null;
        Node curr = tail = head;
        System.out.println(curr.next);
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
    }

    public void find(int data) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("found at " + i);
            }
            temp = temp.next;
            i++;
        }
    }

    public int helper(Node head, int key) {
        if (head.next == null) {
            System.out.println("not found");
        } else if (head.data == key) {
            return 0;
        }
        int count = findrecursive(head.next, key);
        return count + 1;
    }

    public int findrecursive(Node head, int key) {
        return helper(head, key);
    }

    public void farfe(int index) {
        if (head == null) {
            System.out.println("empty linked list");
        }
        int a = size - index + 1;
        Node temp = head;
        int i = 1;
        while (i < a - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public Node mid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean palinderom() {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = mid(head);
        Node pre = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        Node right = pre;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean checkcircle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void removecylce() {
        // check the ll is cycle or not
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //finding the meeting point
        slow = head;
        Node pre = null;
        while (slow != fast) {
            pre = fast;
            fast = fast.next;
            slow = slow.next;
        }
        //removing circle
        pre.next = null;
    

    }
}