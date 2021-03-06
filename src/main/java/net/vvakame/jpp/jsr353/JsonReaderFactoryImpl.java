package net.vvakame.jpp.jsr353;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import javax.json.JsonReader;
import javax.json.JsonReaderFactory;

/**
 * Implementation for {@link JsonReaderFactory}.
 * @author vvakame
 */
public class JsonReaderFactoryImpl implements JsonReaderFactory {

	final Map<String, ?> config;


	/**
	 * the constructor.
	 * @param config
	 * @category constructor
	 */
	public JsonReaderFactoryImpl(Map<String, ?> config) {
		if (config != null) {
			this.config = Collections.unmodifiableMap(config);
		} else {
			this.config = Collections.emptyMap();
		}
	}

	@Override
	public JsonReader createReader(Reader reader) {
		return new JsonReaderImpl(reader);
	}

	@Override
	public JsonReader createReader(InputStream in) {
		InputStreamReader reader = new InputStreamReader(in);
		return new JsonReaderImpl(reader);
	}

	@Override
	public JsonReader createReader(InputStream in, Charset charset) {
		InputStreamReader reader = new InputStreamReader(in, charset);
		return new JsonReaderImpl(reader);
	}

	@Override
	public Map<String, ?> getConfigInUse() {
		return config;
	}
}
