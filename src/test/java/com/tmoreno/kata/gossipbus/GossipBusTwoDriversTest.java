package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusTwoDriversTest {

	private String numStops;
	private Routes routes;
	private GossipBus gossipBus;

	private static final Integer[] MIKE_ROUTE = { 1, 2, 3, 4 };
	private static final Integer[] PETER_ROUTE = { 1, 4, 5, 6 };
	private static final Integer[] BILL_ROUTE = { 2, 3, 6, 4 };
	private static final Integer[] JAMES_ROUTE = { 2, 3, 4, 5, 1 };

	@Before
	public void setUp() {
		routes = new Routes();
	}

	@Test
	public void whenTwoDriversJoinAtFirstStopReturnOne() {
		routes.addDriverRoute(MIKE_ROUTE);
		routes.addDriverRoute(PETER_ROUTE);

		gossipBus = new GossipBus(routes);
		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("1", numStops);
	}

	@Test
	public void whenTwoDriversJoinAtLastStopReturnRouteLength() {
		routes.addDriverRoute(MIKE_ROUTE);
		routes.addDriverRoute(BILL_ROUTE);

		gossipBus = new GossipBus(routes);
		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("4", numStops);
	}

	@Test
	public void whenTwoDriversNeverJoinReturnNever() {
		routes.addDriverRoute(PETER_ROUTE);
		routes.addDriverRoute(BILL_ROUTE);

		gossipBus = new GossipBus(routes);
		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

	@Test
	public void whenTwoDriversJoinAfterALoopLongestRouteLength() {
		routes.addDriverRoute(MIKE_ROUTE);
		routes.addDriverRoute(JAMES_ROUTE);

		gossipBus = new GossipBus(routes);
		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("5", numStops);
	}

}
