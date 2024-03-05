import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Constructs a driver program for {@code BinarySearchTree}. Handles three list types: integer,
 * double, and string. Based on the list type given, the program creates a new
 * {@code BinarySearchTree} and handles command input by the user.
 */
public class BinarySearchTreeDriver {
    /**
     * Runs the driver by reading the file given by {@code args}. The program will read commands
     * provided by the user and give appropriate outputs.
     *
     * @param args The path of the file.
     */
    public static void main(String[] args) {
        String filePath;

        // Initializes three lists for different types that are available: integer, double, or
        // string.
        BinarySearchTree<Integer> list1 = new BinarySearchTree<Integer>();
        BinarySearchTree<Double> list2 = new BinarySearchTree<Double>();
        BinarySearchTree<String> list3 = new BinarySearchTree<String>();

        // Stores the first command-line argument as the path to the file. If no command-line
        // argument is given, the program exits.
        if (args.length > 0) {
            filePath = args[0];
        } else {
            System.out.print("Please provide a path to the file as a command-line argument.");
            return;
        } // if

        // Reads the user input for the list type.
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        Scanner scanner = new Scanner(System.in);
        String listType = scanner.nextLine();

        // Tries to find the file through the given path. If file is not found, the program throws
        // FileNotFoundException and exits.
        try {
            File inputFile = new File(filePath);
            Scanner scanner2 = new Scanner(inputFile);
            // Reads the values from the input file.
            while (scanner2.hasNext()) {
                if (listType.equalsIgnoreCase("i")) {
                    int number = scanner2.nextInt();
                    list1.insert(number);
                } else if (listType.equalsIgnoreCase("d")) {
                    double number = scanner2.nextDouble();
                    list2.insert(number);
                } else if (listType.equalsIgnoreCase("s")) {
                    String word = scanner2.next();
                    list3.insert(word);
                } // if
            } // while
            scanner2.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            scanner.close();
            return;
        } // try

        System.out.println("Commands:\n");
        System.out.println("(i) - Insert Item");
        System.out.println("(d) - Delete Item");
        System.out.println("(p) - Print Tree");
        System.out.println("(s) - Search Item");
        System.out.println("(l) - Count Leaf Nodes");
        System.out.println("(sp) - Find Single Parents");
        System.out.println("(c) - Find Cousins");
        System.out.println("(q) - Quit program");

        String command;
        do {
            System.out.print("Enter a command: ");
            command = scanner.next();
            scanner.nextLine();
            switch (command) {
            case "i":
                // Handles Insert Item (i) command by inserting a desired value into the tree and
                // printing the resulting tree.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("In-order: ");
                    list1.inOrder();
                    System.out.print("Enter a number to insert: ");
                    int num = scanner.nextInt();
                    // Inserts the desired item into the tree if the tree does not contain the item.
                    // Otherwise, prints an error message.
                    if (!list1.search(num)) {
                        list1.insert(num);
                        scanner.nextLine();
                    } else if (list1.search(num)) {
                        System.out.println("The item already exits in the tree.");
                    } // if
                    System.out.print("In-order: ");
                    list1.inOrder();
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("In-order: ");
                    list2.inOrder();
                    System.out.print("Enter a number to insert: ");
                    double num = scanner.nextDouble();
                    if (!list2.search(num)) {
                        list2.insert(num);
                        scanner.nextLine();
                    } else if (list2.search(num)) {
                        System.out.println("The item already exits in the tree.");
                    } // if
                    System.out.print("In-order: ");
                    list2.inOrder();
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("In-order: ");
                    list3.inOrder();
                    System.out.print("Enter a string to insert: ");
                    String str = scanner.next();
                    if (!list3.search(str)) {
                        list3.insert(str);
                        scanner.nextLine();
                    } else if (list3.search(str)) {
                        System.out.println("The item already exits in the tree.");
                    } // if
                    System.out.print("In-order: ");
                    list3.inOrder();
                } // if
                break;
            case "d":
                // Handles Delete Item (d) command by deleting the desired item from the tree and
                // printing the resulting tree.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("In-order: ");
                    list1.inOrder();
                    System.out.print("Enter a number to delete: ");
                    int num = scanner.nextInt();
                    // Prints an error message if item does not exist. Otherwise, proceeds to delete
                    // the item from the tree.
                    if (!list1.search(num)) {
                        System.out.println("The number is not present in the tree");
                    } else {
                        list1.delete(num);
                        scanner.nextLine();
                        System.out.print("In-order: ");
                        list1.inOrder();
                    } // if
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("In-order: ");
                    list2.inOrder();
                    System.out.print("Enter a number to delete: ");
                    double num = scanner.nextDouble();
                    if (!list2.search(num)) {
                        System.out.println("The number is not present in the tree");
                    } else {
                        list2.delete(num);
                        scanner.nextLine();
                        System.out.print("In-order: ");
                        list2.inOrder();
                    } // if
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("In-order: ");
                    list3.inOrder();
                    System.out.print("Enter a string to delete: ");
                    String str = scanner.next();
                    if (!list3.search(str)) {
                        System.out.println("Item is not present in the tree");
                    } else {
                        list3.delete(str);
                        scanner.nextLine();
                        System.out.print("In-order: ");
                        list3.inOrder();
                    } // if
                } // if
                break;
            case "p":
                // Handles Print Tree (p) command by printing the tree.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("In-order: ");
                    list1.inOrder();
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("In-order: ");
                    list2.inOrder();
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("In-order: ");
                    list3.inOrder();
                } // if
                break;
            case "s":
                // Handles Search Item (s) command by searching through the tree and printing a
                // message whether the tree contains the item or not.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("In-order: ");
                    list1.inOrder();
                    System.out.print("Enter a number to search: ");
                    int num = scanner.nextInt();
                    if (!list1.search(num)) {
                        scanner.nextLine();
                        System.out.println("Item is not present in the tree");
                    } else if (list1.search(num)) {
                        System.out.println("Item is present in the tree");
                    } // if
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("In-order: ");
                    list2.inOrder();
                    System.out.print("Enter a number to search: ");
                    double num = scanner.nextDouble();
                    if (!list2.search(num)) {
                        scanner.nextLine();
                        System.out.println("Item is not present in the tree");
                    } else if (list2.search(num)) {
                        System.out.println("Item is present in the tree");
                    } // if
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("In-order: ");
                    list3.inOrder();
                    System.out.print("Enter a string to search: ");
                    String str = scanner.next();
                    if (!list3.search(str)) {
                        scanner.nextLine();
                        System.out.println("Item is not present in the tree");
                    } else if (list3.search(str)) {
                        System.out.println("Item is present in the tree");
                    } // if
                } // if
                break;
            case "l":
                // Handles Count Leaf Nodes (l) command by counting the number of leaf nodes the
                // tree and printing the count.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("The number of leaf nodes are ");
                    System.out.println(list1.getNumLeafNodes());
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("The number of leaf nodes are ");
                    System.out.println(list2.getNumLeafNodes());
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("The number of leaf nodes are ");
                    System.out.println(list3.getNumLeafNodes());
                } // if
                break;
            case "sp":
                // Handles Find Single Parents (sp) command by finding all single parents in the
                //tree and printing them.
                boolean has = false;
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("Single Parents: ");
                    has = list1.getSingleParent();
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("Single Parents: ");
                    has = list2.getSingleParent();
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("Single Parents: ");
                    has = list3.getSingleParent();
                } // if
                if (!has) {
                    System.out.println("None");
                } else {
                    System.out.println("");
                } // if
                break;
            case "c":
                // Handles Find Cousins (c) command by finding all cousins of an item and printing
                // them.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("In-order: ");
                    list1.inOrder();
                    System.out.print("Enter a number: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(num + " cousins: ");
                    list1.getCousins(num);
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("In-order: ");
                    list2.inOrder();
                    System.out.print("Enter a number: ");
                    double num = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print(num + " cousins: ");
                    list2.getCousins(num);
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("In-order: ");
                    list3.inOrder();
                    System.out.print("Enter a string: ");
                    String str = scanner.next();
                    scanner.nextLine();
                    System.out.print(str + " cousins: ");
                    list3.getCousins(str);
                } // if
                System.out.println("");
                break;
            case "q":
                // Handles Quit program (q) command by exiting the program and printing the exiting
                // message.
                System.out.println("Exiting the program...");
                return;
            default:
                System.out.println("Invalid command. Try again.");
            } // switch
        } while (command != "q"); // do-while
        scanner.close();
    } // main
} // BinarySearchTreeDriver
