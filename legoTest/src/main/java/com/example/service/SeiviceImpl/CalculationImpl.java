package com.example.service.SeiviceImpl;

import com.example.lepojo.ContractVarieties;
import com.example.service.CalculationService;

import java.math.BigDecimal;

public class CalculationImpl implements CalculationService {
    /*
     * 可用余额计算
     */
    @Override
    public BigDecimal availableBalance(BigDecimal bondBalance) {

        return bondBalance;
    }
    /*
     *账户权益计算
     */
    @Override
    public BigDecimal accountEquity(BigDecimal interests) {
        ContractVarieties contractVarieties= new ContractVarieties();
        //totalProfit
        interests=contractVarieties.getTotalProfit();
        return interests;
    }
}
