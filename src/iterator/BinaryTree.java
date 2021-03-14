package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<T>> implements Iterable {

    private Node<T> root;

    @Override
    public Iterator iterator() {
        return new InOrderIterator();
    }

    private class Node<T> implements Comparable<T> {
        T value;
        Node<T> parent;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public int compareTo(T t) {
            return ((Comparable) this.value).compareTo(t);
        }
    }


    public void insert(T value) {
        if (root == null) root = new Node<>(value);
        else insert(root, value);
    }

    private void insert(Node<T> node, T value) {
        if (node.compareTo(value) < 0) {
            if (node.right == null) {
                node.right = new Node<>(value);
                node.right.parent = node;
            } else insert(node.right, value);
        } else {
            if (node.left == null) {
                node.left = new Node<>(value);
                node.left.parent = node;
            } else insert(node.left, value);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        toString(root, sb);
        return sb.toString();
    }

    private void toString(Node node, StringBuilder sb) {
        if (node == null) return;
        if (node.left != null) {
            toString(node.left, sb);
        }
        sb.append(node.value);
        sb.append(' ');
        if (node.right != null) {
            toString(node.right, sb);
        }
    }

    public InOrderIterator inOrderIterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Node> {

        private Node next;

        InOrderIterator() {
            next = startNode(BinaryTree.this.root);
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = next;
            if (next.right != null) {
                next = next.right;
                while (next.left != null)
                    next = next.left;
                return node;
            }

            while (true) {
                if (next.parent == null) {
                    next = null;
                    return node;
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return node;
                }
                next = next.parent;
            }
        }

        private Node startNode(Node node) {
            if (node.left != null) return startNode(node.left);
            else return node;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(1000);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(-1);
        binaryTree.insert(10000);
        for (Object o : binaryTree) {
            System.out.println(o);
        }
    }

}
