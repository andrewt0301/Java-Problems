
package ru.andrewt;

/**
 * The {@link Strings} class provides methods that implement various algorithms on strings.
 */
public final class Strings {
  private Strings() {}

  /**
   * Searches for the first occurrence of the specified string in a text.
   * The naive algorithm iteratively checks each position in the text for match to the string.
   * <p>
   * Time complexity: {@code O((N - M + 1) * M)}, where N is the length of the text
   *                  and M is the length of the string. If M = N/2, this gives
   *                  the complexity of O(N^2).
   * <p/>
   * @param text Text.
   * @param str String to be searched.
   * @return Start position of the string in the text or -1 if no occurrence
   *         of the string is found.
   */
  public static int naiveSearch(String text, String str) {
    // TODO
    return -1;
  }

  /**
   * Searches for the first occurrence of the specified string in a text using
   * the Rabin-Karp algorithm.
   * <p>
   * Time complexity: TODO
   * <p/>
   * @param text Text.
   * @param str String to be searched.
   * @return Start position of the string in the text or -1 if no occurrence
   *         of the string is found.
   */
  public static int rabinKarpSearch(String text, String str) {
    // TODO
    return -1;
  }

}
