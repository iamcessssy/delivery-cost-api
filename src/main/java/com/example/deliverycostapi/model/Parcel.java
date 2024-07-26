package com.example.deliverycostapi.model;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class Parcel {
    @NotNull(message = "Weight is required")
    @Min(value = 0, message = "Weight must be greater than or equal to 0")
    private Double weight;

    @NotNull(message = "Height is required")
    @Min(value = 1, message = "Height must be greater than or equal to 1")
    private Double height;

    @NotNull(message = "Width is required")
    @Min(value = 1, message = "Width must be greater than or equal to 1")
    private Double width;

    @NotNull(message = "Length is required")
    @Min(value = 1, message = "Length must be greater than or equal to 1")
    private Double length;

    private String voucherCode;

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
    
    
}
