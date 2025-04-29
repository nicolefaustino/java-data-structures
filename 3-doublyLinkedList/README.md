# Doubly Linked List Implementation in Java

This Java program implements a doubly linked list with various operations including insertion, deletion, and traversal. The implementation provides a menu-driven interface for interacting with the list.

## Features

- Complete implementation of a doubly linked list
- Support for all fundamental operations:
  - Insertion at head
  - Insertion at tail
  - Insertion at specific position
  - Deletion from head
  - Deletion from tail
  - Deletion from specific position
  - List traversal/display
- Interactive menu system for easy operation selection
- Type-safe implementation using generics (stores String data)

## Class Structure

### `Node` Class
- Represents individual nodes in the doubly linked list
- Contains:
  - `data`: String value stored in the node
  - `prev`: Reference to previous node
  - `next`: Reference to next