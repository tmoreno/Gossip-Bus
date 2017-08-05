package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.List;

public class GossipBus {

	private static final int MAX_STOPS_IN_A_WORKING_DAY = 480;

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
			int numStops = 1;

			while (numStops <= MAX_STOPS_IN_A_WORKING_DAY) {
				shareGossips();

				if (driversKnowAllGossips()) {
					break;
				}
				else {
					moveDriversToNextStop();
					numStops++;
				}
			}

			return formatResult(numStops);
		}
	}

	private void shareGossips() {
		Driver driver1;
		Driver driver2;

		for (int i = 0; i < drivers.size(); i++) {
			for (int j = i + 1; j < drivers.size(); j++) {
				driver1 = drivers.get(i);
				driver2 = drivers.get(j);

				if (driver1.getStop() == driver2.getStop()) {
					driver1.shareGossips(driver2);
				}

			}

		}
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

	private String formatResult(int numStops) {
		if (numStops > MAX_STOPS_IN_A_WORKING_DAY) {
			return "never";
		}
		else {
			return numStops + "";
		}
	}

}
