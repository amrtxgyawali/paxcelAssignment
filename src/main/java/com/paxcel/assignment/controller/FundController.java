package com.paxcel.assignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paxcel.assignment.model.Fund;
import com.paxcel.assignment.dto.FundResponseData;
import com.paxcel.assignment.service.FundService;

/**
 * Controller class for Fund.
 * 
 * @author AswinCizeet
 *
 */
@RestController
public class FundController {

	/**
	 * Fund Service.
	 */
	@Autowired
	private FundService fundService;

	/**
	 * Rounds the Fund values given and responds back the Rounded data on HTTP
	 * body.
	 * 
	 * @param fund
	 *            Fund provided for Rounding.
	 * @return {@link ResponseEntity} having the rounded values of Fund in its
	 *         body.
	 */
	@PostMapping("fund/roundOff")
	public ResponseEntity<?> roundFund(@Valid @RequestBody Fund fund) {
		if (fund == null)
			return new ResponseEntity<String>("Please provide fund data", HttpStatus.BAD_REQUEST);
		else {
			FundResponseData fundResponse = fundService.roundFund(fund);
			return new ResponseEntity<FundResponseData>(fundResponse, HttpStatus.OK);
		}

	}
}
