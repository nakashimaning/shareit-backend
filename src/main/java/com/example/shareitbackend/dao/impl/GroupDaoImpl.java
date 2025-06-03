package com.example.shareitbackend.dao.impl;

import com.example.shareitbackend.dao.GroupDao;
import com.example.shareitbackend.model.group.Group;
import com.example.shareitbackend.rowMapper.GroupRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

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
}
