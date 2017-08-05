package com.tmoreno.kata.gossipbus;

public class Driver {

	private int[] route;
	private int currentStopPosition;

	public Driver(int[] route) {
		this.route = route;

		currentStopPosition = 0;
	}

	public int getStop() {
		return route[currentStopPosition];
	}

	public void goToNextStop() {
		currentStopPosition = (currentStopPosition + 1) % route.length;
	}

}
