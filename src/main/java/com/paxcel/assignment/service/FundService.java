package com.paxcel.assignment.service;

import org.springframework.stereotype.Service;

import com.paxcel.assignment.dto.FundResponseData;
import com.paxcel.assignment.model.Fund;

/**
 * Interface that will be exposed in API.
 * 
 * @author AswinCizeet
 *
 */
@Service
public interface FundService {

	public FundResponseData roundFund(Fund fund);

	
}
