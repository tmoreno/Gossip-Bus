package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	private static final int[] route = { 1, 2, 3, 4 };

	private Driver driver;

	@Before
	public void setUp() {
		driver = new Driver(route);
	}

	@Test
	public void driverVisitsAllStops() {
		Assert.assertEquals(1, driver.getStop());

		driver.goToNextStop();
		Assert.assertEquals(2, driver.getStop());

		driver.goToNextStop();
		Assert.assertEquals(3, driver.getStop());

		driver.goToNextStop();
		Assert.assertEquals(4, driver.getStop());
	}

	@Test
	public void driverVisitsFirstStopAfterALoop() {
		driver.goToNextStop();
		driver.goToNextStop();
		driver.goToNextStop();
		driver.goToNextStop();

		Assert.assertEquals(1, driver.getStop());
	}

}
