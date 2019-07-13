package com.paxcel.assignment.dto;

/**
 * 
 * @author AswinCizeet
 *
 */
public class RoundedUp {
	private double value;
	private long afterRounding;
	private double difference;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public long getAfterRounding() {
		return afterRounding;
	}

	public void setAfterRounding(long afterRounding) {
		this.afterRounding = afterRounding;
	}

	public double getDifference() {
		return difference;
	}

	public void setDifference(double difference) {
		this.difference = difference;
	}

	@Override
	public String toString() {
		return "roundedUp [value=" + value + ", afterRounding=" + afterRounding + ", difference=" + difference + "]";
	}

}
