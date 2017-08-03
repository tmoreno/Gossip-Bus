package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusOneDriverTest {

	private GossipBus gossipBus;

	private static final Integer[] MIKE_ROUTE = { 1, 2, 3, 4 };

	@Before
	public void setUp() {
		gossipBus = new GossipBus();
	}

	@Test
	public void whenOneDriverReturnNever() {
		gossipBus.addDriverRoute(MIKE_ROUTE);

		String numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

}
