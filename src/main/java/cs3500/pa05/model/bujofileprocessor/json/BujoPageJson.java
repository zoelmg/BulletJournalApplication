package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record BujoPageJson(@JsonProperty("Week") List<DayJson> week,
                           @JsonProperty("Week-Name") String weekName,
                           @JsonProperty("quotebox") QuoteBoxJson quotebox,
                           @JsonProperty("notebox") NoteBoxJson notebox) {

}
