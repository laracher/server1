package com.application.bank.server.repository;

import com.application.bank.server.entity.RiskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskGroupRepository extends JpaRepository<RiskGroup, Long> {
}
