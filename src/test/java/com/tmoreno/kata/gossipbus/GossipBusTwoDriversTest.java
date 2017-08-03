package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusTwoDriversTest {

	private GossipBus gossipBus;

	private static final Integer[] MIKE_ROUTE = { 1, 2, 3, 4 };
	private static final Integer[] PETER_ROUTE = { 1, 4, 5, 6 };
	private static final Integer[] BILL_ROUTE = { 2, 3, 6, 4 };
	private static final Integer[] JAMES_ROUTE = { 2, 3, 4, 5, 1 };

	@Before
	public void setUp() {
		gossipBus = new GossipBus();
	}

	@Test
	public void whenTwoDriversJoinAtFirstStopReturnOne() {
		gossipBus.addDriverRoute(MIKE_ROUTE);
		gossipBus.addDriverRoute(PETER_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("1", numStops);
	}

	@Test
	public void whenTwoDriversJoinAtLastStopReturnRouteLength() {
		gossipBus.addDriverRoute(MIKE_ROUTE);
		gossipBus.addDriverRoute(BILL_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("4", numStops);
	}

	@Test
	public void whenTwoDriversNeverJoinReturnNever() {
		gossipBus.addDriverRoute(PETER_ROUTE);
		gossipBus.addDriverRoute(BILL_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

	@Test
	public void whenTwoDriversJoinAfterALoopLongestRouteLength() {
		gossipBus.addDriverRoute(MIKE_ROUTE);
		gossipBus.addDriverRoute(JAMES_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("5", numStops);
	}

}
