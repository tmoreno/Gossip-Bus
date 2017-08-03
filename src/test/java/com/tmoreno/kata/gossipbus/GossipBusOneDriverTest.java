package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusOneDriverTest {

	private String numStops;
	private Routes routes;
	private GossipBus gossipBus;

	private static final Integer[] MIKE_ROUTE = { 1, 2, 3, 4 };

	@Before
	public void setUp() {
		routes = new Routes();
	}

	@Test
	public void whenOneDriverReturnNever() {
		routes.addDriverRoute(MIKE_ROUTE);

		gossipBus = new GossipBus(routes);
		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

}
