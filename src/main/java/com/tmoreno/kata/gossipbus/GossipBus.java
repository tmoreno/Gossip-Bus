package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GossipBus {

	private List<Driver> drivers;
	private Map<Integer, Set<Integer>> driversGossipsKnowed;

	public GossipBus() {
		drivers = new ArrayList<Driver>();

		driversGossipsKnowed = new HashMap<>();
	}

	public void addDriver(Driver driver) {
		drivers.add(driver);

		Set<Integer> driverGossipsKnowed = new HashSet<Integer>();
		driverGossipsKnowed.add(drivers.size() - 1);

		driversGossipsKnowed.put(drivers.size() - 1, driverGossipsKnowed);
	}

	public String calcNumStops() {
		if (drivers.size() <= 1) {
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
		int numStops = 1;

		while (numStops <= 480) {
			moveDriversToNextStop();

			for (int i = 0; i < drivers.size(); i++) {
				int j = (i + 1) % drivers.size();

				if (drivers.get(i).getStop() == drivers.get(j).getStop()) {
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

	private void moveDriversToNextStop() {
		for (Driver driver : drivers) {
			driver.goToNextStop();
		}
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
