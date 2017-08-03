package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusNDriversTest {

	private String numStops;
	private Routes routes;
	private GossipBus gossipBus;

	private static final Integer[] MIKE_ROUTE = { 1, 2, 3, 4 };
	private static final Integer[] PETER_ROUTE = { 1, 4, 5, 6 };
	private static final Integer[] BILL_ROUTE = { 2, 3, 6, 4 };
	private static final Integer[] JAMES_ROUTE = { 2, 3, 4, 5, 1 };
	private static final Integer[] COLIN_ROUTES = { 1, 3, 4, 5 };

	@Before
	public void setUp() {
		routes = new Routes();
	}

	@Test
	public void whenAllDriversAreAtFirstStopReturnOne() {
		routes.addDriverRoute(MIKE_ROUTE);
		routes.addDriverRoute(PETER_ROUTE);
		routes.addDriverRoute(COLIN_ROUTES);

		gossipBus = new GossipBus(routes);
		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("1", numStops);
	}
}
