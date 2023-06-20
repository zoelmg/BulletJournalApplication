package cs3500.pa05.model.bujofileprocessor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.bujofileprocessor.json.EventJson;
import cs3500.pa05.model.bujofileprocessor.json.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of methods related to the JsonUtil
 */
public class JsonUtilTest {

  /**
   * Test that serialize record is serializing valid records
   * and throwing an exception when an invalid record is thrown
   */
  @Test
  void testSerializeRecord() {
    Record exEventJson = new EventJson("name", "description",
        "start time", "duration");
    assertDoesNotThrow(() -> JsonUtil.serializeRecord(exEventJson));
  }
}
