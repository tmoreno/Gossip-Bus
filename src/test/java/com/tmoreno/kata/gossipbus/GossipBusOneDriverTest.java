package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipBusOneDriverTest {

	private String numStops;
	private Driver mike;
	private GossipBus gossipBus;

	private static final int[] MIKE_ROUTE = { 1, 2, 3, 4 };

	@Before
	public void setUp() {
		mike = new Driver("mike", MIKE_ROUTE);

		gossipBus = new GossipBus();
	}

	@Test
	public void whenOneDriverReturnNever() {
		gossipBus.addDriver(mike);

		numStops = gossipBus.calcNumStops();

		Assert.assertEquals("never", numStops);
	}

}
