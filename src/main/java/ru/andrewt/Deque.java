
package ru.andrewt;

/**
 * The {@link Deque} class implements the deque (double-ended queue) data structure.
 * <p>
 * The deque is implemented as a list of chunks containing data items. The deque grows by
 * adding new chunks to the beginning or the end of the list. The head chunk is filled
 * from the end position, the tail is filled from the start position.
 * </p>
 * @param <T> Type of elements stored in the deque.
 *
 * @author Andrei Tatarnikov
 */
public class Deque<T> {

  public static final int CHUNK_SIZE = 16;

  /**
   * The {@link Chunk} class describes the chunk of data stored in the deque.
   *
   * @param <T> T> Type of elements stored in the chunk.
   */
  public static class Chunk<T> {
    protected final T[] items = ArrayUtils.newArray(CHUNK_SIZE);
    protected int pos = -1;
  }

  protected final DoublyLinkedList<Chunk<T>> chunks;
  protected int length;

  public Deque() {
    this.chunks = new DoublyLinkedList<>();
    this.length = 0;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public int getLength() {
    return length;
  }

  public void addFirst(final T value) {

  }

  public T removeFirst() {
    return null;
  }

  public T peekFirst() {
    return null;
  }

  public void addLast(final T value) {

  }

  public T removeLast() {
    return null;
  }

  public T peekLast() {
    return null;
  }

  public T[] toArray() {
    return null;
  }

  @Override
  public String toString() {
    return null;
  }

}
