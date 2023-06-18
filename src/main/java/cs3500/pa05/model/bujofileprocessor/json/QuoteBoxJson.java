package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * the Json data for a quotebox
 *
 * @param quotes the list of quotes in the quote box
 */
public record QuoteBoxJson(@JsonProperty("quotes") List<String> quotes) {
}
