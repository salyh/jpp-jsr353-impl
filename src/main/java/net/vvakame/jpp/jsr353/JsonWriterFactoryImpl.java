package net.vvakame.jpp.jsr353;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;

/**
 * Implementation for {@link JsonWriterFactory}.
 * @author vvakame
 */
public class JsonWriterFactoryImpl implements JsonWriterFactory {

	final Map<String, ?> config;


	/**
	 * the constructor.
	 * @param config
	 * @category constructor
	 */
	public JsonWriterFactoryImpl(Map<String, ?> config) {
		if (config != null) {
			this.config = Collections.unmodifiableMap(config);
		} else {
			this.config = Collections.emptyMap();
		}
	}

	@Override
	public JsonWriter createWriter(Writer writer) {
		return new JsonWriterImpl(writer);
	}

	@Override
	public JsonWriter createWriter(OutputStream out) {
		OutputStreamWriter writer = new OutputStreamWriter(out);
		return new JsonWriterImpl(writer);
	}

	@Override
	public JsonWriter createWriter(OutputStream out, Charset charset) {
		OutputStreamWriter writer = new OutputStreamWriter(out, charset);
		return new JsonWriterImpl(writer);
	}

	@Override
	public Map<String, ?> getConfigInUse() {
		return config;
	}
}
