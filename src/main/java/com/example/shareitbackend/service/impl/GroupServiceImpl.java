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
}
