package com.satyam.smartqueue.websocket;

public class QueueUpdateMessage {

    private String message;
    private Long tokenId;
    private String tokenNumber;
    private String status;
    private Long departmentId;

    public QueueUpdateMessage() {
    }

    public QueueUpdateMessage(String message,
                              Long tokenId,
                              String tokenNumber,
                              String status,
                              Long departmentId) {

        this.message = message;
        this.tokenId = tokenId;
        this.tokenNumber = tokenNumber;
        this.status = status;
        this.departmentId = departmentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
