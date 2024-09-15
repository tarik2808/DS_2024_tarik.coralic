package midterm.homework3;

import java.util.ArrayList;

public class Node<T extends Comparable<T>> {
    T key;
    ArrayList<T> values;
    Node<T> left, right;
    boolean color;

    public Node(T key, T value, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
        this.color = color;
        this.left = null;
        this.right = null;
    }
}
