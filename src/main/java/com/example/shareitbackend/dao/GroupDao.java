package com.example.shareitbackend.dao;

import com.example.shareitbackend.model.group.Group;

public interface GroupDao {

    Group getGroupById(Integer groupId);

    Integer createGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(Integer groupId);
}
