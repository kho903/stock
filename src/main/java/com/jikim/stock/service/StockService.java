package com.jikim.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jikim.stock.domain.Stock;
import com.jikim.stock.repository.StockRepository;

@Service
public class StockService {

	private StockRepository stockRepository;

	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	// @Transactional
	public synchronized void decrease(Long id, Long quantity) {
		Stock stock = stockRepository.findById(id).orElseThrow();
		stock.decrease(quantity);

		stockRepository.saveAndFlush(stock);
	}
}
