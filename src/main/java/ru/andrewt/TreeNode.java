
package ru.andrewt;

/**
 * The {@link TreeNode} class describes a node of a binary tree.
 *
 * @param <K> Key type (must implement {@link Comparable}).
 * @param <V> Value type.
 *
 * @author Andrei Tatarnikov
 */
public class TreeNode<K extends Comparable<K>, V> {
  public final K key;
  public V value;

  public TreeNode<K,V> p;
  public TreeNode<K,V> left;
  public TreeNode<K,V> right;

  public TreeNode(K key, V value) {
    this.key = key;
    this.value = value;
  }
}
