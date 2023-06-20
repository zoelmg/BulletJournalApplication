package cs3500.pa05.model.bujofileprocessor;

import java.io.IOException;

/**
 * Mock Appendable to test BujoWriterImp
 */
public class MockAppendable implements Appendable{
  /**
   * throws an error always
   *
   * @param csq The character sequence to append.  If {@code csq} is
   *            {@code null}, then the four characters {@code "null"} are
   *            appended to this Appendable.
   * @return an expected error
   * @throws IOException an expected error
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Mock Appendable throwing errors");
  }

  /**
   * always throw an expected error
   *
   * @param csq   The character sequence from which a subsequence will be
   *              appended.  If {@code csq} is {@code null}, then characters
   *              will be appended as if {@code csq} contained the four
   *              characters {@code "null"}.
   * @param start The index of the first character in the subsequence
   * @param end   The index of the character following the last character in the
   *              subsequence
   * @return an expected error
   * @throws IOException an expected error
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Mock Appendable throwing errors");
  }

  /**
   * always throw an expected error
   *
   * @param c The character to append
   * @return an expected error
   * @throws IOException an expected error
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Mock Appendable throwing errors");
  }
}
