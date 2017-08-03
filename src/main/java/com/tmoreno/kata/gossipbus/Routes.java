package com.tmoreno.kata.gossipbus;

import java.util.ArrayList;
import java.util.List;

public class Routes {

	private List<Integer[]> routes;

	public Routes() {
		routes = new ArrayList<Integer[]>();
	}

	public void addDriverRoute(Integer[] route) {
		routes.add(route);
	}

	public int size() {
		return routes.size();
	}

	public Integer[] get(int index) {
		return routes.get(index);
	}

}
