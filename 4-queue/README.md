# Circular Queue Implementation in Java

## Overview
This Java program demonstrates a circular queue implementation using an array. A circular queue is a linear data structure that follows the First In First Out (FIFO) principle and wraps around to the beginning of the array when it reaches the end.

## Features
- **Circular Queue Operations**:
  - **Peek**: View the front index position and value
  - **Enqueue**: Add an element to the queue
  - **Dequeue**: Remove an element from the queue
  - **View All**: Display all elements with their respective indices
  - **Exit**: Terminate the program

## Implementation Details
- Fixed-size array implementation (maximum size of 10 elements)
- Uses front and rear pointers to track queue positions
- Circular design to efficiently utilize array space
- Console-based user interface for interaction