package cs3500.pa05.model.bujofileprocessor;

import cs3500.pa05.model.BujoPage;
import java.nio.file.Path;

/**
 * An implementation of BujoWriter which writes in a .bujo file with given BujoPage
 */
public class BujoWriterImp implements BujoWriter{

  /**
   * Given the bujo page containing all information and the output .bujo file path,
   * write the bujo page info onto the .bujo file
   *
   * @param bujoPage the bujo page containing all information that will be stored in .bujo file
   * @param location the location of the .bujo file
   */
  @Override
  public void writeBujoFile(BujoPage bujoPage, Path location) {

  }
}
