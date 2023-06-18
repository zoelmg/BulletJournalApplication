package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;

/**
 * Json data for all the elements of BujoPage
 *
 * @param week      all the days in the bujopage
 * @param weekName  the name of the week
 * @param quotebox  the Quotebox
 * @param notebox   the notebox
 * @param maxEvents the maximum number of events for each day
 * @param maxTasks  the maximum number of tasks for each day
 */
public record BujoPageJson(@JsonProperty("Week") List<DayJson> week,
                           @JsonProperty("Week-Name") String weekName,
                           @JsonProperty("quotebox") QuoteBoxJson quotebox,
                           @JsonProperty("notebox") NoteBoxJson notebox,
                           @JsonProperty("maxEvents") int maxEvents,
                           @JsonProperty("maxTasks") int maxTasks) {

}
