package com.example.shareitbackend.dao.impl;

import com.example.shareitbackend.dao.GroupDao;
import com.example.shareitbackend.model.group.Group;
import com.example.shareitbackend.rowMapper.GroupRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException; // Added import
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GroupDaoImpl implements GroupDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Group getGroupById(Integer groupId) {
        String sql = "SELECT group_id, group_name, group_color, created_by, created_at, settled_at, " +
                "currency, currency_rate_type, main_category_id, sub_category_id, status " +
                "FROM `Groups` WHERE group_id = :groupId";

        Map<String, Object> map = new HashMap<>();
        map.put("groupId", groupId);

        List<Group> groupList = namedParameterJdbcTemplate.query(sql, map, new GroupRowMapper());
        if (groupList.size() > 0) {
            return groupList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createGroup(Group group) {
        String sql = "INSERT INTO `Groups` (group_name, group_color, created_by, created_at, settled_at, " +
                     "currency, currency_rate_type, main_category_id, sub_category_id, status) " +
                     "VALUES (:groupName, :groupColor, :createdBy, :createdAt, :settleAt, " +
                     ":currency, :currencyRateType, :mainCategoryId, :subCategoryId, :status)";

        Map<String, Object> map = new HashMap<>();
        map.put("groupName", group.getGroupName());
        map.put("groupColor", group.getGroupColor());
        map.put("createdBy", group.getCreatedBy());
        map.put("createdAt", group.getCreatedAt());
        map.put("settleAt", group.getSettleAt());
        map.put("currency", group.getCurrency());
        map.put("currencyRateType", group.getCurrencyRateType());
        map.put("mainCategoryId", group.getMainCategoryId());
        map.put("subCategoryId", group.getSubCategoryId());
        map.put("status", group.getStatus());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder, new String[]{"group_id"});

        Number key = keyHolder.getKey();
        if (key != null) {
            return key.intValue();
        } else {
            throw new DataRetrievalFailureException("Failed to retrieve auto-generated key for group_id after insert.");
        }
    }

    @Override
    public void updateGroup(Group group) {
        String sql = "UPDATE `Groups` SET " +
                     "group_name = :groupName, " +
                     "settled_at = :settleAt, " +
                     "currency = :currency, " +
                     "currency_rate_type = :currencyRateType, " +
                     "main_category_id = :mainCategoryId, " +
                     "sub_category_id = :subCategoryId " +
                     "WHERE group_id = :groupId";

        Map<String, Object> map = new HashMap<>();
        map.put("groupId", group.getGroupId());
        map.put("groupName", group.getGroupName());
        map.put("settleAt", group.getSettleAt());
        map.put("currency", group.getCurrency());
        map.put("currencyRateType", group.getCurrencyRateType());
        map.put("mainCategoryId", group.getMainCategoryId());
        map.put("subCategoryId", group.getSubCategoryId());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
