package com.fetch.bakery.service;

import com.fetch.bakery.dto.domains.Sale;
import com.fetch.bakery.dto.domains.Treat;
import com.fetch.bakery.repository.SaleRepository;
import com.fetch.bakery.repository.TreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreatService {

    private final TreatRepository treatRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public TreatService(TreatRepository treatRepository, SaleRepository saleRepository) {
        this.treatRepository = treatRepository;
        this.saleRepository = saleRepository;
    }

    public List<Treat> getTreats() {
        return treatRepository.findAll();
    }

    public Treat getTreatById(int id) {
        Optional<Treat> treat = treatRepository.findById(id);
        if (!treat.isPresent()) {
            throw new HTTPException(400);
        }
        return treat.get();
    }

    @Transactional
    public void postTreats(List<Treat> treats) {
        treatRepository.saveAll(treats);
    }

    public double postCompute(Map<String, Integer> productsAndCounts, Sale sale) {
        double totalPrice = 0;

        if (sale != null) {
            sale = saleRepository.findAll(Example.of(sale, ExampleMatcher.matching().withIgnoreNullValues())).get(0);
        }

        List<Treat> treats = treatRepository.findAll();
        for (Map.Entry<String, Integer> productAndCount : productsAndCounts.entrySet()) {
            String product = productAndCount.getKey();
            int count = productAndCount.getValue();

            Treat treat = treats.stream().filter(t -> t.getName().equals(product)).collect(Collectors.toList()).get(0);
            while (count > 0) {
                if (sale != null && sale.getTreatId() == treat.getId() && count >= sale.getCount()) {
                    // apply sales
                    totalPrice += sale.getPrice();
                    count -= sale.getCount();
                } else if (treat.getBulkPricing() != null && count >= treat.getBulkPricing().getAmount()) {
                    // apply bulk discount
                    totalPrice += treat.getBulkPricing().getTotalPrice();
                    count -= treat.getBulkPricing().getAmount();
                } else {
                    totalPrice += treat.getPrice();
                    count -= 1;
                }
            }
        }
        return totalPrice;
    }
}
