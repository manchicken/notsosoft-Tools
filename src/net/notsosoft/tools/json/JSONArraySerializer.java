/*
Copyright (c) 2000-2012 Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package net.notsosoft.tools.json;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Sometimes you need to serialize a JSON array, and this allows you to do just
 * that. This is a decorator for JSONArray.
 * 
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 */
public class JSONArraySerializer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1829207470289811525L;
	private transient JSONArray jsonArray;

	/**
	 * Create a serializable JSONArray object
	 * 
	 * @param jsonArray
	 */
	public JSONArraySerializer(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	/**
	 * @return the jsonArray
	 */
	public synchronized JSONArray getJsonArray() {
		return jsonArray;
	}

	/**
	 * @param jsonArray
	 *            the jsonArray to set
	 */
	public synchronized void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	/**
	 * @param oos
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(jsonArray.toString());
	}

	/**
	 * @param ois
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws JSONException
	 */
	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException, JSONException {
		ois.defaultReadObject();
		jsonArray = new JSONArray((String) ois.readObject());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.jsonArray.toString();
	}
}
