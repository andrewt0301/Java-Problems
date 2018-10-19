package ru.andrewt;

public final class TreeMap<K extends Comparable<K>, V> {
  private static final class Node<K extends Comparable<K>, V> {
    final K key;
    V value;

    Node p;
    Node left;
    Node right;

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
    Node<K,V> x = search(root, k);
    return x.value;
  }

  public boolean contains(K k) {
    return search(root, k) != NIL;
  }

  private Node<K,V> search(Node<K,V> x, K k) {
    if (k == null) {
      return (Node<K,V>) NIL;
    }

    while (x != NIL && !k.equals(x.key)) {
      if (k.compareTo(x.key) < 0) {
        x = x.left;
      } else {
        x = x.right;
      }
    }
    return x;
  }

  public V min() {
    Node<K, V> x = min(root);
    return x.value;
  }

  private Node<K, V> min(Node<K, V> x) {
    while (x.left != NIL) {
      x = x.left;
    }
    return x;
  }

  public V max() {
    Node<K, V> x = max(root);
    return x.value;
  }

  private Node<K, V> max(Node<K, V> x) {
    while (x.right != NIL) {
      x = x.right;
    }
    return x;
  }

  public V getSuccessor(K k) {
    Node<K,V> x = search(root, k);
    Node<K,V> y = successor(x);
    return y.value;
  }

  private Node<K,V> successor(Node<K,V> x) {
    if (x == NIL) {
      return x;
    }

    if (x.right != NIL) {
      return min(x.right);
    }

    Node<K,V> y = x.p;
    while (y != NIL && x == y.right) {
      x = y;
      y = y.p;
    }

    return y;
  }

  public V put(K k, V v) {
    Node<K,V> x = root;
    Node<K,V> y = (Node<K,V>) NIL;

    while (x != NIL && !k.equals(x.key)) {
      y = x;
      if (k.compareTo(x.key) < 0) {
        x = x.left;
      } else {
        x = x.right;
      }
    }

    if (x != NIL) {
      V prev = x.value;
      x.value = v;
      return prev;
    }

    Node<K,V> z = new Node<>(k, v);

    z.p = y;
    z.right = NIL;
    z.left = NIL;

    if (y == NIL) {
      root = z;
    } else if (k.compareTo(y.key) < 0) {
      y.left = z;
    } else {
      y.right = z;
    }

    ++size;
    return null;
  }
}
