# AVL Tree Implementation in Java

## Overview
This Java program implements a self-balancing AVL (Adelson-Velsky and Landis) tree data structure. AVL trees maintain balance by ensuring that the height difference between left and right subtrees of any node is at most 1, providing O(log n) time complexity for search, insert, and delete operations.

## Features
- **Self-balancing tree implementation** with automatic rotations
- **Core AVL Tree Operations**:
  - **Insert**: Add a new node while maintaining tree balance
  - **Delete**: Remove a node while maintaining tree balance
  - **View tree**: Display the tree in two formats:
    - Breadth-First Traversal (level by level)
    - Visual tree diagram representation
- **User-friendly console interface**
- **Initial tree construction** with predefined values (33, 9, 53, 8, 21, 61, 11)

## Implementation Details
- **Interface-based design** with `AVLTree<T>` interface
- **Generic implementation** allowing any comparable type (specialized for Integer via `IntegerAVLTree`)
- **Node structure** with height and balance factor tracking
- **Tree rebalancing** using:
  - Left rotation
  - Right rotation
  - Left-Right rotation (double rotation)
  - Right-Left rotation (double rotation)
- **Tree visualization** with ASCII representation for console output

## Class Structure
- **`Main`**: Entry point with user interface and operations menu
- **`IntegerAVLTree`**: Specialization of AVLTreeImpl for Integer values
- **`AVLTreeImpl<T>`**: Core implementation of the AVL tree algorithms
- **`AVLTree<T>`**: Interface defining the required operations
- **`Node<T>`**: Basic tree node structure
- **`TreePrinter`**: Utility for visual tree representation

## Technical Specifications
- **Language**: Java
- **Package**: Laboratory
- **Required imports**: 
  - java.util.*
  - static java.lang.Math.PI
  - static java.lang.Math.max

## Example Output

```
Choose operation:
A. Insert
B. Delete
C. View tree
D. View tree and exit.

Enter a letter: C
Breadth-First Traversal: 33, 9, 53, 8, 21, 61, 11, 
        33        
    9       53    
  8   21      61  
     11          
```

## Implementation Notes
- The program prevents duplicate values in the tree
- When attempting to delete a non-existent node, an error message is displayed
- The tree is automatically balanced after each insert or delete operation
- The visual representation shows the hierarchical structure of the tree

## AVL Tree Properties
- Balance factor = height(right subtree) - height(left subtree)
- A node is balanced if its balance factor is -1, 0, or 1
- Rebalancing occurs whenever a node's balance factor becomes less than -1 or greater than 1
- Height of an AVL tree with n nodes is bounded by O(log n)
