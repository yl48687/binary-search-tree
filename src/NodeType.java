/**
 * Creates a {@code NodeType} using the parameter {@code T} and fully extends {@code Comparable}.
 */
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> left;
    public NodeType<T> right;
} // NodeType
