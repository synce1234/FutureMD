package com.dev.app.futuremd.data;

/**
 * Created by sev_user on 9/20/2017.
 */

public class DumpMessage {
    private String userId;
    private String message;

    public DumpMessage() {
    }

    public DumpMessage(String userId) {
        this.userId = userId;
        message = "Hello! I'm " + userId;
    }

    public DumpMessage(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
