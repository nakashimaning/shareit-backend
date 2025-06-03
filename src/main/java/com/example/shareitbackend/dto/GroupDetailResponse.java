package com.example.shareitbackend.dto;

import org.springframework.http.HttpStatus;

public class GroupDetailResponse {
    private int statusCode;
    private String errorCode;
    private String errorMessage;
    private String page;
    private GroupContents contents;


    public GroupDetailResponse() {
        this.statusCode = HttpStatus.OK.value();
        this.errorCode = "";
        this.errorMessage = "";
        this.page = null;
    }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    public Object getPage() { return page; }
    public void setPage(String page) { this.page = page; }
    public GroupContents getContents() { return contents; }
    public void setContents(GroupContents contents) { this.contents = contents; }
}
