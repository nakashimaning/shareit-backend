package com.example.shareitbackend.service;

import com.example.shareitbackend.dto.GroupDetailResponse;
import com.example.shareitbackend.dto.GroupRequest;

public interface GroupService {

    GroupDetailResponse getGroupById(Integer groupId);

    Integer createGroup(GroupRequest groupRequest);

    void updateGroup(Integer groupId, GroupRequest groupRequest);
}
