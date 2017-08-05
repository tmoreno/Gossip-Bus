package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusTwoDriversTest {

	private String numStops;
	private Driver mike;
	private Driver peter;
	private Driver bill;
	private Driver james;
	private GossipBus gossipBus;

	private static final int[] MIKE_ROUTE = { 1, 2, 3, 4 };
	private static final int[] PETER_ROUTE = { 1, 4, 5, 6 };
	private static final int[] BILL_ROUTE = { 2, 3, 6, 4 };
	private static final int[] JAMES_ROUTE = { 2, 3, 4, 5, 1 };

	@Before
	public void setUp() {
		mike = new Driver(MIKE_ROUTE);
		peter = new Driver(PETER_ROUTE);
		bill = new Driver(BILL_ROUTE);
		james = new Driver(JAMES_ROUTE);

		gossipBus = new GossipBus();
	}

	@Test
	public void whenTwoDriversJoinAtFirstStopReturnOne() {
		gossipBus.addDriver(mike);
		gossipBus.addDriver(peter);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("1", numStops);
	}

	@Test
	public void whenTwoDriversJoinAtLastStopReturnRouteLength() {
		gossipBus.addDriver(mike);
		gossipBus.addDriver(bill);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("4", numStops);
	}

	@Test
	public void whenTwoDriversNeverJoinReturnNever() {
		gossipBus.addDriver(peter);
		gossipBus.addDriver(bill);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

	@Test
	public void whenTwoDriversJoinAfterALoopLongestRouteLength() {
		gossipBus.addDriver(mike);
		gossipBus.addDriver(james);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("5", numStops);
	}

	@Test
	public void kataExample2() {
		int[] driver1Route = { 2, 1, 2 };
		Driver driver1 = new Driver(driver1Route);

		int[] driver2Route = { 5, 2, 8 };
		Driver driver2 = new Driver(driver2Route);

		gossipBus.addDriver(driver1);
		gossipBus.addDriver(driver2);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

}
