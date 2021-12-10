package com.fetch.bakery.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fetch.bakery.dto.domains.BulkPricing;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class BulkPricingConverter implements AttributeConverter<BulkPricing, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BulkPricing bulkPricing) {
        try {
            return objectMapper.writeValueAsString(bulkPricing);
        } catch (IOException e) {
            ;
        }
        return "";
    }

    @Override
    public BulkPricing convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, BulkPricing.class);
        } catch (IOException e) {
            ;
        }
        return null;
    }
}
