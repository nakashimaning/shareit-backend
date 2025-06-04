package com.example.shareitbackend.dao;

import com.example.shareitbackend.model.group.Group;

public interface GroupDao {

    Group getGroupById(Integer groupId);

    Integer createGroup(Group group);
}
