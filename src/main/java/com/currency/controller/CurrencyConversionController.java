package com.currency.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.client.CurrencyConversionFeignClient;
import com.currency.entities.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyConversionFeignClient currencyConversionFeignClient;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quentity/{quentity}")
	public CurrencyConversion getCurrencyConversion(@PathVariable("from") String conversionFrom,@PathVariable("to") String conversionTo,@PathVariable("quentity") BigDecimal quentity) {
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("from", conversionFrom);
		requestMap.put("to", conversionTo);
		CurrencyConversion currencyConversion = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class, requestMap).getBody();
		currencyConversion.setQuentity(quentity);
		currencyConversion.setTotalCalculatedAmount(quentity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return currencyConversion;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quentity/{quentity}")
	public CurrencyConversion getCurrencyConversionFeign(@PathVariable("from") String conversionFrom,@PathVariable("to") String conversionTo,@PathVariable("quentity") BigDecimal quentity) {
		CurrencyConversion currencyConversion = currencyConversionFeignClient.getCurrencyConversion(conversionFrom, conversionTo);
		currencyConversion.setQuentity(quentity);
		currencyConversion.setTotalCalculatedAmount(quentity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return currencyConversion;
	}
	
	@GetMapping("/currency-conversion-new/from/{from}/to/{to}/quentity/{quentity}")
	public CurrencyConversion getCurrencyConversionFeignNew(@PathVariable("from") String conversionFrom,@PathVariable("to") String conversionTo,@PathVariable("quentity") BigDecimal quentity) {
		CurrencyConversion currencyConversion = currencyConversionFeignClient.getCurrencyConversion(conversionFrom, conversionTo);
		currencyConversion.setQuentity(quentity);
		currencyConversion.setTotalCalculatedAmount(quentity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return currencyConversion;
	}

}
