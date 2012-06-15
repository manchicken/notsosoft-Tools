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

import org.json.JSONObject;
import org.json.JSONException;

/**
 * Sometimes you need to serialize a JSON object, and this allows you to do just
 * that. This is a decorator for JSONObject.
 * 
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 */
public class JSONObjectSerializer implements Serializable {
	private static final long serialVersionUID = 3541407202351077173L;
	private transient JSONObject jsonObject;

	/**
	 * Create a serializable JSONObject object
	 * 
	 * @param jsonObject
	 */
	public JSONObjectSerializer(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	/**
	 * @return the jsonObject
	 */
	public synchronized JSONObject getJsonObject() {
		return jsonObject;
	}

	/**
	 * @param jsonObject
	 *            the jsonObject to set
	 */
	public synchronized void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	/**
	 * @param oos
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(jsonObject.toString());
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
		jsonObject = new JSONObject((String) ois.readObject());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.jsonObject.toString();
	}
}
