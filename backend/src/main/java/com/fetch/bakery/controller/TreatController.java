package com.fetch.bakery.controller;

import com.fetch.bakery.dto.domains.Treat;
import com.fetch.bakery.dto.requests.ComputeTreats;
import com.fetch.bakery.dto.requests.PostTreat;
import com.fetch.bakery.service.TreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("treats")
@RestController
public class TreatController {

    private final TreatService treatService;

    @Autowired
    public TreatController(TreatService treatService) {
        this.treatService = treatService;
    }

    @GetMapping("")
    public List<Treat> getTreats() {
        return treatService.getTreats();
    }

    @GetMapping("/{id}")
    public Treat getTreatById(@PathVariable int id) {
        return treatService.getTreatById(id);
    }

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void postTreats(@RequestBody PostTreat postTreat) {
        // TODO input validation

        treatService.postTreats(postTreat.getTreats());
    }

    @PostMapping("/compute") @ResponseBody
    public double postCompute(@RequestBody ComputeTreats computeTreats) {
        return treatService.postCompute(computeTreats.getProductsAndCounts(), computeTreats.getSales());
    }
}
