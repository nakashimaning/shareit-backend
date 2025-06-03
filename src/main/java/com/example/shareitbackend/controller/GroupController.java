package com.example.shareitbackend.controller;

import com.example.shareitbackend.dto.GroupDetailResponse;
import com.example.shareitbackend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/group/getGroupDetail/{groupId}")
    ResponseEntity<GroupDetailResponse> getGroupDetail(@PathVariable Integer groupId) {
        GroupDetailResponse groupDetailResponse = groupService.getGroupById(groupId);

        if(groupDetailResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(groupDetailResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}