package com.fetch.bakery.repository;

import com.fetch.bakery.dto.domains.Treat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatRepository extends JpaRepository<Treat, Integer> {
}
