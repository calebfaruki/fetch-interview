package com.fetch.bakery.dto.requests;

import com.fetch.bakery.dto.domains.Sale;
import lombok.Getter;

import java.util.Map;

@Getter
public class ComputeTreats {
    Sale sales;
    Map<String, Integer> productsAndCounts;
}
