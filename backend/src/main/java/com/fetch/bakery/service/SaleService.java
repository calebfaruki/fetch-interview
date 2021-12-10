package com.fetch.bakery.service;

import com.fetch.bakery.dto.domains.Sale;
import com.fetch.bakery.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(int id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (!sale.isPresent()) {
            throw new HTTPException(400);
        }
        return sale.get();
    }
}
