package com.example.shareitbackend.model.group;

import java.util.Date;

public class Group {
    private Integer groupId;
    private String groupName;
    private String groupColor;
    private Integer createdBy;
    private Date createdAt;
    private Date settleAt;
    private String currency;
    private Byte currencyRateType;
    private Integer mainCategoryId;
    private Integer subCategoryId;
    private Integer status;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupColor() {
        return groupColor;
    }

    public void setGroupColor(String groupColor) {
        this.groupColor = groupColor;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getSettleAt() {
        return settleAt;
    }

    public void setSettleAt(Date settleAt) {
        this.settleAt = settleAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Byte getCurrencyRateType() {
        return currencyRateType;
    }

    public void setCurrencyRateType(Byte currencyRateType) {
        this.currencyRateType = currencyRateType;
    }

    public Integer getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(Integer mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
