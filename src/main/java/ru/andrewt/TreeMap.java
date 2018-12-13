/*
 * Copyright 2018 AndrewT (https://github.com/andrewt0301)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.andrewt;

/**
 * The {@link TreeMap} class implements the binary search tree data structure.
 *
 * @param <K> Key type (must implement {@link Comparable}).
 * @param <V> Value type.
 *
 * @author Andrei Tatarnikov
 */
public final class TreeMap<K extends Comparable<K>, V> {

  public static class Node<K extends Comparable<K>, V> {
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

  public V getPredecessor(K k) {
    Node<K,V> x = search(root, k);
    Node<K,V> y = predecessor(x);
    return y.value;
  }

  private Node<K,V> predecessor(Node<K,V> x) {
    if (x == NIL) {
      return x;
    }

    if (x.left != NIL) {
      return max(x.left);
    }

    Node<K,V> y = x.p;
    while (y != NIL && x == y.left) {
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

  public void remove(K k) {
    Node<K,V> z = search(root, k);
    if (z != NIL) {
      delete(z);
      size--;
    }
  }

  private void delete(Node<K,V> z) {
    if (z.left == NIL) {
      transplant(z, z.right);
    } else if (z.right == NIL) {
      transplant(z, z.left);
    } else {
      Node<K,V> y = min(z.right);
      if (y.p != z) {
        transplant(y, y.right);
        y.right = z.right;
        y.right.p = y;
      }
      transplant(z, y);
      y.left = z.left;
      y.left.p = y;
    }
  }

  private void transplant(Node<K,V> u, Node<K,V> v) {
    if (u.p == NIL) {
      root = v;
    } else if (u == u.p.left) {
      u.p.left = v;
    } else {
      u.p.right = v;
    }
    if (v != NIL) {
      v.p = u.p;
    }
  }

  public K[] getKeys() {
    final K[] array = ArrayUtils.newArray(size);
    keysToArray(root, array, 0);
    return array;
  }

  private static <K extends Comparable<K>, V> int keysToArray(
        final Node<K,V> root,
        final K[] array,
        final int startIndex) {
    int index = startIndex;
    if (root != NIL) {
      index = keysToArray(root.left, array, index);
      array[index++] = root.key;
      index = keysToArray(root.right, array, index);
    }
    return index;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    nodesToStringBuilder(sb, root, 0);
    return sb.toString();
  }

  private static <K extends Comparable<K>, V> void nodesToStringBuilder(
        final StringBuilder sb,
        final Node<K,V> root,
        final int level) {
    if (root == NIL) {
      return;
    }

    nodesToStringBuilder(sb, root.right, level + 1);

    final int offset = 4;
    for (int i = 0; i < offset * level; i++) {
      sb.append(' ');
    }

    sb.append(String.format("[%s:%s]", root.key, root.value));
    sb.append(System.lineSeparator());

    nodesToStringBuilder(sb, root.left, level + 1);
  }
}
