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
		int[] driver1Route = { 3, 1, 2, 3 };
		Driver driver1 = new Driver("driver1", driver1Route);
		gossipBus.addDriver(driver1);

		int[] driver2Route = { 3, 2, 3, 1 };
		Driver driver2 = new Driver("driver2", driver2Route);
		gossipBus.addDriver(driver2);

		int[] driver3Route = { 4, 2, 3, 4, 5 };
		Driver driver3 = new Driver("driver3", driver3Route);
		gossipBus.addDriver(driver3);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("5", numStops);
	}

	@Test
	public void kataExample2() {
		int[] driver1Route = { 7, 11, 2, 2, 4, 8, 2, 2 };
		Driver driver1 = new Driver("driver1", driver1Route);
		gossipBus.addDriver(driver1);

		int[] driver2Route = { 3, 0, 11, 8 };
		Driver driver2 = new Driver("driver2", driver2Route);
		gossipBus.addDriver(driver2);

		int[] driver3Route = { 5, 11, 8, 10, 3, 11 };
		Driver driver3 = new Driver("driver3", driver3Route);
		gossipBus.addDriver(driver3);

		int[] driver4Route = { 5, 9, 2, 5, 0, 3 };
		Driver driver4 = new Driver("driver4", driver4Route);
		gossipBus.addDriver(driver4);

		int[] driver5Route = { 7, 4, 8, 2, 8, 1, 0, 5 };
		Driver driver5 = new Driver("driver5", driver5Route);
		gossipBus.addDriver(driver5);

		int[] driver6Route = { 3, 6, 8, 9 };
		Driver driver6 = new Driver("driver6", driver6Route);
		gossipBus.addDriver(driver6);

		int[] driver7Route = { 4, 2, 11, 3, 3 };
		Driver driver7 = new Driver("driver7", driver7Route);
		gossipBus.addDriver(driver7);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("9", numStops);
	}
}
