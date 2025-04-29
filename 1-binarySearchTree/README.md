# Binary Search Tree (BST) Implementation with Delete Operation

This Java program implements a Binary Search Tree (BST) with insert, delete, and traversal operations. The delete operation is optimized to handle all cases: deleting leaf nodes, nodes with one child, and nodes with two children.

## Features

- BST node structure with integer keys
- Inorder traversal to display tree contents
- Insert operation to add new nodes
- Delete operation that handles three cases:
  1. Deleting a leaf node (no children)
  2. Deleting a node with one child
  3. Deleting a node with two children (using successor approach)

## Code Structure

The program consists of two main classes:

1. `Node` - Represents a single node in the BST with:
   - `key`: The integer value stored in the node
   - `left`: Reference to left child
   - `right`: Reference to right child

2. `BST` - Contains the BST implementation with:
   - `root`: Reference to the root node of the tree
   - Methods:
     - `inorder()`: Performs inorder traversal (left-root-right)
     - `insert()`: Inserts a new node with given key
     - `deleteNode()`: Deletes a node with given key and returns new root

## How It Works

1. **Insertion**: New nodes are inserted at the appropriate position based on BST properties (left subtree contains smaller keys, right subtree contains larger keys).

2. **Deletion**:
   - For leaf nodes: Simply remove the node
   - For nodes with one child: Replace the node with its child
   - For nodes with two children:
     1. Find the inorder successor (leftmost node in right subtree)
     2. Copy the successor's key to the current node
     3. Delete the successor node

3. **Traversal**: The inorder traversal displays the BST elements in sorted order.

## Example Usage

The program demonstrates:
1. Creating a BST with nodes: 50, 30, 20, 40, 70, 60
2. Deleting a leaf node (20)
3. Deleting a node with one child (70)
4. Deleting a node with two children (50)