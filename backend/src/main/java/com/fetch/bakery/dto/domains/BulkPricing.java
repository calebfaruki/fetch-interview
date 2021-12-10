package com.fetch.bakery.dto.domains;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class BulkPricing implements Serializable {
    int amount;
    double totalPrice;
}
