package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Routes {

	private Map<Integer, Integer> driversPosition;
	private List<Integer[]> routes;

	public Routes() {
		routes = new ArrayList<Integer[]>();
		driversPosition = new HashMap<Integer, Integer>();
	}

	public void addDriverRoute(Integer[] route) {
		routes.add(route);

		driversPosition.put(routes.size() - 1, 0);
	}

	public int size() {
		return routes.size();
	}

	public List<Integer> nextDriversStop() {
		List<Integer> driversStop = new ArrayList<Integer>();

		for (int driver = 0; driver < routes.size(); driver++) {
			Integer[] driverRoute = routes.get(driver);
			Integer driverPosition = driversPosition.get(driver);
			Integer driverStop = driverRoute[driverPosition];

			driversStop.add(driverStop);

			driverPosition = (driverPosition + 1) % driverRoute.length;
			driversPosition.put(driver, driverPosition);
		}

		return driversStop;
	}

}
