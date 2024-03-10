# Binary Search Tree
This project contains Java classes implementing a binary search tree data structure. The project provides a flexible and efficient implementation of a binary search tree, supporting insertion, deletion, searching, printing, and various operations on the tree.

## Design Overview
The project is designed to offer a comprehensive solution for managing binary search trees in Java. The `BinarySearchTree` class represents the binary search tree data structure, providing essential functionalities such as insertion, deletion, searching, and printing. It utilizes the `NodeType` class to define the structure of a tree node, extending the `Comparable` interface for comparison between node values. The `BinarySearchTreeDriver` class serves as the driver program, facilitating user interaction by reading commands from a file or user input and executing corresponding operations on the tree.

## Functionality
`BinarySearchTreeDriver`:
- Constructs a driver program for interacting with the binary search tree.
- Reads commands from a file or user input and processes them to perform operations on the tree.
- Supports commands for inserting values, deleting values, printing the tree, searching for items, counting leaf nodes, finding single parents, finding cousins, and quitting the program.

`BinarySearchTree`:
- Represents a binary search tree supporting insertion, deletion, searching, and printing.
- Provides methods for inserting values, deleting values, searching for items, printing the tree, counting leaf nodes, finding single parents, and finding cousins.

`NodeType`:
- Defines the structure of a node in the binary search tree.
- Extends the `Comparable` interface to allow comparison between node values.

## File Structure and Content:
```
binary-search-tree/
├── compile.sh
├── README.md
├── resources
│   ├── double-input1.txt
│   ├── int-input1.txt
│   └── string-input1.txt
└── src
    ├── BinarySearchTreeDriver.java
    ├── BinarySearchTree.java
    └── NodeType.java
```
