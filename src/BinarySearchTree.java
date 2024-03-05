/**
 * Creates a {@code BinarySearchTree} using the parameter {@code T} and fully extends the class
 * {@code Comparable}.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    /**
     * Initializes the tree.
     */
    public BinarySearchTree() {
        root = null;
    } // BinarySearchTree

    /**
     * Inserts a {@code key} to the tree by calling a recursive function {@code insertRecursive}.
     *
     * @param key The key being inserted to the tree.
     */
    public void insert(T key) {
        root = insertRecursive(root, key);
    } // insert

    /**
     * Inserts a {@code key} to the tree recursively.
     *
     * @param root The root of the tree.
     * @param key The key being inserted to the tree.
     * @return root after the key is inserted.
     */
    public NodeType<T> insertRecursive(NodeType<T> root, T key) {
        if (root == null) {
            root = new NodeType<>();
            root.info = key;
            root.left = null;
            root.right = null;
        } else if (key.compareTo(root.info) < 0) {
            root.left = insertRecursive(root.left, key);
        } else if (key.compareTo(root.info) > 0) {
            root.right = insertRecursive(root.right, key);
        } // if
        return root;
    } // insertRecursive

    /**
     * Deletes a {@code key} from the tree by calling a recursive function {@code deleteRecursive}.
     *
     * @param key The key being deleted from the tree.
     */
    public void delete(T key) {
        root = deleteRecursive(root, key);
    } // delete

    /**
     * Deletes a {@code key} from the tree recursively.
     *
     * @param root The root of the tree.
     * @param key The key being deleted from the tree.
     * @return root after the key is deleted.
     */
    public NodeType<T> deleteRecursive(NodeType<T> root, T key) {
        if (root == null) {
            return root;
        } // if
        if (key.compareTo(root.info) < 0) {
            root.left = deleteRecursive(root.left, key);
            return root;
        } else if (key.compareTo(root.info) > 0) {
            root.right = deleteRecursive(root.right, key);
            return root;
        } // if
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } // if
        NodeType<T> parent = root;
        NodeType<T> child = root.right;
        while (child.left != null) {
            parent = child;
            child = child.left;
        } // while
        if (parent != root) {
            parent.left = child.right;
        } else {
            parent.right = child.right;
        } // if
        root.info = child.info;
        return root;
    } // deleteRecursive

    /**
     * Searches for an {@code item} by calling a recursive functions {@code searchRecursive}.
     *
     * @param item The item being searched for in the tree.
     * @return value from {@code searchRecursive}.
     */
    public boolean search(T item) {
        return searchRecursive(root, item);
    } // search

    /**
     * Searches for an {@code item} recursively.
     *
     * @param root The root of the tree.
     * @param item The item being searched for in the tree.
     * @return true if the item is found, else false.
     */
    public boolean searchRecursive(NodeType<T> root, T item) {
        if (root == null) {
            return false;
        } // if
        if (item.compareTo(root.info) == 0) {
            return true;
        } // if
        if (item.compareTo(root.info) < 0) {
            return searchRecursive(root.left, item);
        } else {
            return searchRecursive(root.right, item);
        } // if
    } // searchRecursive

    /**
     * Organizes the tree to be in order by calling a recursive function {@code inOrderRecursive}.
     */
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println("");
    } // inOrder

    /**
     * Organizes the tree to be in order recursively.
     *
     * @param root The root of the tree.
     */
    private void inOrderRecursive(NodeType<T> root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.info + " ");
            inOrderRecursive(root.right);
        } // if
    } // inOrderRecursive

    /**
     * Finds all nodes with a single child by calling a recursive function
     * {@code getSingleParentRecursive}.
     *
     * @return all single parents.
     */
    public boolean getSingleParent() {
        return getSingleParentRecursive(root);
    } // getSingleParent

    /**
     * Finds all nodes with a single child recursively.
     *
     * @param root The root of the tree.
     * @return all single parents.
     */
    public boolean getSingleParentRecursive(NodeType<T> root) {
        if (root == null) {
            return false;
        } // if
        if ((root.left != null && root.right == null) ||
            (root.left == null && root.right != null)) {
            System.out.print(root.info + " ");
            return true;
        } // if
        boolean leftHasSP = getSingleParentRecursive(root.left);
        boolean rightHasSP = getSingleParentRecursive(root.right);
        return leftHasSP || rightHasSP;
    } // getSingleParentRecursive

    /**
     * Counts the number of leaf nodes in the tree by calling a recursive function
     * {@code getNumLeafNodesRecursive}.
     *
     * @return the number of leaf nodes in the tree.
     */
    public int getNumLeafNodes() {
        return getNumLeafNodesRecursive(root);
    } // getNumLeafNodes

    /**
     * Counts the number of leaf nodes in the tree recursively.
     *
     * @param root The root of the tree.
     * @return the number of leaf nodes in the tree.
     */
    public int getNumLeafNodesRecursive(NodeType<T> root) {
        if (root == null) {
            return 0;
        } // if
        if (root.left == null && root.right == null) {
            return 1;
        } // if
        return getNumLeafNodesRecursive(root.left) + getNumLeafNodesRecursive(root.right);
    } // getNumLeafNodesRecursive

    /**
     * Finds all cousins of a node by calling functions {@code findNode}, {@code findParent},
     * {@code findCousins}, and {@code getCousinsRecursive}.
     *
     * @param item The item whose cousins are being found.
     */
    public void getCousins(T item) {
        NodeType<T> node = findNode(root, item);
        if (node != null) {
            NodeType<T> parent = findParent(root, node);
            if (parent != null) {
                findCousins(parent);
            } // if
        } // if
    } // getCousins

    /**
     * Finds a node that holds {@code item}.
     *
     * @param root The root of the tree.
     * @param item The item whose node is being found.
     * @return node that holds the item.
     */
    private NodeType<T> findNode(NodeType<T> root, T item) {
        if (root == null || root.info.equals(item)) {
            return root;
        } // if
        NodeType<T> leftNode = findNode(root.left, item);
        if (leftNode != null) {
            return leftNode;
        } // if
        return findNode(root.right, item);
    } // findNode

    /**
     * Finds a parent of the {@code node}.
     *
     * @param root The root of the tree.
     * @param node The node whose parent is being found.
     * @return the parent of the node.
     */
    private NodeType<T> findParent(NodeType<T> root, NodeType<T> node) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        } // if
        if ((root.left != null && root.left == node) ||
            (root.right != null && root.right == node)) {
            return root;
        } // if
        NodeType<T> leftNode = findParent(root.left, node);
        if (leftNode != null) {
            return leftNode;
        } // if
        return findParent(root.right, node);
    } // findParent

    /**
     * Finds cousins by finding siblings of the parent and their children, if any.
     *
     * @param parent The parent whose siblings will be found to access cousins.
     */
    private void findCousins(NodeType<T> parent) {
        NodeType<T> grandparent = findParent(root, parent);
        NodeType<T> cousins;
        if (grandparent != null) {
            if (grandparent.left == parent) {
                cousins = grandparent.right;
            } else {
                cousins = grandparent.left;
            } // if
            getCousinsRecursive(cousins);
        } // if
    } // findCousins

    /**
     * Finds all cousins of a node and prints.
     *
     * @param root The root of the tree.
     */
    private void getCousinsRecursive(NodeType<T> root) {
        if (root == null) {
            return;
        } // if
        if (root.left != null) {
            System.out.print(root.left.info);
            System.out.print(" ");
        } // if
        if (root.right != null) {
            System.out.print(root.right.info);
        } // if
    } // getCousinsRecursive
} // BinarySearchTree
