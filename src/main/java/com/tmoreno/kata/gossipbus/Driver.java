package com.tmoreno.kata.gossipbus;

import java.util.HashSet;
import java.util.Set;

public class Driver {

	private String name;
	private int[] route;
	private int currentStopPosition;
	private Set<String> gossipsKnowed;

	public Driver(int[] route) {
		this.route = route;

		currentStopPosition = 0;
	}

	public Driver(String name, int[] route) {
		this.name = name;
		this.route = route;

		currentStopPosition = 0;

		gossipsKnowed = new HashSet<String>();
		gossipsKnowed.add(name);
	}

	public int getStop() {
		return route[currentStopPosition];
	}

	public void goToNextStop() {
		currentStopPosition = (currentStopPosition + 1) % route.length;
	}

	public void shareGossips(Driver otherDriver) {
		Set<String> sharedGossips = new HashSet<String>();

		sharedGossips.addAll(this.gossipsKnowed);
		sharedGossips.addAll(otherDriver.gossipsKnowed);

		this.gossipsKnowed = sharedGossips;
		otherDriver.gossipsKnowed = sharedGossips;
	}

	public Set<String> getGossipsKnowed() {
		return gossipsKnowed;
	}

}
