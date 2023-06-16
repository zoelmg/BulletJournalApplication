package cs3500.pa05;

import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.bujofileprocessor.BujoWriterImp;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {
  BujoWriterImp bujoWriterImp;
  Appendable output;
  BujoPageImp bujoPageImp;


  @BeforeEach
  void setup(){
    output = new StringWriter();
    bujoWriterImp = new BujoWriterImp(output);
    bujoPageImp = new BujoPageImp();

  }

  @Test
  void testWriteBujoFile(){
    bujoWriterImp.writeBujoFile(bujoPageImp);
    System.out.println(output.toString());
  }


}
