package com.example.shareitbackend.dto;

import jakarta.validation.constraints.NotNull;

public class GroupRequest {
    @NotNull
    private String groupName;
    @NotNull
    private Integer groupColor;
    @NotNull
    private Integer createdBy;
    @NotNull
    private String currency;
    @NotNull
    private Integer currencyRateType;
    @NotNull
    private Integer mainCategoryId;
    @NotNull
    private Integer subCategoryId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupColor() {
        return groupColor;
    }

    public void setGroupColor(Integer groupColor) {
        this.groupColor = groupColor;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCurrencyRateType() {
        return currencyRateType;
    }

    public void setCurrencyRateType(Integer currencyRateType) {
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
}
