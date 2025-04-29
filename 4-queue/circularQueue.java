import java.util.Scanner;

public class circularQueue {
    private static final int MAX_SIZE = 10;
    private static int[] queue = new int[MAX_SIZE];
    private static int front = -1;
    private static int rear = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CIRCULAR QUEUE OPERATIONS:");
        // Queue operations
        int operations;
        do {
            // Displaying the available queue operations
            System.out.println("\nQueue Operations:");
            System.out.println("[1] Peek");
            System.out.println("[2] Enqueue");
            System.out.println("[3] Dequeue");
            System.out.println("[4] View All");
            System.out.println("[5] Exit");
            System.out.print("\nSelect Operation: ");
            
            // Reading the selected operation from the user
            operations = scanner.nextInt();

            // Performing the selected operation using a switch statement
            switch (operations) {
                case 1:
                    peek(); // Call the peek() method
                    break;
                case 2:
                    System.out.print("Enter item to add: ");
                    enqueue(scanner.nextInt()); // Call the enqueue() method with the user-entered item
                    break;
                case 3:
                    dequeue(); // Call the dequeue() method
                    break;
                case 4:
                    viewAll(); // Call the viewAll() method
                    break;
            }

        } while (operations != 5);

        System.out.println("Exiting the program.");
    }

    // Method to display the front and rear indices if the queue is not empty
    private static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            System.out.println("Front index = " + front + " Rear index = " + rear);
        } else {
            System.out.println("Front index = " + front);
        }
    }

    // Method to dequeue an item from the queue
    private static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Done removing the item...");
            front = (front + 1) % MAX_SIZE; // Update the front index in a circular manner
        } 
    }

    // Method to enqueue an item into the queue
    private static void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            if (isEmpty()) {
                front = 0; // Set the front index to 0 if the queue is empty
            }
            rear = (rear + 1) % MAX_SIZE; // Update the rear index in a circular manner
            queue[rear] = item; // Place the item in the queue at the updated rear index
        }
        System.out.println("Front index = " + front + " Rear index = " + rear);
    }

    // Method to view all elements in the queue with their index positions
    private static void viewAll() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue:");
            int i = front;
            do {
                System.out.println("Index " + i + ": " + queue[i]);
                i = (i + 1) % MAX_SIZE; // Move to the next index in a circular manner
            } while (i != (rear + 1) % MAX_SIZE); // Continue until all elements are displayed

            System.out.println("Front index = " + front + " Rear index = " + rear);
        }
    }

    // Method to check if the queue is empty
    private static boolean isEmpty() {
        return front == -1;
    }

    // Method to check if the queue is full
    private static boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }
    
}
