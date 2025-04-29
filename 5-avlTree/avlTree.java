import java.util.*;
import static java.lang.Math.PI;
import static java.lang.Math.max;
 
public class avlTree {
 
    private static final Set<Character> VALID_CHOICES = Set.of('A', 'B', 'C', 'D');
 
    public static void main(String[] args) {
        List<Integer> startingValues = new ArrayList<>(List.of(33, 9, 53, 8, 21, 61, 11));
 
        IntegerAVLTree tree = new IntegerAVLTree();
        startingValues.forEach(tree::insert);
 
        loop: while (true) {
            System.out.println();
            System.out.println("Choose operation:");
            System.out.println("A. Insert");
            System.out.println("B. Delete");
            System.out.println("C. View tree");
            System.out.println("D. View tree and exit.");
            System.out.println();
            System.out.print("Enter a letter: ");
 
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
 
            if (!VALID_CHOICES.contains(answer.charAt(0))) {
                System.out.println("Invalid answer. Try again.");
                continue;
            }
 
            switch (answer) {
                case "A": {
                    System.out.print("Enter number to insert: ");
                    int input = scanner.nextInt();
                    tree.insert(input);
                    break;
                }
                case "B": {
                    System.out.print("Enter number to delete: ");
                    int input = scanner.nextInt();
                    tree.delete(input);
                    break;
                }
                case "C":
                    printBfs(tree);
                    TreePrinter.printNode(tree.getRoot());
                    break;
                case "D":
                    printBfs(tree);
                    TreePrinter.printNode(tree.getRoot());
                    break loop;
            }
        }
    }
 
    private static void printBfs(AVLTreeImpl<?> tree) {
        System.out.print("Breadth-First Traversal: ");
        Node<?> root = tree.getRoot();
 
        Queue<Node<?>> queue = new LinkedList<>();
        queue.add(root);
 
        while (!queue.isEmpty()) {
 
            Node<?> current = queue.remove();
            System.out.print(current.key);
            System.out.print(", ");
 
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
 
        System.out.println();
    }
}
 
/**
 * Prints an AVL Tree into a Tree Diagram Structure
 */
class TreePrinter {
 
    public static void printNode(Node<?> root) {
        int maxLevel = maxLevel(root);
 
        printNode(Collections.singletonList(root), 1, maxLevel);
    }
 
    private static void printNode(List<Node<?>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreePrinter.isAllElementsNull(nodes)) {
            return;
        }
 
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
 
        printWhitespaces(firstSpaces);
 
        List<Node<?>> newNodes = new ArrayList<>();
        for (Node<?> node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
 
            printWhitespaces(betweenSpaces);
        }
        System.out.println();
 
        for (int i = 1; i <= endgeLines; i++) {
            for (Node<?> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
 
                if (node.left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }
 
                printWhitespaces(i + i - 1);
 
                if (node.right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);
 
                printWhitespaces(endgeLines + endgeLines - i);
            }
 
            System.out.println();
        }
 
        printNode(newNodes, level + 1, maxLevel);
    }
 
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
 
    private static int maxLevel(Node<?> node) {
        if (node == null)
            return 0;
 
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }
 
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
 
        return true;
    }
 
}
 
/**
 * An interface representing an AVL tree data structure.
 *
 * @param <T> The type of data stored in the tree. T must implement the Comparable interface.
 */
interface AVLTree<T extends Comparable<T>> {
 
    /**
     * Inserts a new element with the specified key into the tree.
     *
     * @param key The key of the element to insert.
     */
    void insert(T key);
 
 
    /**
     * Deletes the element with the specified key from the tree.
     *
     * @param key The key of the element to delete.
     */
    void delete(T key);
}
 
 
/**
 * Represents a node in the AVL tree.
 *
 * @param <T> The type of data stored in the node.
 */
class Node<T> {
    /**
     * The key of the data stored in the node.
     */
    T key;
    Node<T> left;
    Node<T> right;
    int height;
    int balanceFactor;
 
    /**
     * Constructs a new Node with the provided key.
     *
     * @param key The key of the data stored in the node.
     */
    public Node(T key) {
        this(key, null, null);
    }
 
    /**
     * Constructs a new Node with the provided key and child nodes.
     *
     * @param key The key of the data stored in the node.
     * @param left The left child of the node.
     * @param right The right child of the node.
     */
    public Node(T key, Node<T> left, Node<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
 
/**
 * An AVL Tree with the node values as an Integer.
 */
class IntegerAVLTree extends AVLTreeImpl<Integer> {
 
}
 
/**
 * AVL Tree Interface Implementation, the actual algorithm is performed here
 */
class AVLTreeImpl<T extends Comparable<T>> implements AVLTree<T> {
    private Node<T> root;
 
    /**
     * Constructs an empty AVLTree.
     */
    public AVLTreeImpl() {
        this(null);
    }
 
    /**
     * Constructs an AVLTree with the provided root node.
     *
     * @param root The root node of the AVLTree.
     */
    public AVLTreeImpl(Node<T> root) {
        this.root = root;
    }
 
    /**
     * Returns the height of the tree.
     *
     * @param node The node to calculate the height for.
     * @return The height of the tree, with -1 for null nodes.
     */
    public int height(Node<?> node) {
        return node == null ? -1 : node.height;
    }
 
 
    /**
     * Gets the root node of the AVLTree.
     *
     * @return The root node of the tree.
     */
    public Node<T> getRoot() {
        return root;
    }
 
    @Override
    public void insert(T key) {
        root = insertHelper(root, key);
    }
 
    @Override
    public void delete(T key) {
        Node<T> found = searchNode(root, key);
        if (found == null) {
            System.out.println("Node does not exist. Try again.");
        }
        root = deleteHelper(root, key);
    }
 
    private Node<T> searchNode(Node<T> node, T key) {
        if (node == null) {
            return null;
        }
 
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return searchNode(node.left, key);
        } else {
            return searchNode(node.right, key);
        }
    }
 
    /**
     * Helper method for inserting a new element into the AVLTree.
     *
     * @param node The current node in the tree.
     * @param keyToInsert The key of the element to insert.
     * @return The updated node after the insertion.
     */
    private Node<T> insertHelper(Node<T> node, T keyToInsert) {
        // Check if the current node is null, indicating we reached the insertion point
        if (node == null) {
            return new Node<>(keyToInsert); // Create and return a new node for the key
        }
 
        T rootKey = node.key;
        // Compare the new key with the current node's key
        int cmp = keyToInsert.compareTo(rootKey);
 
        // Recursively insert the new key into the left or right subtree based on the comparison
        if (cmp < 0) {
            node.left = insertHelper(node.left, keyToInsert);
        } else if (cmp > 0) {
            node.right = insertHelper(node.right, keyToInsert);
        } else {
            // If keys are equal, no need to insert (duplicates not allowed)
        	System.out.println("Node already exists. Try again.");
            return node;
        }
 
        // Update the balance factor of the current node after insertion
        updateHeight(node);
        // Return the updated root node
        return rebalance(node);
    }
 
    private Node<T> rebalance(Node<T> node) {
        int balanceFactor = getBalance(node);
 
        // Left-heavy?
        if (balanceFactor < -1) {
            if (getBalance(node.left) <= 0) {
                // Rotate right
                node = rightRotate(node);
            } else {
                // Rotate left-right
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }
 
        // Right-heavy?
        if (balanceFactor > 1) {
            if (getBalance(node.right) >= 0) {
                // Rotate left
                node = leftRotate(node);
            } else {
                // Rotate right-left
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
 
        return node;
    }
 
    /**
     * Helper method for deleting an element from the AVLTree.
     *
     * @param nodeToBeDeleted The current node in the tree.
     * @param keyToInsert The key of the element to delete.
     * @return The updated node after the deletion.
     */
    private Node<T> deleteHelper(Node<T> nodeToBeDeleted, T keyToInsert) {
        if (nodeToBeDeleted == null) {
            return null;
        }
        int cmp = keyToInsert.compareTo(nodeToBeDeleted.key);
 
        if (cmp < 0) {
            nodeToBeDeleted.left = deleteHelper(nodeToBeDeleted.left, keyToInsert);
        } else if (cmp > 0) {
            nodeToBeDeleted.right = deleteHelper(nodeToBeDeleted.right, keyToInsert);
        } else {
            if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
                nodeToBeDeleted = null;
            } else if (nodeToBeDeleted.left == null) {
                nodeToBeDeleted = nodeToBeDeleted.right;
            } else if (nodeToBeDeleted.right == null) {
                nodeToBeDeleted = nodeToBeDeleted.left;
            } else {
                Node<T> successor = getSuccessor(nodeToBeDeleted.right);
 
                nodeToBeDeleted.key = successor.key;
                nodeToBeDeleted.right = deleteHelper(nodeToBeDeleted.right, successor.key);
            }
        }
 
        if (nodeToBeDeleted == null) {
            return null;
        }
 
        updateHeight(nodeToBeDeleted); 
        return rebalance(nodeToBeDeleted);
    }
 
    private Node<T> getSuccessor(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
 
 
    /**
     * This function performs a left rotation on the provided node x.
     * A left rotation is used to balance the tree when the right subtree of x becomes too heavy.
     * The function works by making the right child of x the new root of the subtree and making x
     * the left child of the new root. The left child of the new root (originally T2)
     * is then made the right child of x.
     */
    private Node<T> leftRotate(Node<T> node) {
    	
        Node<T> rightChild = node.right;
 
        node.right = rightChild.left;
        rightChild.left = node;
 
        updateHeight(node);
        updateHeight(rightChild);
 
        return rightChild;
    }
 
 
    /**
     * This function performs a right rotation on the provided node y. A right rotation is used to balance
     * the tree when the left subtree of y becomes too heavy. The function works by making the left child
     * of y the new root of the subtree and making y the right child of the new root. The right child of
     * the new root (originally T2) is then made the left child of y.
     */
    private Node<T> rightRotate(Node<T> node) {
        Node<T> leftChild = node.left;
 
        node.left = leftChild.right;
        leftChild.right = node;
 
        updateHeight(node);
        updateHeight(leftChild);
 
        return leftChild;
    }
 
    private void updateBalanceFactor(Node<T> node) {
        if (node == null) {
            return;
        }
        node.balanceFactor = getBalance(node.left) - getBalance(node.right);
    }
 
    private int getBalance(Node<T> node) {
        return height(node.right) - height(node.left);
    }
 
    private void updateHeight(Node<T> node) {
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = max(leftChildHeight, rightChildHeight) + 1;
    }
}