package com.example.deliverycostapi.service;

import com.example.deliverycostapi.model.Parcel;
import com.example.deliverycostapi.model.VoucherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DeliveryCostService {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DeliveryCostService.class);

    @Autowired
    private RestTemplate restTemplate;

    private static final String VOUCHER_API_URL = "https://mynt-exam.mocklab.io/voucher/";
    private static final String API_KEY = "apikey";

    public double calculateCost(Parcel parcel) {
        log.info("Calculating delivery cost for parcel: {}", parcel);

        double weight = parcel.getWeight();
        double volume = parcel.getHeight() * parcel.getWidth() * parcel.getLength();
        double cost;

        if (weight > 50) {
            log.error("Parcel weight exceeds the limit of 50kg.");
            throw new IllegalArgumentException("Parcel weight exceeds the limit of 50kg.");
        } else if (weight > 10) {
            cost = 20 * weight;
        } else if (volume < 1500) {
            cost = 0.03 * volume;
        } else if (volume < 2500) {
            cost = 0.04 * volume;
        } else {
            cost = 0.05 * volume;
        }

        if (parcel.getVoucherCode() != null && !parcel.getVoucherCode().isEmpty()) {
            cost -= applyVoucherDiscount(parcel.getVoucherCode(), cost);
        }

        log.info("Calculated cost: {}", cost);
        return cost;
    }

    private double applyVoucherDiscount(String voucherCode, double cost) {
        try {
            String url = VOUCHER_API_URL + voucherCode + "?key=" + API_KEY;
            VoucherResponse response = restTemplate.getForObject(url, VoucherResponse.class);
            if (response != null && response.getDiscount() > 0) {
                log.info("Applying voucher discount: {}%", response.getDiscount());
                return cost * (response.getDiscount() / 100.0);
            }
        } catch (Exception e) {
            log.error("Failed to apply voucher discount", e);
        }
        return 0;
    }
}