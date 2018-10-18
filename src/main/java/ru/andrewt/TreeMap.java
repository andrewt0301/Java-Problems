package ru.andrewt;

public final class TreeMap<K extends Comparable<K>, V> {
  private static final class Node<K extends Comparable<K>, V> {
    final K key;
    final V value;

    Node p = null;
    Node left = null;
    Node right = null;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private static final Node<?,?> NIL = new Node<>(null, null);

  private Node<K,V> root;
  private int size;

  public TreeMap() {
    this.root = (Node<K, V>) NIL;
    this.size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public V get(K k) {
    if (k == null) {
      return null;
    }

    Node<K,V> x = root;
    while (x != NIL && !k.equals(x.key)) {
      if (k.compareTo(x.key) < 0) {
        x = x.left;
      } else {
        x = x.right;
      }
    }
    return x.value;
  }

  public V min() {
    return min(root);
  }

  private V min(Node<K, V> x) {
    while (x.left != NIL) {
      x = x.left;
    }
    return x.value;
  }

  public V max() {
    return max(root);
  }

  private V max(Node<K, V> x) {
    while (x.right != NIL) {
      x = x.right;
    }
    return x.value;
  }
}
