
package ru.andrewt;

/**
 * The {@link TreeUtils} class provides utility methods to manipulate with binary trees.
 *
 * @author Andrei Tatarnikov
 */
public final class TreeUtils {
  private TreeUtils() {}

  public static boolean isLeaf(final TreeNode<?, ?> node) {
    return node.left == null && node.right == null;
  }

  public static int getLeafCount(final TreeNode<?, ?> root) {

    if (root == null) {
      return 0;
    }

    if (isLeaf(root)) {
      return 1;
    }

    return getLeafCount(root.left) + getLeafCount(root.right);
  }

  public static int getRightLeafCount(final TreeNode<?, ?> root) {

    if (root == null) {
      return 0;
    }

    int count = getRightLeafCount(root.left);

    if (root.right != null) {
      if (isLeaf(root.right)) {
        count++;
      } else {
        count += getRightLeafCount(root.right);
      }
    }

    return count;
  }

  public static int getLeftLeafCount(final TreeNode<?, ?> root) {

    if (root == null) {
      return 0;
    }

    int count = getLeftLeafCount(root.right);

    if (root.left != null) {
      if (isLeaf(root.left)) {
        count++;
      } else {
        count += getLeftLeafCount(root.left);
      }
    }

    return count;
  }

}
