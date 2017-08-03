package com.tmoreno.kata.gossipbus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GossipBus {

	private Routes routes;
	private Map<Integer, Integer> driverGossipsKnowed;

	public GossipBus(Routes routes) {
		this.routes = routes;

		driverGossipsKnowed = new HashMap<Integer, Integer>();
		for (int i = 0; i < routes.size(); i++) {
			driverGossipsKnowed.put(i, 1);
		}
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

			for (int i = 0; i < driversStop.size(); i++) {
				int j = (i + 1) % driversStop.size();

				if (driversStop.get(i).equals(driversStop.get(j))) {
					driverGossipsKnowed.put(i, driverGossipsKnowed.get(i) + 1);
					driverGossipsKnowed.put(j, driverGossipsKnowed.get(j) + 1);

					if (driversKnowAllGossips()) {
						return numStops;
					}
				}
			}

			numStops++;
		}

		return numStops;
	}

	private boolean driversKnowAllGossips() {
		int numDriversKnowAllGossips = 0;

		int gossipsNumber = driverGossipsKnowed.size();

		for (Integer numberGossipsKnowByDriver : driverGossipsKnowed.values()) {
			if (numberGossipsKnowByDriver.intValue() >= gossipsNumber) {
				numDriversKnowAllGossips++;
			}
		}

		return numDriversKnowAllGossips == gossipsNumber;
	}

}
