package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.List;

public class GossipBus {

	private List<Integer[]> routes;

	public GossipBus() {
		routes = new ArrayList<Integer[]>();
	}

	public String calcNumStops() {
		if (routes.size() <= 1) {
			return "never";
		}
		else {
			int numStops = calcStops();

			if (numStops == 0) {
				return "never";
			}
			else {
				return numStops + "";
			}
		}
	}

	private int calcStops() {
		Integer[] routeDriverA = routes.get(0);
		Integer[] routeDriverB = routes.get(1);

		int i = 0;
		for (; i < routeDriverA.length; i++) {
			if (routeDriverA[i].equals(routeDriverB[i])) {
				break;
			}
		}

		if (i < routeDriverA.length) {
			return i + 1;
		}
		else {
			return 0;
		}
	}

	public void addDriverRoute(Integer[] route) {
		routes.add(route);
	}

}
