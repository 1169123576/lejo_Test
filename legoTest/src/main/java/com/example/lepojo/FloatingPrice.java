package com.example.lepojo;

import java.math.BigDecimal;

//浮动交易属性
public class FloatingPrice {
    /*可用保证金*/
    private BigDecimal bond;
    /*持仓占用保证金*/
    private  BigDecimal marginOccupied;
    //委托占用保证金
    private  BigDecimal entrustedOccupation;
    //市场价格
    private  BigDecimal marketPrice;
    //杠杆倍数
    private  int leverMultiple;
    //成交张数
    private  int fixtureNumber;
    //手续费
    private  BigDecimal serviceCharge;

    public FloatingPrice(){
    }

    public BigDecimal getBond() {
        return bond;
    }

    public void setBond(BigDecimal bond) {
        this.bond = bond;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getLeverMultiple() {
        return leverMultiple;
    }

    public void setLeverMultiple(Integer leverMultiple) {
        this.leverMultiple = leverMultiple;
    }

    public Integer getFixtureNumber() {
        return fixtureNumber;
    }

    public void setFixtureNumber(Integer fixtureNumber) {
        this.fixtureNumber = fixtureNumber;
    }

    public BigDecimal getMarginOccupied() {
        return marginOccupied;
    }

    public void setMarginOccupied(BigDecimal marginOccupied) {
        this.marginOccupied = marginOccupied;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getEntrustedOccupation() {
        return entrustedOccupation;
    }

    public void setEntrustedOccupation(BigDecimal entrustedOccupation) {
        this.entrustedOccupation = entrustedOccupation;
    }
}
