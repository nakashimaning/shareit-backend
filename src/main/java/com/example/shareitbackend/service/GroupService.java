package com.example.shareitbackend.service;


import com.example.shareitbackend.dto.GroupDetailResponse;

public interface GroupService {

    GroupDetailResponse getGroupById(Integer groupId);
}
