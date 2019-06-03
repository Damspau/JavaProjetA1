

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewTestRun {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private int mapView;
	@SuppressWarnings("unused")
	private int view;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ViewTest() {
	this.setView(mapView);
	assertNotNull("Mapview isn't empty", mapView);
	}

	private void setView(int view) {
		this.view = view;
	}

	

	

	

}
