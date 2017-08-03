package com.tmoreno.kata.gossipbus;

import java.util.List;

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
		List<Integer> driversStop;

		int numStops = 1;

		while (numStops <= 480) {
			driversStop = routes.nextDriversStop();

			if (driversStop.get(0).equals(driversStop.get(1))) {
				break;
			}

			numStops++;
		}

		return numStops;
	}

}
