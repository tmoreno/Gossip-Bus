package com.tmoreno.kata.gossipbus;


public class GossipBus {

	private Routes routes;

	public GossipBus(Routes routes) {
		this.routes = routes;
	}

	public String calcNumStops() {
		if (routes.size() <= 1) {
			return "never";
		}
		else {
			int numStops = calcStops();

			if (numStops > 480) {
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
		int j = 0;
		int numStops = 1;

		while (numStops <= 480) {
			if (routeDriverA[i].equals(routeDriverB[j])) {
				break;
			}

			i = (i + 1) % routeDriverA.length;
			j = (j + 1) % routeDriverB.length;

			numStops++;
		}

		return numStops;
	}

}
