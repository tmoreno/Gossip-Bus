package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Test;

public class GossipBusTest {

	private static final int[] MIKE_ROUTE = { 1, 2, 3, 4 };
	private static final int[] PETER_ROUTE = { 1, 4, 5, 6 };

	@Test
	public void whenOneDriverReturnNever() {
		GossipBus gossipBus = new GossipBus();

		gossipBus.addDriverRoute(MIKE_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

	@Test
	public void whenTwoDriversSameStart() {
		GossipBus gossipBus = new GossipBus();

		gossipBus.addDriverRoute(MIKE_ROUTE);
		gossipBus.addDriverRoute(PETER_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("1", numStops);
	}
}
