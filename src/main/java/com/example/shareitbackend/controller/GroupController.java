package com.example.shareitbackend.controller;

import com.example.shareitbackend.dto.GroupDetailResponse;
import com.example.shareitbackend.dto.GroupRequest;
import com.example.shareitbackend.model.group.Group;
import com.example.shareitbackend.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/group/getGroupDetail/{groupId}")
    public ResponseEntity<GroupDetailResponse> getGroupDetail(@PathVariable Integer groupId) {
        GroupDetailResponse groupDetailResponse = groupService.getGroupById(groupId);

        if(groupDetailResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(groupDetailResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/group/createGroup")
    public ResponseEntity<GroupDetailResponse> createGroup(@RequestBody @Valid GroupRequest groupRequest) {
        Integer groupId = groupService.createGroup(groupRequest);
        GroupDetailResponse groupDetail = groupService.getGroupById(groupId);

        if (groupDetail != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(groupDetail);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    }

    @PutMapping("group/updateGroup/{groupId}")
    public ResponseEntity<GroupDetailResponse> updateGroup(@PathVariable Integer groupId,
                                                           @RequestBody @Valid GroupRequest groupRequest) {
        GroupDetailResponse group = groupService.getGroupById(groupId);

        // 檢查group是否存在
        if(group == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改group數據
        groupService.updateGroup(groupId, groupRequest);

        GroupDetailResponse groupDetail = groupService.getGroupById(groupId);

        return ResponseEntity.status(HttpStatus.OK).body(groupDetail);
    }

    @DeleteMapping("group/deleteGroup/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer groupId) {
        groupService.deleteGroup(groupId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}