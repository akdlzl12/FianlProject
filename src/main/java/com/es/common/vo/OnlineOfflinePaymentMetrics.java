package com.es.common.vo;

public class OnlineOfflinePaymentMetrics {

	private String purchaseType;
	private Integer counts;
	private Integer months;
	
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	
	@Override
	public String toString() {
		return "OnlineOfflinePaymentMetrics [purchaseType=" + purchaseType + ", counts=" + counts + ", months=" + months
				+ "]";
	}
	
}
