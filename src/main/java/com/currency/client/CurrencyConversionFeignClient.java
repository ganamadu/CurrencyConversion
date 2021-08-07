package com.currency.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.entities.CurrencyConversion;

@FeignClient(name = "currency-exchange")
public interface CurrencyConversionFeignClient {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion getCurrencyConversion(@PathVariable("from") String conversionFrom,@PathVariable("to") String conversionTo);

}
