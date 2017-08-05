package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.List;

public class GossipBus {

	private List<Driver> drivers;

	public GossipBus() {
		drivers = new ArrayList<Driver>();
	}

	public void addDriver(Driver driver) {
		drivers.add(driver);
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
			for (int i = 0; i < drivers.size(); i++) {
				int j = (i + 1) % drivers.size();

				if (drivers.get(i).getStop() == drivers.get(j).getStop()) {
					drivers.get(i).shareGossips(drivers.get(j));

					if (driversKnowAllGossips()) {
						return numStops;
					}
				}
			}

			moveDriversToNextStop();

			numStops++;
		}

		return numStops;
	}

	private void moveDriversToNextStop() {
		for (Driver driver : drivers) {
			driver.goToNextStop();
		}
	}

	private boolean driversKnowAllGossips() {
		int numDriversKnowAllGossips = 0;

		int gossipsNumber = drivers.size();

		for (Driver driver : drivers) {
			if (driver.getGossipsKnowed().size() == gossipsNumber) {
				numDriversKnowAllGossips++;
			}
		}

		return numDriversKnowAllGossips == gossipsNumber;
	}

}
