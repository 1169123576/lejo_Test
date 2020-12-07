package com.example.service;

import java.math.BigDecimal;

public interface CalculationService {
    /*
     * 可用余额计算
     */
    BigDecimal availableBalance(BigDecimal bondBalance);
    /*
     *账户权益计算
     */
    BigDecimal accountEquity(BigDecimal interests);
}
