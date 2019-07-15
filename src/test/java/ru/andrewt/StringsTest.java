
package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the {@link Strings} class.
 *
 * @author Andrei Tatarnikov
 */
public class StringsTest {

  @Test
  public void testNaiveSearch() {
    final String text = "This is a strange test string!";

    Assert.assertEquals(0,  Strings.naiveSearch(text, 0, "This"));
    Assert.assertEquals(2,  Strings.naiveSearch(text, 0, "is"));
    Assert.assertEquals(2,  Strings.naiveSearch(text, -1,"is"));
    Assert.assertEquals(23, Strings.naiveSearch(text, 0, "stri"));
    Assert.assertEquals(26, Strings.naiveSearch(text, 0, "ing!"));

    Assert.assertEquals(5,  Strings.naiveSearch(text, 3, "is"));
    Assert.assertEquals(-1, Strings.naiveSearch(text, text.length() - 1, "ing!"));

    Assert.assertEquals(-1, Strings.naiveSearch("", 3, "is"));
    Assert.assertEquals(0,  Strings.naiveSearch("", 0, ""));
    Assert.assertEquals(5,  Strings.naiveSearch(text, 5, ""));

    Assert.assertEquals(-1, Strings.naiveSearch(text, 0, "ingos"));
  }

}
