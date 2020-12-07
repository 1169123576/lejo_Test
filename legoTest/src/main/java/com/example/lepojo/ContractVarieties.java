package com.example.lepojo;

import java.math.BigDecimal;

//合约属性
public class ContractVarieties {
    //合约品种
    private String currencyStandard;
    //合约面值（张）
    private BigDecimal contractFaceValue;
    //最小变动价位
    private BigDecimal minimumPriceChange;
    //持仓数量
    private int numberOfPositions;
    //持仓均价
    private BigDecimal averagePrice;
    //账户总权益
    private BigDecimal totalEquity;
    //可用余额
    private BigDecimal availableBalance;
    //总浮动盈亏
    private BigDecimal totalProfit;
    public ContractVarieties() {
    }


    public String getCurrencyStandard() {
        return currencyStandard;
    }

    public void setCurrencyStandard(String currencyStandard) {
        this.currencyStandard = currencyStandard;
    }

    public BigDecimal getContractFaceValue() {
        return contractFaceValue;
    }

    public void setContractFaceValue(BigDecimal contractFaceValue) {
        this.contractFaceValue = contractFaceValue;
    }

    public BigDecimal getMinimumPriceChange() {
        return minimumPriceChange;
    }

    public void setMinimumPriceChange(BigDecimal minimumPriceChange) {
        this.minimumPriceChange = minimumPriceChange;
    }

    public Integer getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(Integer numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalEquity() {
        return totalEquity;
    }

    public void setTotalEquity(BigDecimal totalEquity) {
        this.totalEquity = totalEquity;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }
}
