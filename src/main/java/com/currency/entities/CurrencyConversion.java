package com.currency.entities;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String conversionFrom;
	private String conversionTo;
	private BigDecimal conversionMultiple;
	private BigDecimal quentity;
	private BigDecimal totalCalculatedAmount;
	private Integer port;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConversionFrom() {
		return conversionFrom;
	}
	public void setConversionFrom(String conversionFrom) {
		this.conversionFrom = conversionFrom;
	}
	public String getConversionTo() {
		return conversionTo;
	}
	public void setConversionTo(String conversionTo) {
		this.conversionTo = conversionTo;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuentity() {
		return quentity;
	}
	public void setQuentity(BigDecimal quentity) {
		this.quentity = quentity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}

}
