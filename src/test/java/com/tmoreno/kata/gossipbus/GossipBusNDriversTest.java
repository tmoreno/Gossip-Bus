package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusNDriversTest {

	private String numStops;
	private Driver mike;
	private Driver peter;
	private Driver bill;
	private Driver james;
	private Driver colin;
	private Driver laura;
	private GossipBus gossipBus;

	private static final int[] MIKE_ROUTE = { 1, 2, 3, 4 };
	private static final int[] PETER_ROUTE = { 1, 4, 5, 6 };
	private static final int[] BILL_ROUTE = { 2, 3, 6, 4 };
	private static final int[] JAMES_ROUTE = { 2, 3, 4, 5, 1 };
	private static final int[] COLIN_ROUTES = { 1, 3, 4, 5 };
	private static final int[] LAURA_ROUTES = { 3, 2, 1, 4 };

	@Before
	public void setUp() {
		mike = new Driver("mike", MIKE_ROUTE);
		peter = new Driver("peter", PETER_ROUTE);
		bill = new Driver("bill", BILL_ROUTE);
		james = new Driver("james", JAMES_ROUTE);
		colin = new Driver("colin", COLIN_ROUTES);
		laura = new Driver("laura", LAURA_ROUTES);

		gossipBus = new GossipBus();
	}

	@Test
	public void whenAllDriversAreAtFirstStopReturnOne() {
		gossipBus.addDriver(mike);
		gossipBus.addDriver(peter);
		gossipBus.addDriver(colin);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("1", numStops);
	}

	@Test
	public void whenAllDriversAreAtLastStopReturnRouteLength() {
		gossipBus.addDriver(mike);
		gossipBus.addDriver(bill);
		gossipBus.addDriver(laura);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("4", numStops);
	}

	@Test
	public void whenDriversJoinAfterALoopLongestRouteLength() {
		gossipBus.addDriver(mike);
		gossipBus.addDriver(peter);
		gossipBus.addDriver(james);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("5", numStops);
	}

	@Test
	public void kataExample1() {
		gossipBus.addDriver(createDriver("driver1", 3, 1, 2, 3));
		gossipBus.addDriver(createDriver("driver2", 3, 2, 3, 1));
		gossipBus.addDriver(createDriver("driver3", 4, 2, 3, 4, 5));

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("5", numStops);
	}

	@Test
	public void kataExample2() {
		gossipBus.addDriver(createDriver("driver1", 7, 11, 2, 2, 4, 8, 2, 2));
		gossipBus.addDriver(createDriver("driver2", 3, 0, 11, 8));
		gossipBus.addDriver(createDriver("driver3", 5, 11, 8, 10, 3, 11));
		gossipBus.addDriver(createDriver("driver4", 5, 9, 2, 5, 0, 3));
		gossipBus.addDriver(createDriver("driver5", 7, 4, 8, 2, 8, 1, 0, 5));
		gossipBus.addDriver(createDriver("driver6", 3, 6, 8, 9));
		gossipBus.addDriver(createDriver("driver7", 4, 2, 11, 3, 3));

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("9", numStops);
	}

	private Driver createDriver(String name, int... route) {
		return new Driver(name, route);
	}
}
