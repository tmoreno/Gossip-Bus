package com.tmoreno.kata.gossipbus;

import org.junit.Assert;
import org.junit.Test;

public class GossipBusTest {

	private static final int[] MIKE_ROUTE = { 1, 2, 3, 4 };

	@Test
	public void whenOneDriverReturnNever() {
		GossipBus gossipBus = new GossipBus();

		String numStops = gossipBus.calcNumStops(MIKE_ROUTE);

		Assert.assertEquals("never", numStops);
	}
}
