package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskJson(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("completed") boolean isCompleted) {
}
