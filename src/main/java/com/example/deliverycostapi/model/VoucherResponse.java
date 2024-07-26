package com.example.deliverycostapi.model;

import lombok.Data;

@Data
public class VoucherResponse {
    private double cost;
    private double discount;
    private double finalCost;
    
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getFinalCost() {
		return finalCost;
	}
	public void setFinalCost(double finalCost) {
		this.finalCost = finalCost;
	}  
    
}