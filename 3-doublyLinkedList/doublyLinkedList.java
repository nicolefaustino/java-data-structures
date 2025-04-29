import java.util.Scanner;

class Node {
    String data;
    Node prev, next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head, tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToTail(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addBetween(String data, int position) {
        Node newNode = new Node(data);
        if (head == null || position <= 1) {
            addToHead(data);
        } else {
            Node current = tail;
            for (int i = 1; i < position - 1 && current.prev != null; i++) {
                current = current.prev;
            }

            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
        }
    }

    public void deleteFromHead() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
    }

    public void deleteFromTail() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
    }

    public void deleteBetween(int position) {
        if (head != null && position >= 1) {
            Node current = head;
            for (int i = 1; i < position && current != null; i++) {
                current = current.next;
            }

            if (current != null) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
        }
    }

    public void displayList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("[");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}

public class doublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("DOUBLY LINKED LIST OPERATIONS:");
        System.out.println("[1] View");
        System.out.println("[2] Add from Head");
        System.out.println("[3] Add from Tail");
        System.out.println("[4] Add Between");
        System.out.println("[5] Delete from Head");
        System.out.println("[6] Delete from Tail");
        System.out.println("[7] Delete Between");
        System.out.println("[8] Exit");
        
        int choice;
        do {
            System.out.print("\nSelect Operation: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.displayList();
                    break;
                case 2:
                    System.out.print("Enter item to Add: ");
                    String itemToAddHead = scanner.next();
                    list.addToHead(itemToAddHead);
                    list.displayList();
                    break;
                case 3:
                    System.out.print("Enter item to add: ");
                    String itemToAddTail = scanner.next();
                    list.addToTail(itemToAddTail);
                    System.out.println("Updated List:");
                    list.displayList();
                    break;
                case 4:
                    System.out.print("Enter item to add: ");
                    String itemToAddBetween = scanner.next();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    list.addBetween(itemToAddBetween, position);
                    System.out.println("Updated List:");
                    list.displayList();
                    break;
                case 5:
                    list.deleteFromHead();
                    System.out.println("Updated List:");
                    list.displayList();
                    break;
                case 6:
                    list.deleteFromTail();
                    System.out.println("Updated List:");
                    list.displayList();
                    break;
                case 7:
                    System.out.print("Enter position of node to delete: ");
                    int deletePosition = scanner.nextInt();
                    list.deleteBetween(deletePosition);
                    System.out.println("Updated List:");
                    list.displayList();
                    break;
                case 8:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 8);

        scanner.close();
    }
}

