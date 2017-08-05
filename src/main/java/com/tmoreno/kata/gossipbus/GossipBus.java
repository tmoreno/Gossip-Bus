package com.tmoreno.kata.gossipbus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GossipBus {

	private Routes routes;
	private Map<Integer, Set<Integer>> driversGossipsKnowed;

	public GossipBus(Routes routes) {
		this.routes = routes;

		driversGossipsKnowed = new HashMap<>();

		HashSet<Integer> driverGossipsKnowed;
		for (int i = 0; i < routes.size(); i++) {
			driverGossipsKnowed = new HashSet<Integer>();
			driverGossipsKnowed.add(i);

			driversGossipsKnowed.put(i, driverGossipsKnowed);
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
					shareGossips(i, j);

					if (driversKnowAllGossips()) {
						return numStops;
					}
				}
			}

			numStops++;
		}

		return numStops;
	}

	private void shareGossips(int i, int j) {
		Set<Integer> sharedGossips = new HashSet<Integer>();
		Set<Integer> driver1Gossips = driversGossipsKnowed.get(i);
		Set<Integer> driver2Gossips = driversGossipsKnowed.get(j);

		sharedGossips.addAll(driver1Gossips);
		sharedGossips.addAll(driver2Gossips);

		driversGossipsKnowed.put(i, sharedGossips);
		driversGossipsKnowed.put(j, sharedGossips);
	}

	private boolean driversKnowAllGossips() {
		int numDriversKnowAllGossips = 0;

		int gossipsNumber = driversGossipsKnowed.size();

		for (Set<Integer> driverGossipsKnowed : driversGossipsKnowed.values()) {
			if (driverGossipsKnowed.size() == gossipsNumber) {
				numDriversKnowAllGossips++;
			}
		}

		return numDriversKnowAllGossips == gossipsNumber;
	}

}
