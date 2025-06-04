package com.example.shareitbackend.service.impl;

import com.example.shareitbackend.dao.GroupDao;
import com.example.shareitbackend.dto.GroupContents;
import com.example.shareitbackend.dto.GroupDetailResponse;
import com.example.shareitbackend.dto.MemberInfo;
import com.example.shareitbackend.model.group.Group;
import com.example.shareitbackend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.example.shareitbackend.dto.GroupRequest;
import java.util.Date;

@Component
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public GroupDetailResponse getGroupById(Integer groupId) {
        Group group = groupDao.getGroupById(groupId);

        if (group == null) {
            return null;
        }

        GroupDetailResponse response = new GroupDetailResponse();
        GroupContents contents = new GroupContents();


        contents.setGroupId(group.getGroupId());
        contents.setGroupName(group.getGroupName());


        if (group.getGroupColor() != null) {
            contents.setGroupColor(String.valueOf(group.getGroupColor()));
        } else {
            contents.setGroupColor(null);
        }

        contents.setCreatedBy(group.getCreatedBy());
        contents.setCreatedAt(group.getCreatedAt());
        contents.setSettledAt(group.getSettleAt());
        contents.setCurrency(group.getCurrency());
        contents.setCurrencyRateType(group.getCurrencyRateType());
        contents.setMainCategoryId(group.getMainCategoryId());
        contents.setSubCategoryId(group.getSubCategoryId());
        contents.setStatus(group.getStatus());

        // TODO: 確認要提供哪些資訊
        contents.setMembers(new ArrayList<MemberInfo>());

        // TODO: 群組總支出
        contents.setTotalExpense(BigDecimal.ZERO);

        // TODO: 是否已結算
        contents.setSettled(true);

        response.setContents(contents);
        return response;
    }

    @Override
    public Integer createGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());

        if (groupRequest.getGroupColor() != null) {
            group.setGroupColor(String.valueOf(groupRequest.getGroupColor()));
        }

        group.setCreatedBy(groupRequest.getCreatedBy());
        group.setCurrency(groupRequest.getCurrency());

        if (groupRequest.getCurrencyRateType() != null) {
            group.setCurrencyRateType(groupRequest.getCurrencyRateType().byteValue());
        }

        group.setMainCategoryId(groupRequest.getMainCategoryId());
        group.setSubCategoryId(groupRequest.getSubCategoryId());

        Date createdAtDate = new Date();
        group.setCreatedAt(createdAtDate);

        // 結算日預設為起始日期的兩週後
        java.time.LocalDateTime createdAtLocalDateTime = createdAtDate.toInstant()
                                                                    .atZone(java.time.ZoneId.systemDefault())
                                                                    .toLocalDateTime();
        java.time.LocalDateTime settledAtLocalDateTime = createdAtLocalDateTime.plusWeeks(2);
        Date settledAtDate = java.util.Date.from(settledAtLocalDateTime.atZone(java.time.ZoneId.systemDefault())
                                                                        .toInstant());
        group.setSettleAt(settledAtDate);
        group.setStatus(0);

        Integer newGroupId = groupDao.createGroup(group);
        return newGroupId;
    }

    @Override
    public void updateGroup(Integer groupId, GroupRequest groupRequest) {
        Group group = groupDao.getGroupById(groupId);

        if (group == null) {
           throw new RuntimeException("Group not found with id: " + groupId);
        }
        if (groupRequest.getGroupName() != null) {
            group.setGroupName(groupRequest.getGroupName());
        }
        if (groupRequest.getCurrency() != null) {
            group.setCurrency(groupRequest.getCurrency());
        }
        if (groupRequest.getCurrencyRateType() != null) {
            group.setCurrencyRateType(groupRequest.getCurrencyRateType().byteValue());
        }
        if (groupRequest.getMainCategoryId() != null) {
            group.setMainCategoryId(groupRequest.getMainCategoryId());
        }
        if (groupRequest.getSubCategoryId() != null) {
            group.setSubCategoryId(groupRequest.getSubCategoryId());
        }

        groupDao.updateGroup(group);
    }
}
