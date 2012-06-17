package net.notsosoft.tools.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * An interface to let us know that we will always be able to fetch JSON.
 * 
 * @author Michael D. Stemle, Jr. (Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 */
public interface JSONable {	
	/**
	 * Convert the object to a {@link JSONObject} for transmission, display, or other serialization
	 * 
	 * @return Returns a {@link JSONObject} representation of the instance.
	 * @throws JSONException If there is an error in constructing the JSON object
	 */
	public JSONObject toJsonObject() throws JSONException;
	
	/**
	 * Populate an instance with values from a {@link JSONObject}.
	 * 
	 * @param source The source object from which to populate the instance.
	 * @throws JSONException If there is an error in the {@link JSONObject} we are interpreting
	 */
	public void fromJsonObject(JSONObject source) throws JSONException;
}
