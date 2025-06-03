package com.example.shareitbackend.rowMapper;

import com.example.shareitbackend.model.group.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupRowMapper implements RowMapper<Group> {

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();

        group.setGroupId(rs.getInt("group_id"));
        group.setGroupName(rs.getString("group_name"));
        group.setCreatedBy(rs.getInt("created_by"));
        group.setCreatedAt(rs.getTimestamp("created_at"));
        group.setSettleAt(rs.getTimestamp("settled_at"));
        group.setCurrency(rs.getString("currency"));
        group.setCurrencyRateType(rs.getByte("currency_rate_type"));
        group.setMainCategoryId(rs.getInt("main_category_id"));
        group.setSubCategoryId(rs.getInt("sub_category_id"));
        group.setStatus(rs.getInt("status"));

        return group;
    }
}
