package com.example.lepojo;

import java.math.BigDecimal;

//挖矿奖励
public class MiningReward {
    //手续费
    private BigDecimal miningServiceCharge;
    //挖矿比例
    private String miningRatio;
    //汇率
    private BigDecimal exchangeRate;
    public MiningReward(){}

    public BigDecimal getMiningServiceCharge() {
        return miningServiceCharge;
    }

    public void setMiningServiceCharge(BigDecimal miningServiceCharge) {
        this.miningServiceCharge = miningServiceCharge;
    }

    public String getMiningRatio() {
        return miningRatio;
    }

    public void setMiningRatio(String miningRatio) {
        this.miningRatio = miningRatio;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
