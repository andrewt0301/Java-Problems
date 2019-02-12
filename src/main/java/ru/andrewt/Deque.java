
package ru.andrewt;

/**
 * The {@link Deque} class implements the deque (double-ended queue) data structure.
 * <p>
 * The deque is implemented as a list of chunks containing data items. The deque grows
 * by adding new chunks to the beginning or the end of the list. The head chunk is filled
 * from the tail position, the tail is filled from the head position.
 * </p>
 * @param <T> Type of data items stored in the deque.
 *
 * @author Andrei Tatarnikov
 */
public class Deque<T> {

  /**
   * Size of data chunks (maximum data element count).
   */
  public static final int CHUNK_SIZE = 16;

  /**
   * The {@link Chunk} class describes the chunk of data stored in the deque.
   *
   * @param <U> Type of data items stored in the chunk.
   */
  public static class Chunk<U> {
    protected final U[] items;
    protected int head;
    protected int tail;

    /**
     * Creates a chunk filled starting from the head position towards tail.
     *
     * @param <U> Type of data items stored in the chunk.
     * @return New empty chunk.
     */
    public static <U> Chunk<U> newHead() {
      return new Chunk<>(CHUNK_SIZE, CHUNK_SIZE - 1);
    }

    /**
     * Creates a chunk filled starting from the tail position towards head.
     *
     * @param <U> Type of data items stored in the chunk.
     * @return New empty chunk.
     */
    public static <U> Chunk<U> newTail() {
      return new Chunk<>(CHUNK_SIZE, 0);
    }

    /**
     * Creates a chunk filled starting from the middle position both towards head and tail.
     *
     * @param <U> Type of data items stored in the chunk.
     * @return New empty chunk.
     */
    public static <U> Chunk<U> newMiddle() {
      return new Chunk<>(CHUNK_SIZE, CHUNK_SIZE / 2);
    }

    /**
     * Constructs a new chunk.
     *
     * @param size Size of the chunk.
     * @param pos Starting position from which the chunk is filled.
     */
    public Chunk(final int size, final int pos) {

      if (pos <= 0) {
        throw new IllegalArgumentException();
      }

      if (!(0 <= pos && pos <= size)) {
        throw new IllegalArgumentException();
      }

      this.items = ArrayUtils.newArray(size);
      this.head = pos;
      this.tail = pos;
    }
  }

  protected final DoublyLinkedList<Chunk<T>> chunks;
  protected int length;

  public Deque() {
    this.chunks = new DoublyLinkedList<>();
    this.chunks.add(Chunk.newMiddle());
    this.length = 0;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public int getLength() {
    return length;
  }

  public void addFirst(final T value) {
    Chunk<T> chunk = chunks.getFirst();
    if (chunk.head < 0) {
      chunk = Chunk.newTail();
      chunks.insertAt(0, chunk);
    }

    chunk.items[chunk.head--] = value;
    length++;
  }

  public T removeFirst() {
    return null;
  }

  public T peekFirst() {
    return null;
  }

  public void addLast(final T value) {
    Chunk<T> chunk = chunks.getLast();
    /*
    if (chunk.posisOutOfBounds()) {
      chunk = Chunk.newHead();
      chunks.insertAt(chunks.getLength() - 1, chunk);
    }
    */

    chunk.items[chunk.tail++] = value;
    length++;
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
