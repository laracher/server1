package com.application.bank.server.repository;

import com.application.bank.server.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskGroupHistoryChangeReposotory extends JpaRepository<Client, Long> {
}
