package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.List;

public class GossipBus {

	private List<Integer []> routes;
	
	public GossipBus() {
		routes = new ArrayList<Integer[]>();
	}
	
	public String calcNumStops() {
		return "never";
	}

	public void addDriverRoute(Integer[] route) {
		routes.add(route);
	}

}
