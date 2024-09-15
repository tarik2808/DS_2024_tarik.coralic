package midterm.homework3;

import java.util.ArrayList;

public class RedBlackTree<T extends Comparable<T>> {
    private Node<T> root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node<T> node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node<T> node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void put(String searchableName, T value) {
        root = put(root, value);
        root.color = BLACK;
    }

    private Node<T> put(Node<T> node, T value) {
        if (node == null) return new Node<>(value, value, RED);

        int cmp = value.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, value);
        } else if (cmp > 0) {
            node.right = put(node.right, value);
        } else {
            node.values.add(value);
        }

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    public ArrayList<T> get(String searchableName) {
        Node<T> node = root;
        int redEdges = 0;
        int blackEdges = 0;
        while (node != null) {
            int cmp = searchableName.compareTo(node.key.toString());
            if (cmp < 0) {
                if (isRed(node)) redEdges++;
                else blackEdges++;
                node = node.left;
            } else if (cmp > 0) {
                if (isRed(node)) redEdges++;
                else blackEdges++;
                node = node.right;
            } else {
                System.out.println("Red edges: " + redEdges + ", Black edges: " + blackEdges);
                return node.values;
            }
        }
        System.out.println("Entry not found");
        return null;
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2]; // [black, red]
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node<T> node, int[] counts) {
        if (node == null) return;
        if (isRed(node)) counts[1]++;
        else counts[0]++;
        countEdges(node.left, counts);
        countEdges(node.right, counts);
    }

    public void inorderTraversalToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            inorderTraversalToFile(root, writer);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private void inorderTraversalToFile(Node<T> node, FileWriter writer) throws IOException {
        if (node == null) return;
        inorderTraversalToFile(node.left, writer);
        for (T value : node.values) {
            writer.write(value.toString().replace(", ", ";") + "\n");
        }
        inorderTraversalToFile(node.right, writer);
    }
}
