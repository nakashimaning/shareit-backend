package com.example.shareitbackend.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GroupContents {
    private Integer groupId;
    private String groupName;
    private String groupColor;
    private Integer createdBy;
    private Date createdAt;
    private Date settledAt;
    private String currency;
    private Byte currencyRateType;
    private Integer mainCategoryId;
    private Integer subCategoryId;
    private Integer status;
    private List<MemberInfo> members;
    private BigDecimal totalExpense;
    private boolean isSettled;

    public Integer getGroupId() { return groupId; }
    public void setGroupId(Integer groupId) { this.groupId = groupId; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getGroupColor() { return groupColor; }
    public void setGroupColor(String groupColor) { this.groupColor = groupColor; }
    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public Date getSettledAt() { return settledAt; }
    public void setSettledAt(Date settledAt) { this.settledAt = settledAt; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public Byte getCurrencyRateType() { return currencyRateType; }
    public void setCurrencyRateType(Byte currencyRateType) { this.currencyRateType = currencyRateType; }
    public Integer getMainCategoryId() { return mainCategoryId; }
    public void setMainCategoryId(Integer mainCategoryId) { this.mainCategoryId = mainCategoryId; }
    public Integer getSubCategoryId() { return subCategoryId; }
    public void setSubCategoryId(Integer subCategoryId) { this.subCategoryId = subCategoryId; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public List<MemberInfo> getMembers() { return members; }
    public void setMembers(List<MemberInfo> members) { this.members = members; }
    public BigDecimal getTotalExpense() { return totalExpense; }
    public void setTotalExpense(BigDecimal totalExpense) { this.totalExpense = totalExpense; }
    public boolean isSettled() { return isSettled; }
    public void setSettled(boolean settled) { isSettled = settled; }
}
