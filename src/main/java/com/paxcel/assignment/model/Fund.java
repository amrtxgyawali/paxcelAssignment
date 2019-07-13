package com.paxcel.assignment.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * POJO holding the initial fund and fund values.
 * 
 * @author AswinCizeet
 *
 */
public class Fund {

	@Min(value=0, message = "Can not use negative values for initial fund")
	private double initialFund;

	@NotNull(message = "Fund Values are mandatory")
	private double values[];

	public double getInitialFund() {
		return initialFund;
	}

	public void setInitialFund(double initialFund) {
		this.initialFund = initialFund;
	}

	public double[] getValues() {
		return values;
	}

	public void setValues(double[] values) {
		this.values = values;
	}

}
