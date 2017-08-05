package com.tmoreno.kata.gossipbus;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	private static final int[] route = { 1, 2, 3, 4 };

	private Driver driver;

	@Before
	public void setUp() {
		driver = new Driver("mike", route);
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

	@Test
	public void shareGossips() {
		Driver mike = new Driver("mike", route);
		Driver laura = new Driver("laura", route);
		Driver james = new Driver("james", route);

		mike.shareGossips(laura);
		Assert.assertEquals(gossipsBuilder("mike", "laura"),
				mike.getGossipsKnowed());
		Assert.assertEquals(gossipsBuilder("mike", "laura"),
				laura.getGossipsKnowed());

		james.shareGossips(laura);
		Assert.assertEquals(gossipsBuilder("mike", "laura"),
				mike.getGossipsKnowed());
		Assert.assertEquals(gossipsBuilder("mike", "laura", "james"),
				laura.getGossipsKnowed());
		Assert.assertEquals(gossipsBuilder("mike", "laura", "james"),
				james.getGossipsKnowed());
	}

	private Set<String> gossipsBuilder(String... driverName) {
		Set<String> gossips = new HashSet<String>();

		for (String name : driverName) {
			gossips.add(name);
		}

		return gossips;
	}

}
