
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

  private static final TreeNode<?,?> NIL = new TreeNode<>(null, null);

  private TreeNode<K,V> root;
  private int size;

  public TreeMap() {
    this.root = (TreeNode<K, V>) NIL;
    this.size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public V get(K k) {
    TreeNode<K,V> x = search(root, k);
    return x.value;
  }

  public boolean contains(K k) {
    return search(root, k) != NIL;
  }

  private TreeNode<K,V> search(TreeNode<K,V> x, K k) {
    if (k == null) {
      return (TreeNode<K,V>) NIL;
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
    TreeNode<K, V> x = min(root);
    return x.value;
  }

  private TreeNode<K, V> min(TreeNode<K, V> x) {
    while (x.left != NIL) {
      x = x.left;
    }
    return x;
  }

  public V max() {
    TreeNode<K, V> x = max(root);
    return x.value;
  }

  private TreeNode<K, V> max(TreeNode<K, V> x) {
    while (x.right != NIL) {
      x = x.right;
    }
    return x;
  }

  public V getSuccessor(K k) {
    TreeNode<K,V> x = search(root, k);
    TreeNode<K,V> y = successor(x);
    return y.value;
  }

  private TreeNode<K,V> successor(TreeNode<K,V> x) {
    if (x == NIL) {
      return x;
    }

    if (x.right != NIL) {
      return min(x.right);
    }

    TreeNode<K,V> y = x.p;
    while (y != NIL && x == y.right) {
      x = y;
      y = y.p;
    }

    return y;
  }

  public V getPredecessor(K k) {
    TreeNode<K,V> x = search(root, k);
    TreeNode<K,V> y = predecessor(x);
    return y.value;
  }

  private TreeNode<K,V> predecessor(TreeNode<K,V> x) {
    if (x == NIL) {
      return x;
    }

    if (x.left != NIL) {
      return max(x.left);
    }

    TreeNode<K,V> y = x.p;
    while (y != NIL && x == y.left) {
      x = y;
      y = y.p;
    }

    return y;
  }

  public V put(K k, V v) {
    TreeNode<K,V> x = root;
    TreeNode<K,V> y = (TreeNode<K,V>) NIL;

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

    TreeNode<K,V> z = new TreeNode<>(k, v);

    z.p = y;
    z.right = (TreeNode<K,V>) NIL;
    z.left = (TreeNode<K,V>) NIL;

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

  public V remove(K k) {
    TreeNode<K,V> z = search(root, k);
    if (z == NIL) {
      return null;
    }

    delete(z);
    size--;
    return z.value;
  }

  private void delete(TreeNode<K,V> z) {
    if (z.left == NIL) {
      transplant(z, z.right);
    } else if (z.right == NIL) {
      transplant(z, z.left);
    } else {
      TreeNode<K,V> y = min(z.right);
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

  private void transplant(TreeNode<K,V> u, TreeNode<K,V> v) {
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
        final TreeNode<K,V> root,
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
        final TreeNode<K,V> root,
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
