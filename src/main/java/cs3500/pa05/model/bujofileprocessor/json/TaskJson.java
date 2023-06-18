package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Json data for a task
 *
 * @param name        the name of the task
 * @param description the description for a task
 * @param isCompleted if the task is completed
 */
public record TaskJson(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("completed") boolean isCompleted) {
}
