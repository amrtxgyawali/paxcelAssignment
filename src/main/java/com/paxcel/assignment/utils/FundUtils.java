package com.paxcel.assignment.utils;

/**
 * Utility Class having utility methods.
 * 
 * @author AswinCizeet
 *
 */
public class FundUtils {

	/**
	 * Sorts the values in array on the basis of values in decimal places.
	 * 
	 * @param fundValues,
	 *            containing fund values.
	 */
	public static void sortDoubleUsigDecimalValues(double[] fundValues) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		double temp;
		for (int i = 0; i < fundValues.length; i++) {
			for (int j = i + 1; j < fundValues.length; j++) {
				sb.delete(0, sb.length());
				sb1.delete(0, sb1.length());
				sb.append(String.valueOf(fundValues[i]));
				sb1.append(String.valueOf(fundValues[j]));
				if (Double.parseDouble(sb.substring(sb.indexOf("."))) > Double
						.parseDouble(sb1.substring(sb1.indexOf(".")))) {
					temp = fundValues[i];
					fundValues[i] = fundValues[j];
					fundValues[j] = temp;

				}

			}

		}
	}
}
