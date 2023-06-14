package com.jikim.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jikim.stock.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
