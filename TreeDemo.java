/**
 * Represents a node in a binary search tree.
 */
class Node {
    int value;
    Node left, right;

    /**
     * Constructs a new node with the given value.
     * 
     * @param value The value of the node.
     */
    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

/**
 * Represents a binary search tree.
 */
class BinarySearchTree {
    Node root;

    /**
     * Inserts a value into the binary search tree.
     * 
     * @param value The value to insert.
     */
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value)
            root.left = insertRecursive(root.left, value);
        else if (value > root.value)
            root.right = insertRecursive(root.right, value);

        return root;
    }

    /**
     * Performs a pre-order traversal of the binary search tree and prints the values.
     */
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversalRecursive(root.left);
            preOrderTraversalRecursive(root.right);
        }
    }

    /**
     * Performs an in-order traversal of the binary search tree and prints the values.
     */
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(Node root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRecursive(root.right);
        }
    }

    /**
     * Performs a post-order traversal of the binary search tree and prints the values.
     */
    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(Node root) {
        if (root != null) {
            postOrderTraversalRecursive(root.left);
            postOrderTraversalRecursive(root.right);
            System.out.print(root.value + " ");
        }
    }

    /**
     * Searches for a value in the binary search tree.
     * 
     * @param key The value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean find(int key) {
        return findRecursive(root, key);
    }

    private boolean findRecursive(Node root, int key) {
        if (root == null)
            return false;
        if (root.value == key)
            return true;
        if (key < root.value)
            return findRecursive(root.left, key);
        else
            return findRecursive(root.right, key);
    }

    /**
     * Finds the minimum value in the binary search tree.
     * 
     * @return The minimum value.
     * @throws IllegalArgumentException if the tree is empty.
     */
    public int getMin() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty");
        Node current = root;
        while (current.left != null)
            current = current.left;
        return current.value;
    }

    /**
     * Finds the maximum value in the binary search tree.
     * 
     * @return The maximum value.
     * @throws IllegalArgumentException if the tree is empty.
     */
    public int getMax() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty");
        Node current = root;
        while (current.right != null)
            current = current.right;
        return current.value;
    }

    /**
     * Deletes a node with the specified value from the binary search tree.
     * 
     * @param key The value to delete.
     */
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.value)
            root.left = deleteRecursive(root.left, key);
        else if (key > root.value)
            root.right = deleteRecursive(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.value = getMinValue(root.right);
            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    private int getMinValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
}

/**
 * A demo class to demonstrate the functionality of the binary search tree.
 */
public class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree();
        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);

        System.out.print("In-order traversal: ");
        t1.inOrderTraversal();
        System.out.println();
    }
}
