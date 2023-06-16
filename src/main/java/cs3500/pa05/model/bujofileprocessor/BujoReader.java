package cs3500.pa05.model.bujofileprocessor;

import cs3500.pa05.model.BujoPage;
import java.nio.file.Path;

/**
 * Represents an interface that can read, process, and extract .bujo files
 */
public interface BujoReader {
  /**
   * Reads, process, and extract a .bujo file into a BujoPage
   *
   * @param location the file path of the .bujo file
   * @return the information within the file as a BujoBoard
   */
  BujoPage readBujoFile(Path location);
}
