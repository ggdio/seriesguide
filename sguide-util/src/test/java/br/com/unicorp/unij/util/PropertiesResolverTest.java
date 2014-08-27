package br.com.unicorp.unij.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import br.com.devteam.sguide.util.PropertiesResolver;

public class PropertiesResolverTest {
	
	private String resource;
	private Properties properties;
	private File file;
	
	@Before
	public void setUp() throws Exception {
		resource = "test";
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("test.properties");
		properties = new Properties();
		properties.load(is);
		file = new File(this.getClass().getClassLoader().getResource("test.properties").toURI());
	}

	@Test
	public void testPropertiesResolverString() {
		PropertiesResolver presolver = new PropertiesResolver(resource);
		assertEquals("expectedA", presolver.getProperty("testA"));
		assertEquals("expectedB", presolver.getProperty("testB"));
	}

	@Test
	public void testPropertiesResolverFile() {
		PropertiesResolver presolver = new PropertiesResolver(file);
		assertEquals("expectedA", presolver.getProperty("testA"));
		assertEquals("expectedB", presolver.getProperty("testB"));
	}

	@Test
	public void testPropertiesResolverProperties() {
		PropertiesResolver presolver = new PropertiesResolver(properties);
		assertEquals("expectedA", presolver.getProperty("testA"));
		assertEquals("expectedB", presolver.getProperty("testB"));
	}

	@Test
	public void testGetPropertyString() {
		PropertiesResolver presolver = new PropertiesResolver(properties);
		assertEquals("expectedA", presolver.getProperty("testA"));
	}

	@Test
	public void testGetPropertyStringStringArray() {
		PropertiesResolver presolver = new PropertiesResolver(resource);
		String paramC = "expectedC";
		assertEquals("expectedC", presolver.getProperty("testC", paramC));
		String expression = presolver.getProperty("testD", "25", "5", "1");
		Integer result = 0;
		for(String value : expression.split("\\+"))
			result += Integer.parseInt(value);
		System.out.println(result);
	}

	@Test
	public void testGetProperties() {
		PropertiesResolver presolver = new PropertiesResolver(properties);
		Properties properties = presolver.getProperties();
		assertTrue(properties.size() == 4);
	}

}