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
		/**
		 * synchronized는 자바의 프로세스가 한 개 일때에만 보장.
		 * 따라서 서버가 여러 대일 경우 보장할 수 없음.
		 */
		Stock stock = stockRepository.findById(id).orElseThrow();
		stock.decrease(quantity);

		stockRepository.saveAndFlush(stock);
	}
}
