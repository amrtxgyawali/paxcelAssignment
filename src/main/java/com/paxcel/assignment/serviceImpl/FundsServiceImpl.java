package com.paxcel.assignment.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paxcel.assignment.dto.FundResponseData;
import com.paxcel.assignment.dto.RoundedDown;
import com.paxcel.assignment.dto.RoundedUp;
import com.paxcel.assignment.model.Fund;
import com.paxcel.assignment.service.FundService;
import com.paxcel.assignment.utils.FundUtils;

/**
 * Class giving defination to Fund Service.
 * 
 * @author AswinCizeet
 *
 */
@Service
public class FundsServiceImpl implements FundService {

	public FundResponseData roundFund(Fund fund) {

		FundResponseData fundResponse = roundOff(fund);

		return fundResponse;
	}

	/**
	 * Rounds of the values in Funds using FundAmount,
	 * 
	 * @param fund
	 * @return
	 */
	private FundResponseData roundOff(Fund fund) {
		FundResponseData fundResponseData = null;

		double[] fundValues = fund.getValues();
		double fundAmount = fund.getInitialFund();
		double difference = 0;
		List<RoundedUp> roundedUp = new ArrayList<>();
		List<RoundedDown> roundedDown = new ArrayList<>();
		FundUtils.sortDoubleUsigDecimalValues(fundValues);

		if (fundValues.length > 0) {
			fundResponseData = new FundResponseData();
			for (int i = 0; i < fundValues.length; i++) {
				{
					double roundedNumber = Math.rint(fundValues[i]);
					difference = fundValues[i] - roundedNumber;
					if ((fundAmount + difference >= 0) && difference < 0) {
						RoundedUp rUp = new RoundedUp();
						rUp.setAfterRounding((long) Math.ceil(fundValues[i]));
						rUp.setDifference(Math.abs(round(difference)));
						rUp.setValue(fundValues[i]);
						roundedUp.add(rUp);
						fundAmount = fundAmount + difference;
					} else {
						RoundedDown rd = new RoundedDown();
						rd.setAfterRounding((long) Math.floor(fundValues[i]));
						rd.setDifference(Math.abs(round(Math.floor(fundValues[i]) - fundValues[i])));
						rd.setValue(fundValues[i]);
						roundedDown.add(rd);
						fundAmount = fundAmount + (fundValues[i] - Math.floor(fundValues[i]));
					}
				}

			}
			fundResponseData.setRemainingFunds(round(fundAmount));
			fundResponseData.setRoundedDown(roundedDown);
			fundResponseData.setRoundedUp(roundedUp);
		}
		return fundResponseData;

	}

	/**
	 * Rounds the values in decimal places to tow decimal places.
	 * 
	 * @param value
	 * @return
	 */
	private double round(double value) {
		return new BigDecimal(Double.toString(value)).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
