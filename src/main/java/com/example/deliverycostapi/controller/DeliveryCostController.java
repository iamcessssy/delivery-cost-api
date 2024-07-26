package com.example.deliverycostapi.controller;

import com.example.deliverycostapi.model.Parcel;
import com.example.deliverycostapi.service.DeliveryCostService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/delivery-cost")
@Validated
public class DeliveryCostController {

    @Autowired
    private DeliveryCostService deliveryCostService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateDeliveryCost(@Valid @RequestBody Parcel parcel) {
        double cost = deliveryCostService.calculateCost(parcel);
        Map<String, Object> response = new HashMap<>();
        response.put("cost", cost);
        return ResponseEntity.ok(response);
    }
}
