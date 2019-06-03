package model;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private String filename = "src/test/java/model/map.txt";
	private BufferedReader buffer;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void loadFileTest() throws IOException {
		buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String line = buffer.readLine();
		assertNotNull("Map is not null", line);
	}

	

	

}
