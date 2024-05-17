public class LinkedList{
    Node head;
    public LinkedList() {
        this.head = null;
    }

    public Node getNodeAtIndex(int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return null;
        }
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Index out of bounds");
        }
        return current;
    }

    public Node setNodeAtIndex(int index, int value) {
        Node node = getNodeAtIndex(index);
        if (node != null) {
            node.value = value;
        }
        return node;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void insert(int value, int index) {
        if (index < 0 || index > size()) {
            System.out.println("Invalid index");
            return;
        }
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void erase(int index, int amountOfElements) {
        if (index < 0 || index >= size() || amountOfElements <= 0) {
            System.out.println("Invalid index or amount of elements");
            return;
        }
        if (index == 0) {
            head = getNodeAtIndex(amountOfElements);
        } else {
            Node prev = getNodeAtIndex(index - 1);
            if (prev == null || prev.next == null) {
                System.out.println("Invalid index");
                return;
            }
            Node current = prev.next;
            for (int i = 0; i < amountOfElements && current != null; i++) {
                current = current.next;
            }
            prev.next = current;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

}
