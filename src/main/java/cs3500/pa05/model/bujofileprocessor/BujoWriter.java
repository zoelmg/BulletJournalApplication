package cs3500.pa05.model.bujofileprocessor;

import cs3500.pa05.model.BujoPage;
import java.nio.file.Path;

/**
 * Represents an interface that can process, extract, and write into .bujo files
 */
public interface BujoWriter {

  /**
   * Given the bujo page containing all information and the output .bujo file path,
   * write the bujo page info onto the .bujo file
   *
   * @param bujoPage the bujo page containing all information that will be stored in .bujo file
   */
  void writeBujoFile(BujoPage bujoPage);
}
