package com.fetch.bakery.dto.domains;

import com.fetch.bakery.utils.BulkPricingConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "treat", schema = "public")
@Data
public class Treat implements Serializable {

    @Id
    int id;

    String name;

    @Column(name = "image_url")
    String imageURL;

    double price;

    @Convert(converter = BulkPricingConverter.class)
    @Column(columnDefinition = "jsonb")
    BulkPricing bulkPricing;
}
