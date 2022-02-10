package com.zhiyou.model;

public class PayItems {
    private Integer id;

    private String chargeItemName;

    private Double receivableMoney;

    @Override
    public String toString() {
        return "PayItems{" +
                "id=" + id +
                ", chargeItemName='" + chargeItemName + '\'' +
                ", receivableMoney=" + receivableMoney +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChargeItemName() {
        return chargeItemName;
    }

    public void setChargeItemName(String chargeItemName) {
        this.chargeItemName = chargeItemName == null ? null : chargeItemName.trim();
    }

    public Double getReceivableMoney() {
        return receivableMoney;
    }

    public void setReceivableMoney(Double receivableMoney) {
        this.receivableMoney = receivableMoney;
    }
}