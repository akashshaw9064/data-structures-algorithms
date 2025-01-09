public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        System.out.println("List contains:");
        Node i = head;
        while (i != null) {
            System.out.print(i.data + " ");
            i = i.next;
        }
    }

    public Node search(int x) {
        if (head == null)
            return head;

        Node i = head;
        while (i != null) {
            if (i.data == x)
                return i;

            i = i.next;
        }
        return null;
    }

    public void delete(int x) {
        Node i = search(x);
        if (i == null) {
            System.out.println("Specified element is not present in the list");
            return;
        }
        if (i == head) {
            head = i.next;
            System.out.println("SUCCESS!");
            return;
        }
        Node j = head;
        while (j.next != i) {
            j = j.next;
        }
        j.next = i.next;
        System.out.println("SUCCESS!");
    }

    public long length() {
        long count = 0L;
        Node i = head;
        while (i != null) {
            i = i.next;
            count++;
        }
        return count;
    }

    public void reverse() {
        Node prev, nextNode;
        prev = nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        head = prev;
        System.out.println("SUCCESS!");
    }
}
