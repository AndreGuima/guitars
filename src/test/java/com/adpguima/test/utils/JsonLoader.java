package com.adpguima.test.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

public class JsonLoader {

	private static final String JSON_BASE_PATH = "json/";

	public static String fromPath(final String filepath) throws IOException {
		final Resource jsonFileResource = new ClassPathResource(JSON_BASE_PATH + filepath + ".json");
		return StreamUtils.copyToString(jsonFileResource.getInputStream(), Charset.defaultCharset());
	}
}