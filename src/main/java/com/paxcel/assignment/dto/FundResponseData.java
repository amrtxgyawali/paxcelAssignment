package com.paxcel.assignment.dto;

import java.util.List;

import com.paxcel.assignment.dto.RoundedDown;
import com.paxcel.assignment.dto.RoundedUp;

/**
 * POJO class to hold the data to be responded back to the client.
 * 
 * @author AswinCizeet
 *
 */
public class FundResponseData {

	private List<RoundedUp> roundedUp;
	private List<RoundedDown> roundedDown;

	private double remainingFunds;

	public List<RoundedUp> getRoundedUp() {
		return roundedUp;
	}

	public void setRoundedUp(List<RoundedUp> roundedUp) {
		this.roundedUp = roundedUp;
	}

	public List<RoundedDown> getRoundedDown() {
		return roundedDown;
	}

	public void setRoundedDown(List<RoundedDown> roundedDown) {
		this.roundedDown = roundedDown;
	}

	public double getRemainingFunds() {
		return remainingFunds;
	}

	public void setRemainingFunds(double remainingFunds) {
		this.remainingFunds = remainingFunds;
	}

}
